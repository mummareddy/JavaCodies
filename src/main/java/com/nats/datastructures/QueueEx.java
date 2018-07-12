package com.nats.datastructures;

import java.util.Collection;
import java.util.Iterator;

public class QueueEx {

	public static void main(String[] args) {
		Queue queue = new Queue(10);
		queue.displayQueue();
		queue.removeRear();
		queue.addToQueue(10);
		queue.addToQueue(20);
		queue.addToQueue(30);
		queue.addToFront(40);
		queue.displayQueue();
		queue.removeRear();
		System.out.println("-----");
		queue.displayQueue();		
		
	}
}

class Queue {
	int val;
	int [] queue = null;
	int size ;
	int length = 0;
	int head ;
	int tail;
	
	public Queue(int size) {
		this.size = size;
		queue = new int [size];
		length = 0;
		head = 0;
		tail = 0;
	}
	
	public void addToQueue(int num) {
		if (tail>=size) {
			System.out.println("Queue is full");
			return;
		} else {
			queue[tail++] = num;
			length++;
		}
	}
	
	public void addToFront(int num) {
		if (head==tail) {
			queue[0] = num;
			head=tail=0;
		} else {
			System.arraycopy(queue, 0, queue, 1, length);
			queue[0] = num;
			tail++;
			length++;
		}
	}

	
	
	public int removeFromQueue() {
		if (head==tail) {
			System.out.println("No item to remove");
			return -1;
		} else {
			int num = queue[head];
			head++;
			length--;
			return num;
		}
	}
	
	public int removeRear() {
		if (head==tail) {
			System.out.println("No item to remove");
			return -1;
		} else {
			int num = queue[tail];
			tail--;
			length--;
			return num;
		}
	}


	
	public void displayQueue() {
		for (int i = head; i < tail; i++) {
			System.out.println(queue[i]);
		}
	}
	
}
