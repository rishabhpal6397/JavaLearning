1: Lambdas let you write small pieces of behaviour and pass them around as values, which is especially useful with collections.
    - Lambda syntax
        A lambda is a short anonymous function:

        (parameters) -> expression
        (parameters) -> { statements; }

        It’s used wherever Java expects a functional interface, an interface with exactly one abstract method (from the interfaces lesson).

2: Common functional interfaces

    These are in java.util.function, and they cover most cases:

    Interface	         Method	              Meaning
    Predicate<T>	boolean test(T t)	check a condition
    Function<T, R>	R apply(T t)	    transform a value
    Consumer<T>	    void accept(T t)	do something with a value
    Supplier<T>	    T get()	            produce a value

3: List.of creates an immutable list, so removeIf would throw an exception on it. Use new ArrayList<>(List.of(...)) when you need to modify the list.