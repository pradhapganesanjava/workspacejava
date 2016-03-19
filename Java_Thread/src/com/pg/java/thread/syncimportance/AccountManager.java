package com.pg.java.thread.syncimportance;

public class AccountManager implements Runnable{

	//private static Account acc = new Account(1000);
	private Account acc = new Account(1000);
	
	public static void main(String[] args) {
		AccountManager runable1 = new AccountManager();
		
		Thread th1 = new Thread(runable1);
		Thread th2 = new Thread(runable1);
		Thread th3 = new Thread(runable1);
		Thread th4 = new Thread(runable1);
		Thread th5 = new Thread(runable1);
		
		th1.setName("A");
		th2.setName("B");
		/*th3.setName("C");
		th4.setName("D");
		th5.setName("E");*/
		
		th1.start();
		th2.start();
		/*th3.start();
		th4.start();
		th5.start();*/
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			makeAccWithdraw(200);
		}
	}
	
	private synchronized void makeAccWithdraw(long amt){
		System.out.println(Thread.currentThread().getName() + ": " + "balance? " + acc.getBalance());
		if(acc.getBalance()<0){
			System.out.println(Thread.currentThread().getName() + ": " + "OVER Withdraw? " + acc.getBalance());
		}else if(acc.getBalance()>=amt){
			System.out.println(Thread.currentThread().getName() + ": " + "withdrawing "+amt);
			try{
				Thread.sleep(600);
			}catch(Exception e){
				System.out.println("e "+e.getMessage());
			}
			acc.withdraw(amt);
			System.out.println(Thread.currentThread().getName() + ": " + "withdraw complete");
		}else{
			System.out.println(Thread.currentThread().getName()+": NO Balance in account");
		}
			
		
	}
}

class Account{
	
	private long balance;
	
	public Account() {
		balance=1000;
	}

	public Account(long balance) {
		this.balance=balance;
	}
	public long getBalance() {
		return balance;
	}

	public void withdraw(long balance) {
			this.balance = this.balance-balance;
	}
}