package ReflectionAnnnot;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class First {
    public static void main(String[] args) throws Exception{
        // Exercise: 1
        Class<?> c = Book.class;
        System.out.println(c.getName());              // full class name
        System.out.println(c.getSimpleName());        // Book

        for (Method m : c.getDeclaredMethods()) {
            System.out.println("Method: " + m.getName());
        }
        for (Field f : c.getDeclaredFields()) {
            System.out.println("Field: " + f.getName() + " of type " + f.getType().getSimpleName());
        }

        // Exercise: 2
        Class<?> d = Class.forName("ReflectionAnnnot.Book");
        Constructor<?> constructor = d.getDeclaredConstructor(String.class, int.class, String.class);
        Object obj = constructor.newInstance(
            "Java Programming",
            450,
            "James Gosling"
        );


        Method describe = d.getDeclaredMethod("describe");
        describe.invoke(obj); // calls describe() on the object

        // Exercise: 3
        
    }
}

class Book{
    private String title;
    private int pages;
    private String author;
    private static int count = 0;

    public static int getCount(){
        return count;
    }

    public String getAuthor(){
        return author; //it should be read-only because there are only a definite authors of a particular book which doesn't change
    }

    public String getTitle(){
        return title;
    }
    public int getPages(){
        return pages;
    }

    public void setTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        this.title = title;
    }

    public void setPages(int pages) {
        if (pages <= 0) {
            throw new IllegalArgumentException("Pages must be positive");
        }
        this.pages = pages;
    }

    public Book(String title, int pages, String author){
        setTitle(title);
        setPages(pages);
        this.author = author;
        count++;
    }

    public void describe(){
        System.out.println("Title of the Book is: " + title + " with the page count: " + pages);
    }
    public String toString(){
        return "Book[title=" + getTitle() + ", " + "pages=" + getPages() + "]";
    }
}