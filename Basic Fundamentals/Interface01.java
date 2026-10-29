interface Printable{
    void print();

    default void printTwice(){
        print();
        print();
    }
}

class Book implements Printable{
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
    public void print(){
        System.out.println("Title: " + title + " and the Author is: " + author);
    }
}

public class Interface01 {
    public static void main(String[] args) {
        Book bk = new Book("Apocalypse Diaries", 125, "Mojimoto");
        bk.print();
        bk.printTwice();
    }
}