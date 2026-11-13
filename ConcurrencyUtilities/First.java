import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class First{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Exercise: 1
        ExecutorService pool = Executors.newSingleThreadExecutor();

        Callable<Integer> sumTask = () ->{
            int sum = 0;
            for (int i = 1; i <= 100; i++){
                sum += i;
            }
            return sum;
        };

        Future<Integer> future = pool.submit(sumTask);
        Integer result = future.get();
        System.out.println(result);

        pool.shutdown();

        // Exercise: 2
        CompletableFuture<Void> result2 = CompletableFuture
            .supplyAsync(() -> 9)
            .thenApply(n -> n * n)
            .thenAccept(n -> System.out.println(n));// 81

        // Exercise: 3
        CountDownLatch latch = new CountDownLatch(4);

        for (int i = 1; i <= 4; i++) {
            int id = i;
            new Thread(() -> {
                System.out.println("Worker " + id + " done");
                latch.countDown();          // reduce the count by one
            }).start();
        }

        latch.await();                      // waits until the count reaches 0
        System.out.println("All workers finished");

        // Exercise: 4
        Counter counter = new Counter();

        Runnable task = () -> {
            for (int i = 0; i < 1000000; i++) {
                counter.increment();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Count: " + counter.getCount());
    }
}

class Counter {

    AtomicInteger count = new AtomicInteger(0);

    public void increment() {
        count.incrementAndGet();
    }

    public int getCount() {
        return count.get();
    }
}