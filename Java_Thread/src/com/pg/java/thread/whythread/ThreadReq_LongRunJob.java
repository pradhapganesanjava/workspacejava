package com.pg.java.thread.whythread;

public class ThreadReq_LongRunJob {

	public static void main(String[] args) {
//		noThread();
		yesThread();
	}

	private static void yesThread() {
		int LONG_RUN_JOB_CNT = 50000;
		
		Thread th2 = new Thread(()->{
			int intTh2= 1;
			System.out.println(" ****************** deamon thread2 started");
			while(true){
				if(intTh2%100==0){
					System.out.println("------------------- daemon thread2 running "+intTh2);
				}
				intTh2++;
			}
		});
		th2.setDaemon(true);
		th2.start();		
		
		System.out.println("****************** main daemon thread started...");
		
		System.out.println("long run job started");
		Runnable run1 = ()->{
			for (int i = 1; i < LONG_RUN_JOB_CNT; i++) {
				if (i % 10  == 0) {
					System.out.println(i);
				}
				if(i+1>=LONG_RUN_JOB_CNT)System.out.println("****************** long run job ended");
			}
		};
		Thread th = new Thread(run1);
		th.start();
		
		System.out.println(" ****************** main thread NOT waiting...");
		System.out.println(" ****************** main thread execution complete.");

	}
	
	private static void noThread() {
		int LONG_RUN_JOB_CNT = 50000;
		System.out.println("main daemon thread started...");
		
		System.out.println("long run job started");
		for (int i = 1; i < LONG_RUN_JOB_CNT; i++) {
			if (i % 10  == 0) {
				System.out.println(i);
			}
		}
		System.out.println("long run job ended");

		System.out.println("main thread waited, until long thread run...");
		System.out.println("main thread execution complete.");
	}

}


class A implements BInterf{
	@Override
	public void run() {
		
	}
}
interface BInterf{
	public void run();
}