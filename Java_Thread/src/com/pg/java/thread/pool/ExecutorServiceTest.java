package com.pg.java.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceTest {

	public static void main(String[] args) {
		
		//initialize thread pool; create thread overhead avoided
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		//Numb of tasks run at a time by a Thread.
		for(int i=0;i<5;i++){
			executor.submit(new Processor(i));
		}
		//no new task will be acceptted
		executor.shutdown();
		System.out.println("All tasks submitted");
		
		try {
			//How long to wait 1 - hr. this is req. 
			//Executor termination happens 1. Task execution complete. 2. timeout 3. interruption
			executor.awaitTermination(1, TimeUnit.HOURS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("All tasks COMPLETE");
	}

}
class Processor implements Runnable{
	private int id;
	public Processor(int id) {
		this.id=id;
	}
	
	public void run(){
		System.out.println("THREAD:"+Thread.currentThread().getId()+" processing id: "+id);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("THREAD:"+Thread.currentThread().getId()+" complete id: "+id);
	}
}