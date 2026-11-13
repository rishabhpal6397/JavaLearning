Lesson 19: Reflection and annotations
    - Reflection lets a program examine and use classes, methods, and fields at runtime, without knowing them at compile time. Frameworks like Spring and JUnit depend on it.

    Getting a Class object
    Every class has a Class object describing it:
        Class<?> c1 = String.class;
        Class<?> c2 = "hello".getClass();
        Class<?> c3 = Class.forName("java.util.ArrayList");   // by name, as a string

    - getDeclaredMethods and getDeclaredFields include private members. getMethods returns only public ones, including inherited ones.


Annotations
    - An annotation attaches metadata to code. You’ve already used @Override, which tells the compiler to check that you’re overriding a method.

Retention policies
    - @Retention controls how long an annotation lasts:

    SOURCE: discarded by the compiler, like @Override
    CLASS: kept in the bytecode but not loaded at runtime (the default)
    RUNTIME: available through reflection