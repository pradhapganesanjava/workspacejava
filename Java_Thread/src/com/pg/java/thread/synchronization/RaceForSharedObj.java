package com.pg.java.thread.synchronization;

public class RaceForSharedObj {

	public static void main(String[] args) {

		SharedObj sharedObj = new SharedObj();
		
		Task taskA = new TaskA(sharedObj);
		Task taskB = new TaskB(sharedObj);
		
		TaskRunner t1 = new TaskRunner(taskA);
		TaskRunner t2 = new TaskRunner(taskB);
		t1.setName("T1");
		t2.setName("T2");
		t1.start();
		t2.start();
		try {
			t1.join();//main Daemon thread to join after t1
			t2.join();//main Daemon thread to join after t2
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("End of thread run "+sharedObj.getClickCounter());
		
	}

}


class SharedObj{
	private int clickCounter = 0;
	/*
	 * because click method is invoked by multiple thread same time, It creates RACE situation on clickCounter variable.
	 * each time increments should be done mutual exclusively.
	 */
	public synchronized void click(){
		++this.clickCounter;
	}
	
	public int getClickCounter(){
		return this.clickCounter;
	}
}

class TaskRunner extends Thread{
	Task task = null;
	public TaskRunner(Task task) {
		this.task = task;
	}
	
	@Override
	public void run() {
		this.task.executeTask();
	}
}

class TaskA implements Task{
	SharedObj sharedObj = null;
	public TaskA(SharedObj sharedObj) {
		this.sharedObj = sharedObj;  
	}
	
	@Override
	public void executeTask() {
		for(int i = 0 ; i< 1500; i++){
			if(null!=this.sharedObj) this.sharedObj.click();
			//System.out.println(Thread.currentThread().getName()+" : "+this.sharedObj.getClickCounter());
		}
	}
}

class TaskB implements Task{
	SharedObj sharedObj = null;
	public TaskB(SharedObj sharedObj) {
		this.sharedObj = sharedObj;  
	}
	
	@Override
	public void executeTask() {
		for(int i = 0 ; i< 1000; i++){
			if(null!=this.sharedObj) this.sharedObj.click();
			//System.out.println(Thread.currentThread().getName()+" : "+this.sharedObj.getClickCounter());
		}
	}
}

interface Task{
	public void executeTask();
}