package com.pg.java.thread.wait;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WaitNotifyOnQueue {
 
	Queue<Integer> toProcess = new LinkedList<Integer>();
	final static int LIMIT = 1000000; 
	final static int MOD_LIMIT = 1000;
	
	public static void main(String...str){
		
		WaitNotifyOnQueue thisObj = new WaitNotifyOnQueue();
		
		Thread loaderT = new Thread(thisObj::loaderTask); 
		Thread unLoaderT = new Thread(() -> {
												try {
													thisObj.unLoadTask();
												} catch (InterruptedException e) {
													e.printStackTrace();
												}
											}); 
		
		loaderT.setName("loader");
		unLoaderT.setName("unloader");
		
		loaderT.start();
		unLoaderT.start();
	}
	
	private  void loaderTask(){
		final Loader loader = new Loader(toProcess);
		synchronized(toProcess){
			try{
				while(toProcess.size() <= LIMIT){
					int size = toProcess.size();
					int count = size+1;
					if(count % MOD_LIMIT ==0){
						System.out.println("loader: "+count);
					}
					
					loader.load(count);

//					if(){
						System.out.println("........................ Loader: release LOCK");
						System.out.println("........................ Loader: wait for LOCK");
						toProcess.wait();
						System.out.println("........................ Loader acquire LOCK");
//					}
				}
				toProcess.notify();
			}catch(InterruptedException e){
				System.out.println(e.getMessage());
			}
		}
	}
	
	private void unLoadTask() throws InterruptedException {
		final UnLoader unLoader = new UnLoader(toProcess);
		synchronized(toProcess){
				while(toProcess.size() > 0){
					int unLoadInt = unLoader.unLoad();
					if(unLoadInt % MOD_LIMIT ==0){
						System.out.println("unloader: "+unLoadInt);
					}
					
//					if(){
						System.out.println("........................ UnLoader: release LOCK");
						System.out.println("........................ UnLoader: wait for LOCK");
						toProcess.wait();
						System.out.println("........................ UnLoader acquire LOCK");
//					}
				}
				
				toProcess.notify();
		}
	}
	
}

class Loader{
	static Queue<Integer> intQueue = null;
	
	public Loader(Queue<Integer> intQueue) {
		this.intQueue = intQueue;
	}
	public boolean load(Integer intV){
		intQueue.add(intV);
		return true;
	}
}

class UnLoader{
	static Queue<Integer> intQueue = null;
	
	public UnLoader(Queue<Integer> intQueue) {
		this.intQueue = intQueue;
	}
	
	public Integer unLoad(){
		if(null != intQueue){
			return intQueue.poll();
		}
		return -1;
	}
}