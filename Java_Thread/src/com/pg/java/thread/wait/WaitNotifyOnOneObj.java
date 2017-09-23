package com.pg.java.thread.wait;

public class WaitNotifyOnOneObj {

	Mediator mediator = new Mediator();
	
	public static void main(String...str){
		
		WaitNotifyOnOneObj thisObj = new WaitNotifyOnOneObj();

		
		Thread sendT = new Thread(thisObj::announce); 
		Thread receiveT = new Thread(thisObj::ack);
		
		sendT.setName("sender");
		receiveT.setName("receiver");
		
		sendT.start();
		receiveT.start();
	}
	
	public void announce(){
		if(null == mediator) return;
		int msgCount = 0;
		synchronized(mediator){
			try{
				while(!mediator.isSent()){
						String msg = "Is any one available. msg# "+msgCount++;
						System.out.println("Send: msg "+msg);
						
						mediator.setMessage(msg);
						mediator.setSent(true);
						mediator.setReceived(false);
						
						System.out.println("...................... Send: lock release");
						mediator.notify();
						if(msgCount > 100){ mediator.setShutdown(true);}
						if(mediator.shutdown){break;}
						System.out.println("...................... Send: wait for Lock");
						mediator.wait();
						System.out.println("...................... Send: got Lock");
				}
			}catch(InterruptedException e){
				System.out.println(e.getMessage());
			}
		}
		System.out.println("................SEND EXIT.............");
	}
	
	private void ack(){
		if(null == mediator) return;
		synchronized(mediator){
			try{
				while(!mediator.isReceived()){
						System.out.println("Received msg "+mediator.getMessage());
						
						mediator.setMessage(null);
						mediator.setSent(false);
						mediator.setReceived(true);
						
						System.out.println("...................... ack: lock release");
						mediator.notify();
						if(mediator.shutdown){break;}
						System.out.println("...................... ack: wait for Lock");
						mediator.wait();
						System.out.println("...................... ack: got Lock");
				}
			}catch(InterruptedException e){
				System.out.println(e.getMessage());
			}
		}
		System.out.println("................ACK EXIT.............");
	}
	
}

class Mediator{
	String message = null;
	boolean sent = false;
	boolean received = false;
	
	boolean shutdown = false;
	
	public String getMessage() {
		return message;
	}
	public boolean isSent() {
		return sent;
	}
	public boolean isReceived() {
		return received;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setSent(boolean sent) {
		this.sent = sent;
	}
	public void setReceived(boolean received) {
		this.received = received;
	}
	public boolean isShutdown() {
		return shutdown;
	}
	public void setShutdown(boolean shutdown) {
		this.shutdown = shutdown;
	}
}