package com.pg.java.thread.whythread;

import java.util.HashMap;
import java.util.Map;

public class SynchronizedReq_SharedObj {

	public static void main(String[] args) {

		Map<Integer,String> lifeStages = new HashMap<>();
		lifeStages.put(1, "infancy");
		lifeStages.put(3, "toddler");
		lifeStages.put(8, "childhood");
		lifeStages.put(13, "puberty");
		lifeStages.put(18, "adolescene");
		lifeStages.put(30, "adulthood");
		lifeStages.put(50, "middleage");
		
		LifeStage ls = new LifeStage(); 
		Object obj = new Object();
		
		int MAX_CNT = 50000;
		
		Thread th1 = new Thread( ()->{
			int cnt = 0;
			while(true){
				synchronized(obj){
					for(Integer key:lifeStages.keySet()){
						ls.setMaxAge(key);
						ls.setStage(lifeStages.get(key));
						System.out.println(Thread.currentThread().getName()+" "+ls.toString());
					}
				}
				if(++cnt>=MAX_CNT){
					break;
				}
			}
		});
		th1.start();
		
		
		Thread th2 = new Thread( ()->{
			int cnt = 0;
			while(true){
				synchronized(obj){
					for(Integer key:lifeStages.keySet()){
						ls.setMaxAge(key);
						ls.setStage(lifeStages.get(key));
						System.out.println(Thread.currentThread().getName()+" "+ls.toString());
					}
				}
				if(++cnt>=MAX_CNT){
					break;
				}
			}
		});
		th2.start();
		
		//sync_Nonsync_CompareWithCounter();
	}

	private static void sync_Nonsync_CompareWithCounter() {
		Counter cnt = new Counter();
//		SyncCounter cnt = new SyncCounter();
		
		int MAX_CNT = 500000;
		Thread th1 = new Thread( ()->{
			while(true){
				System.out.println(Thread.currentThread().getName()+" getCount "+cnt.getCount()+" incCnt "+cnt.increCount());
				if(cnt.getCount()>=MAX_CNT){
					break;
				}
			}
		});
		th1.start();
		
		Thread th2 = new Thread( ()->{
			while(true){
				System.out.println(Thread.currentThread().getName()+" getCount "+cnt.getCount()+" incCnt "+cnt.increCount());
				if(cnt.getCount()>=MAX_CNT){
					break;
				}
			}
		});
		th2.start();
	}

}

class LifeStage{
	private int maxAge;
	private String stage;

	public int getMaxAge() {
		return maxAge;
	}
	public String getStage() {
		return stage;
	}
	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}
	public void setStage(String stage) {
		this.stage = stage;
	}
	public String toString(){
		return this.maxAge+" : "+this.stage;
	}
}

class Counter implements CounterBase{
	private int count=0;
	@Override
	public int increCount(){
		return ++this.count;
	}
	public int decreCount(){
		return --this.count;
	}
	@Override
	public int getCount(){
		return this.count;
	}
}


class SyncCounter implements CounterBase{
	private int count=0;
	@Override
	public synchronized int increCount(){
		return ++this.count;
	}
	public synchronized int decreCount(){
		return --this.count;
	}
	@Override
	public synchronized int getCount(){
		return this.count;
	}
}
interface CounterBase{
	int increCount();
	int getCount();
}