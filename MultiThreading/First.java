package MultiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class First {
    public static void main(String[] args) throws InterruptedException {
        // Exercise: 1
        Thread t1 = new Thread(() -> {
            for(int i = 1; i <= 5; i++){
                System.out.println(Thread.currentThread().getName());
            }
        },"Thread-A");

        Thread t2 = new Thread(() -> {
            for(int i = 1; i <= 5; i++){
                System.out.println(Thread.currentThread().getName());
            }
        },"Thread-B");

        t1.start();
        t2.start();
        // The output can be either grouped or interleaved

        // Exercise: 2
        Counter counter = new Counter();

        Runnable task = () -> {
            for (int i = 0; i < 1000000; i++) {
                counter.increment();
            }
        };

        Thread t3 = new Thread(task);
        Thread t4 = new Thread(task);

        t3.start();
        t4.start();

        t3.join();
        t4.join();

        System.out.println("Final Count: " + counter.count);


        // Exercise: 3
        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 1; i <= 4; i++) {

            final int taskNumber = i;

            executor.submit(() -> {
                System.out.println(
                    "Task " + taskNumber +
                    " executed by " +
                    Thread.currentThread().getName()
                );
            });
        }

        executor.shutdown();

        // Exercise: 4
        // In executing count++ the java runs 3 operations Read, Increment & Write. And if 2 threads are execuing it at the same time one increment will be lost which causes race condition and to prevent this we have synchronized, Locks, etc.
    }
}

class Counter {

    int count = 0;

    // public void increment() {
    //     count++;
    // }
    public synchronized void increment() {
        count++;
    }
}

