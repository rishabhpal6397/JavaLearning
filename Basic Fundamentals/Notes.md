1-> "==": compares/checks the references or memory locations while ".equals()": is used for checking/comparing the contents of the string

2-> "Static": it means the method/variable belongs to the class so we can call it without creating an object

3-> "Pass by value": Java always passes arguments by value. For primitives, the method gets a copy of the value. For objects, the method gets a copy of the reference, which points to the same object as the caller’s variable.

    **Java is always pass by value. There’s no “pass by reference” in Java.**
    **String is immutable, so you can’t change its contents in a method at all. Only reassignment is possible, and it has no effect on the caller.**
    **StringBuilder and most other objects are mutable, so methods can change them in place.**

    For objects, what gets copied is the reference, so the method can change the object’s contents, but it can’t make the caller’s variable point to a different object.
        for e.g., public static void tryToChange(int x) {
            x = 100;   // changes only the local copy
        }
        public static void main(String[] args) {
            int num = 5;
            tryToChange(num);
            System.out.println(num);   // still 5
        }


4-> "Varargs": When you don’t know how many arguments will be passed, use ...
    Inside the method, numbers behaves like an array
for e.g.,public static int sum(int... numbers) {
            int total = 0;
            for (int n : numbers) {
                total += n;
            }
            return total;
        }

        System.out.println(sum(1, 2));          // 3
        System.out.println(sum(1, 2, 3, 4));    // 10


5-> "Method Overloading": Methods of same name but varies in number of prameters or types of parameters

6-> "Recursion": A method can call itself, as long as there's a stopping condition. Without the base case, the method would keep calling itself forever until the program crashes with a StackOverflowError

7-> As a rule, make fields private, make methods public only when other code needs them, and keep everything else as restricted as possible.
    **Making fields private and providing methods to read or change them is called encapsulation.**

8-> Getters and setters might look like extra code, but they give you control. You can add validation later without changing any code that uses the class. You can also make a field read-only by providing a getter but no setter.


9-> Polymorphism means "many forms", a parent-type variable can refer to any child object, and the correct method runs based on the actual object.
    The variable type controls which methods the compiler allows, and the object’s actual class controls which version runs.
    "This is called runtime polymorphism, achieved through method overriding and dynamic method dispatch. It allows you to write code using a common parent type while each subclass behaves differently."

10-> An abstract class can’t be instantiated. It’s a partial blueprint that forces children to provide certain methods.
    - Can contain abstract methods (no body) and concrete methods (with implementation).
    - Abstract method is declared without a body and the initialized in the sub-classes    where required
    - Helps achieve security and cleaner design
    - Focuses on what an object does, not how it does it


11-> Variable Declaration types: 
    - Local Variables: Declared within a method, constructor, or block, and are only accessible within that scope. They are created at the time of declaration and destroyed when the function completes
    - Instance Variables: Declared within a class but outside any method, and are shared by all instances of that class. They have a default value of 0 or null depending on the data type.
    - Static: A static member is loaded once when the class is loaded into memory. It is shared by all instances of the class. It can be accessed using the class name directly (e.g., ClassName.method()), without creating an object.
    - Parameters: Declared in a method signature, and receive the value passed by the caller. They are local to the method and cannot be accessed outside of it.


12-> Interface: it defines a set of methods that a class must implement and they allows the classes to implement multi-inheritance i.e., a class can implement multiple interfaces
    - static methods in interfaces belong to the interface and are called through its name
    - Functional Interface: An interface with exactly one abstract method
    - A class can extend only one class because Java keeps class inheritance straightforward and avoids ambiguity over inherited implementations. However, a class can implement several interfaces because it can support multiple independent capabilities at the same time
    - Remember: one parent class, multiple interfaces
    - the main reason is that if a class could extend two classes, it could inherit two conflicting implementations of the same method, or two different fields with the same name. Java calls this the “diamond problem.” Interfaces avoid it because they have no instance state, and when two default methods conflict, the implementing class must override the method and resolve the conflict itself.