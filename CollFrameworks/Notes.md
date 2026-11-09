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
