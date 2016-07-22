package com.pg.ds.queue;

public class QueueCircular<E> {

	E[] queueArr = null;
	int first = 0;
	int last = 0;

	public QueueCircular(int capacity) {
		queueArr = (E[]) (new Object[capacity]);
	}

	public void add(E addObj) {
		queueArr[last] = addObj;
		last = last+1;
		//if(last>queueArr.length && )
	}

	public E poll() {
		E pollE = queueArr[first];
		return pollE;
	}

	
}
