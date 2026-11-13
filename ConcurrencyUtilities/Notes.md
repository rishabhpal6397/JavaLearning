1: Lesson 18: Concurrency utilities
    - Your last lesson showed that threads need coordination. This lesson covers the higher-level tools in java.util.concurrent that handle it for you.

    - Future and Callable: getting results back

    - Runnable can’t return a value. Callable<T> can, and submit gives you a Future<T> to collect the result later

      - ExecutorService pool = Executors.newFixedThreadPool(2);
        Future<Integer> future = pool.submit(() -> {
            Thread.sleep(1000);            // simulate slow work
            return 6 * 7;
        });

        System.out.println("Waiting...");
        System.out.println(future.get());  // blocks until the result is ready: 42
        pool.shutdown();

        - future.get() blocks until the task finishes, so it’s the point where the main thread waits.


2: CompletableFuture: chaining work
    - CompletableFuture lets you describe steps that run after each other without blocking the main thread:

    - CompletableFuture<String> result = CompletableFuture
        .supplyAsync(() -> 10)
        .thenApply(n -> n * 2)
        .thenApply(n -> "Result: " + n);

    System.out.println(result.join());   // Result: 20

    - supplyAsync runs on a background thread, thenApply transforms the result, and join() waits for the final value.


3: CountDownLatch: wait for N events
    - A CountDownLatch starts at a number and lets threads wait until it reaches zero:

        CountDownLatch latch = new CountDownLatch(3);

        for (int i = 1; i <= 3; i++) {
            int id = i;
            new Thread(() -> {
                System.out.println("Worker " + id + " done");
                latch.countDown();          // reduce the count by one
            }).start();
        }

        latch.await();                      // waits until the count reaches 0
        System.out.println("All workers finished");


3: AtomicInteger.incrementAndGet() performs the whole read-add-write as a single indivisible operation. It uses a low-level CPU instruction, a compare-and-swap, which checks whether the value is still what the thread read. If another thread changed it in the meantime, the operation retries with the new value. No thread ever holds a lock, so no increment is lost.

The difference from synchronized:
    - synchronized makes other threads wait. Only one thread at a time can enter the method, and the others block until it leaves.
    - Atomic operations don’t block. Threads attempt the update, and if one collides with another, it retries. Under light contention this is usually faster, because nothing waits for a lock.

    - Both give correct results here. Use synchronized when you need to protect several related fields or a longer block of code together. Use an atomic class for a single value that one operation updates.