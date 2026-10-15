public class ObjCls{
    public static void main(String[] args) {
        Book b1 = new Book("Python", 250);
        Book b2 = new Book("Garder on words",150);
        b1.describe();
        b2.describe();

        Book b3 = new Book("Amidst a lovestorm",230);
        System.out.println(Book.getCount());

        Book a = new Book("Java Basics", 300);
        Book b = a;
        //b.pages = 500;   // hmm, is this allowed? what will a.pages print?
        //System.out.println(a.pages);// 500 : the previous value will be overwrittem as "a" and "b" both are pointing to the same object
        //b.pages = 10;// since pages field is now a private field and it cannot be directly accessed outside it's class (it was caught before running)
        //b.setPages(0);// IllegalArgumentException: Pages must be positive "we already have specified the condition in setter method that the page count must be positive" (this happend while program runs)
        System.out.println(b);
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