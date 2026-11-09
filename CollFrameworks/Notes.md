1: ArrayList is fast for reading by index. LinkedList is faster for inserting and removing at the ends, but slower for indexed access. Use ArrayList by default.
    - List allows duplicates
    - Set doesn't allow duplicatges

2: HashSet doesn’t guarantee order. TreeSet keeps elements sorted. LinkedHashSet keeps insertion order.

3: Map is used for key value pairs, Keys are unique. Putting an existing key replaces its value.

4: A Queue is first-in, first-out. A Deque works at both ends and can also act as a stack
    - Prefer ArrayDeque over the old Stack class for stacks.
        Queue<String> line = new LinkedList<>();
        line.offer("A");
        line.offer("B");
        System.out.println(line.poll());     // A, the first one in

        Deque<String> stack = new ArrayDeque<>();
        stack.push("X");
        stack.push("Y");
        System.out.println(stack.pop());     // Y, the last one in

5: Don’t remove elements from a collection inside an enhanced for loop. It throws ConcurrentModificationException. Use an Iterator with remove(), or removeIf, when you need to remove items

6: Choosing a collection
    - Ordered list, index access: ArrayList
    - Unique items: HashSet, or TreeSet for sorted
    - Key-value lookup: HashMap, or TreeMap for sorted keys
    - Queue or stack: ArrayDeque


7: Why Set is faster for “does this exist?”
    - A List checks elements one by one. To find 1000000 in a list of a million items, Java may have to look at all million before it finds it, or confirm it’s missing.
    - A HashSet computes a hash code from the value and jumps straight to the place where that value would be stored. It checks only a few entries, regardless of how big the set is


8: Programmers call these costs O(n) for the list and about O(1) for the set. You don’t need the notation yet, just the idea: the list’s search time grows with its size, and the set’s search time stays nearly constant.
    - The trade-off is that a Set doesn’t keep indexes, so you can’t ask for “the third element.”


9: Generics -> We've been using <Integer>, <String>, and <String, Integer> in angle brackets. Those are generics: they let a class or method work with any type while keeping type safety.
    - Why they exist: Before generics, a list stored Object, so you had to cast when reading and could accidentally put the wrong type in. Generics let the compiler check types for you.
    - Writing our own generic
        class Box<T> {
            private T item;

            public void set(T item) { this.item = item; }
            public T get()          { return item; }
        }

        Box<String> b = new Box<>();
        b.set("Hello");
        System.out.println(b.get().length());   // 5

    - T is a placeholder for a type, chosen when the object is created. You can use any letter, but T (type), E (element), K (key), and V (value) are the common conventions.

    - Generic methods
        A method can have its own type parameter, independent of the class:

        public static <T> void printAll(List<T> items) {
            for (T item : items) {
                System.out.println(item);
            }
        }

    - Bounded types
        Sometimes you want to restrict what types are allowed. extends in a bound works for both classes and interfaces:

        public static <T extends Comparable<T>> T maxOf(T a, T b) {
            return a.compareTo(b) >= 0 ? a : b;
        }

        System.out.println(maxOf(3, 7));          // 7
        System.out.println(maxOf("apple", "pear")); // pear

    - Wildcards
        A ? means “some unknown type.” Use ? extends T when you only read from a collection, and ? super T when you only write into it:

        public static void printNumbers(List<? extends Number> list) {
            for (Number n : list) {
                System.out.println(n);
            }
        }

        This method accepts List<Integer>, List<Double>, and so on, because it only reads the values as Number.

    - Type erasure
        Java removes generic type information at compile time. At runtime, List<String> and List<Integer> are both just List. This is why you can’t write new T() or check obj instanceof List<String>. It’s a backward-compatibility decision, and it’s a common interview topic.