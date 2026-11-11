1: Streams let you process collections as a pipeline of operations: filter, transform, and collect. Instead of writing loops that manage indexes and temporary variables, you describe what you want.
    - A stream does not store data. It takes data from a source, passes it through operations, and produces a result. Streams are created from collections with stream()

2: Two kinds of operations
    - Intermediate operations return another stream, so you can chain them: filter, map, sorted, distinct, limit.
    - Terminal operations produce a result and end the pipeline: forEach, collect, toList, count, reduce, sum (on primitive streams), findFirst.

3: Nothing runs until a terminal operation is called. This is called lazy evaluation, and it lets Java process elements one at a time instead of building intermediate lists.   

4: Primitive streams
    IntStream, LongStream, and DoubleStream avoid boxing and provide useful methods like sum() and average():

        - int sum = IntStream.rangeClosed(1, 5).sum();   // 15
        double avg = nums.stream().mapToInt(Integer::intValue).average().orElse(0);  // 5.5

        - rangeClosed(1, 5) includes both ends, so it gives 1 through 5. range(1, 5) excludes 5.