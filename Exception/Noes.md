Exceptions: An exception is an event that disrupts normal program flow, such as dividing by zero, reading a missing file, or accessing an invalid index. Java lets you detect these problems and respond to them instead of crashing.
    All exceptions extend Throwable, which splits into two branches:
        - Error: serious problems like OutOfMemoryError or StackOverflowError. Your code usually shouldn’t catch these
        - Exception: problems your program can reasonably handle. These split further:
            - Checked exceptions (e.g., IOException): the compiler forces you to handle or declare them.
            - Unchecked exceptions (subclasses of RuntimeException, e.g., ArithmeticException, ArrayIndexOutOfBoundsException, NullPointerException): the compiler doesn’t force handling, but they signal bugs.
            - the main difference between checked and unchecked exceptions in only what the compiler checks before runs
                checked exceptions-> for the failures outside of the code
                unchecked exceptions-> report bugs or broken assumptions
                
            - Checked exceptions are problems a program can anticipate and recover from, such as a missing file, so the compiler forces you to handle them. Unchecked exceptions usually signal bugs, such as a null reference or a bad index, which you fix in the code rather than catch.

    - From Java 7 onward, you can combine catches with |: catch (ArithmeticException | NullPointerException e)
    - throw raises an exception yourself. throws in a method signature declares that the method might throw a checked exception, so callers must handle it
