package com.lk.thread;

import java.util.concurrent.Semaphore;

class ThreadA implements Runnable {
    Semaphore sema;
    Semaphore semb;

    ThreadA(Semaphore semaphorea, Semaphore semaphoreb) {
        sema = semaphorea;
        semb = semaphoreb;
    }

    public void run() {
        while (true){
            try {
                sema.acquire();
                System.out.println("a");
                semb.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ThreadB implements Runnable {
    Semaphore sema;
    Semaphore semb;

    ThreadB(Semaphore semaphorea, Semaphore semaphoreb) {
        sema = semaphorea;
        semb = semaphoreb;
    }

    public void run() {
        while (true){
            try {
                semb.acquire();
                System.out.println("b");
                sema.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class InTurnPrint {

    public static void main(String[] args) {
        Semaphore sema = new Semaphore(1);
        Semaphore semb = new Semaphore(0);
        new Thread(new ThreadA(sema, semb)).start();
        new Thread(new ThreadB(sema, semb)).start();
    }
}
