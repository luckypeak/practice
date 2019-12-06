import java.io.PrintStream;
import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * https://leetcode-cn.com/problems/print-zero-even-odd/
 * 1116. 打印零与奇偶数
 * 关键在于何时唤醒和休眠
 * 可以基于lock 和 sync， wait notify all
 */
public class ZeroEvenOdd {
    private int n;
    private int num = 1;
    private Semaphore semaphoreZero;
    private Semaphore semaphoreOdd;
    private Semaphore semaphoreEven;
    PrintStream out;


    public ZeroEvenOdd(int n) {
        this.n = n;
        semaphoreOdd = new Semaphore(1);
        semaphoreZero = new Semaphore(1);
        semaphoreEven = new Semaphore(1);
        this.out = new PrintStream(System.out);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            semaphoreZero.acquire();
            printNumber.accept(0);
            if (i % 2 == 0) {
                semaphoreEven.release();
            } else {
                semaphoreOdd.release();
            }
        }


    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2 ; i <= n; i+=2) {
            semaphoreEven.acquire();
            printNumber.accept(i);
            semaphoreZero.release();
        }

    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i=1; i <= n; i+=2) {
            semaphoreOdd.acquire();
            printNumber.accept(i);
            semaphoreZero.release();
        }
    }

    private synchronized  void print(int x){
        System.out.println(x);
    }
    public static void main(String[] args) throws InterruptedException {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(100);
        Thread t1 = new Thread(() -> {
            try {
                zeroEvenOdd.zero(zeroEvenOdd::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                zeroEvenOdd.odd(zeroEvenOdd::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                zeroEvenOdd.even(zeroEvenOdd::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t1.join();

    }
}
