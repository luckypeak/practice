package com.lk.thread;


import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

class Producter implements Runnable {
    Queue queue;
    Object lock;

    Producter(Queue queue, Object lock) {
        this.queue = queue;
        this.lock = lock;
    }


    public void run() {
        while (true) {
            synchronized (lock) {
                while (this.queue.size() < 10) {
                    System.out.println("product test");
                    this.queue.add("test");
                    lock.notifyAll();
                }
            }
        }

    }
}

class Consumer implements Runnable {
    Queue queue;
    Object lock;

    Consumer(Queue queue, Object lock) {
        this.queue = queue;
        this.lock = lock;
    }

    public void run() {
        while (true) {
            synchronized (this.lock) {
                while (queue.isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("consume " + queue.poll());

            }
        }

    }


}

public class ProductAndConsumer {
    static Queue queue = new ArrayBlockingQueue(10);
    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(new Producter(queue, lock)).start();
        }
        for (int i = 0; i < 10; i++) {
            new Thread(new Consumer(queue, lock)).start();
        }
    }

}
