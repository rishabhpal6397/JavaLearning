1-> "==": compares/checks the references or memory locations while ".equals()": is used for checking/comparing the contents of the string

2-> "Static": it means the method/variable belongs to the class so we can call it without creating an object

3-> "Pass by value": For objects, what gets copied is the reference, so the method can change the object’s contents, but it can’t make the caller’s variable point to a different object.
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

