package com.pg.java.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecTest {

	public static void main(String[] args) {
		//singleThreadedExecutor();
		fixedThreadExecutor();
	}
	/**
	 * runnable tasks executes one by one;
	 * No explicit synchronization req for this case. 
	 */
	private static void singleThreadedExecutor() {
		ExecutorService exeSrv = Executors.newSingleThreadExecutor();
		exeSrv.execute(new TaskRunner(new PrintOdd(100)));
		exeSrv.execute(new TaskRunner(new PrintEven(100)));
		exeSrv.shutdown();
	}
	/**
	 * runnable tasks exceeds threads; then tasks will be waiting.  
	 */
	private static void fixedThreadExecutor() {
		ExecutorService exeSrv = Executors.newFixedThreadPool(2);
		exeSrv.execute(new TaskRunner(new PrintOdd(1000)));
		exeSrv.execute(new TaskRunner(new PrintEven(1000)));
		exeSrv.shutdown();
	}
	
	/**
	 * runnable tasks NOT exceeds threads; then tasks will NOT be waiting for thread; 
	 * As many threads will be created or reused.  
	 */
	private static void cachedThreadExecutor() {
		ExecutorService exeSrv = Executors.newCachedThreadPool();
		exeSrv.execute(new TaskRunner(new PrintOdd(1000)));
		exeSrv.execute(new TaskRunner(new PrintEven(1000)));
		exeSrv.shutdown();
	}
}

interface Task{ void runTask();}
class TaskRunner implements Runnable{
	private Task task = null;
	public TaskRunner(Task task) {
		this.task = task;
	}
	
	@Override
	public void run() {
		task.runTask();
	}
}

class PrintOdd implements Task{
	int threshold = 0;
	public PrintOdd(int threshold) {
		this.threshold = threshold;
	}
	
	@Override
	public void runTask() {
		System.out.println("..............ODD THREAD STARTED............");
		for(int i=0; i<threshold;i++){
			if((i%2)!=0){
				System.out.println("ODD: "+i);
			}
		}
	}
}
class PrintEven implements Task{
	int threshold = 0;
	public PrintEven(int threshold) {
		this.threshold = threshold;
	}
	
	@Override
	public void runTask() {
		System.out.println("..............EVEN THREAD STARTED............");
		for(int i=0; i<threshold;i++){
			if((i%2)==0){
				System.out.println("EVEN: "+i);
			}
		}
	}
}