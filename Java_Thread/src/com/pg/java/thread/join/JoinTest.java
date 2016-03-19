package com.pg.java.thread.join;

public class JoinTest implements Runnable{
	private boolean joinBoolean = false;
	
	static ServiceClass srvClass = new ServiceClass();
	
	public static void main(String[] args) {

		JoinTest r1 = new JoinTest();
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r1);
		
		t1.setName("A");
		t2.setName("B");
	
		t1.start();
		t2.start();
	}


	
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			srvClass.multiLayerService(i);
			
			/*try {
				Thread.currentThread().sleep(600);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}*/
			
			/*if (this.joinBoolean) {
				try {
					Thread.currentThread().join();
					this.joinBoolean=false;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}*/
		}
	}
	
	
}

class ServiceClass{
	
	public synchronized void multiLayerService(int count) {
		System.out.println(Thread.currentThread().getName() + ":" + count);
		/*if (count == 5) {
			this.joinBoolean = true;
		}*/
	}
}
