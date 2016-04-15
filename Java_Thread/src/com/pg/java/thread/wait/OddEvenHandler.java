package com.pg.java.thread.wait;

import java.util.Iterator;
import java.util.Stack;

public class OddEvenHandler {

	int[] handlers = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
	//public static Stack intHandlerStack = new Stack();
	//private static Object lockerObj = new Object();

	public Stack intHandlerStack = new Stack();
	public OddEvenHandler() {
		for (int i : handlers) {
			this.intHandlerStack.push(i);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final OddEvenHandler oddEvenHandler = new OddEvenHandler();

		/*Thread oddT = new OddHandler(lockerObj, intHandlerStack);
		Thread evenT = new EvenHandler(lockerObj, intHandlerStack);*/
		Thread oddT = new OddHandler(oddEvenHandler);
		Thread evenT = new EvenHandler(oddEvenHandler);

		oddT.start();
		evenT.start();

		/*
		 * try { oddT.join(); evenT.join(); } catch (InterruptedException e) {
		 * e.printStackTrace(); }
		 */

	}

}

class OddHandler extends Thread {
	private OddEvenHandler oddEvenHandler;

	public OddHandler(OddEvenHandler oddEvenHandler) {
		this.oddEvenHandler = oddEvenHandler;
	}

	@Override
	public void run() {
		boolean run = true;
		while (run) {
			synchronized (oddEvenHandler) {
				if (oddEvenHandler.intHandlerStack.size() == 0) {
					run = false;
					return;
				}

				Integer intPeek = (Integer) oddEvenHandler.intHandlerStack.peek();
				// System.out.println(Thread.currentThread().getId() +
				// " : intPeek  " + intPeek);
				if ((intPeek % 2) == 0) {
					try {
						 System.out.println(Thread.currentThread().getId() +
						 " Wait for Even to RUN ");
						oddEvenHandler.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					Integer intPop = (Integer) oddEvenHandler.intHandlerStack.pop();
					System.out.println(Thread.currentThread().getId() + "	: Processing int " + intPop);
				}
				System.out.println(Thread.currentThread().getId() + " ODD sents Notify");
				oddEvenHandler.notify();
			}
		}
	}
}

class EvenHandler extends Thread {
	private OddEvenHandler oddEvenHandler;

	public EvenHandler(OddEvenHandler oddEvenHandler) {
		this.oddEvenHandler = oddEvenHandler;
	}

	@Override
	public void run() {
		boolean run = true;
		while (run) {
			synchronized (oddEvenHandler) {
				if (oddEvenHandler.intHandlerStack.size() == 0) {
					run = false;
					return;
				}
				Integer intPeek = (Integer) oddEvenHandler.intHandlerStack.peek();
				// System.out.println(Thread.currentThread().getId() +
				// " : intPeek  " + intPeek);
				if ((intPeek % 2) > 0) {
					try {
						 System.out.println(Thread.currentThread().getId() +
						 "Wait for ODD to RUN ");
						oddEvenHandler.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					Integer intPop = (Integer) oddEvenHandler.intHandlerStack.pop();
					System.out.println(Thread.currentThread().getId() + "	: Processing int " + intPop);
				}
				System.out.println(Thread.currentThread().getId() + " EVEN sents Notify");
				oddEvenHandler.notify();
			}
		}
	}
}

/*class OddHandler extends Thread {
	private Object lockerObj;
	Stack intHandlerStack;

	public OddHandler(Object lockerObj, Stack intHandlerStack) {
		this.lockerObj = lockerObj;
		this.intHandlerStack = intHandlerStack;
	}

	@Override
	public void run() {
		boolean run = true;
		while (run) {
			synchronized (lockerObj) {
				if (intHandlerStack.size() == 0) {
					run = false;
					return;
				}

				Integer intPeek = (Integer) intHandlerStack.peek();
				// System.out.println(Thread.currentThread().getId() +
				// " : intPeek  " + intPeek);
				if ((intPeek % 2) == 0) {
					try {
						// System.out.println(Thread.currentThread().getId() +
						// "Wait for Even to RUN ");
						lockerObj.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					Integer intPop = (Integer) intHandlerStack.pop();
					System.out.println(Thread.currentThread().getId() + " : Processing int " + intPop);
				}
				lockerObj.notify();
			}
		}
	}
}

class EvenHandler extends Thread {
	private Object lockerObj;
	private Stack intHandlerStack;

	public EvenHandler(Object lockerObj, Stack intHandlerStack) {
		this.lockerObj = lockerObj;
		this.intHandlerStack = intHandlerStack;
	}

	@Override
	public void run() {
		boolean run = true;
		while (run) {
			synchronized (lockerObj) {
				if (intHandlerStack.size() == 0) {
					run = false;
					return;
				}
				Integer intPeek = (Integer) intHandlerStack.peek();
				// System.out.println(Thread.currentThread().getId() +
				// " : intPeek  " + intPeek);
				if ((intPeek % 2) > 0) {
					try {
						// System.out.println(Thread.currentThread().getId() +
						// "Wait for ODD to RUN ");
						lockerObj.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					Integer intPop = (Integer) intHandlerStack.pop();
					System.out.println(Thread.currentThread().getId() + " : Processing int " + intPop);
				}
				lockerObj.notify();
			}
		}
	}
}*/