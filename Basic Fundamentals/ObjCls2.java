public class ObjCls2{
    public static void main(String[] args) {
        Person[] people = {
            new Person("Rishabh"), 
            new Student("Kunal", 8.65), 
            new Teacher("Aastha","English")
        };

        for (Person p : people){
            p.introduce();
        }
        // Hi, my name is: Rishabh
        // I'm a student and my CGPA is: 8.65
        // I'm a teacher and my subject is: English

    }
}

class Person{
    protected String name;

    public Person(String name){
        this.name = name;
    }

    public void introduce(){
        System.out.println("Hi, my name is: " + name);
    }
}

class Teacher extends Person{
    private String subject;

    public Teacher(String name, String subject){
        super(name);
        this.subject = subject;
    }

    @Override 
    public void introduce(){
        System.out.println("I'm a teacher and my subject is: " + subject);
    }
}

class Student extends Person{
    private double cgpa;

    public Student(String name, double cgpa){
        super(name);
        this.cgpa = cgpa;
    }

    @Override 
    public void introduce(){
        System.out.println("I'm a student and my CGPA is: " + cgpa);
    }
}