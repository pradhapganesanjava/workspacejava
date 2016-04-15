package com.pg.java.thread.reentlock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockHello {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Lock lock = new ReentrantLock();
		PublishSubscribeService pubsubsrv = new PublishSubscribeService(lock);

		Thread pubT = new Thread(new PublishRunner(pubsubsrv));
		Thread subT = new Thread(new SubscribeRunner(pubsubsrv));

		pubT.start();
		subT.start();

	}

}

class PublishSubscribeService {
	Lock lock = null;

	public PublishSubscribeService(Lock lock) {
		this.lock = lock;
	}

	private volatile List<String> listStr = new ArrayList<String>();

	public void publish(String str) {
		System.out.println("publishing " + str);
		//lock.lock();
		try {
			listStr.add(str);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//lock.unlock();
		}
	}

	public void subscribe() {
		System.out.print("subscribed and processing ");
		//lock.lock();
		try {
			if (listStr.size() > 0) {
				System.out.println(listStr.remove(0));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//lock.unlock();
		}
	}

	public List<String> getListStr() {
		return listStr;
	}
}

class PublishRunner extends Thread {
	PublishSubscribeService pubSubSrv = null;

	public PublishRunner(PublishSubscribeService pubSubSrv) {
		this.pubSubSrv = pubSubSrv;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getId() + " PublishRunner: "
				+ pubSubSrv.getListStr().size());
		for (int i = 0; i < 11; i++) {
			pubSubSrv.publish(Integer.toString(i));
		}
	}
}

class SubscribeRunner extends Thread {
	PublishSubscribeService pubSubSrv = null;

	public SubscribeRunner(PublishSubscribeService pubSubSrv) {
		this.pubSubSrv = pubSubSrv;
	}

	@Override
	public void run() {
		/*try {
			sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		System.out.println(Thread.currentThread().getId() + " SubscribeRunner: "
				+ pubSubSrv.getListStr().size());
		while (pubSubSrv.getListStr().size() > 0) {
			pubSubSrv.subscribe();
		}
	}
}
