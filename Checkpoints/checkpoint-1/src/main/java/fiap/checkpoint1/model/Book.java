package fiap.checkpoint1.model;

public class Book {

    private String name;

    private String author;

    private String isbn;

    private String category;

    public Book(String name, String author, String isbn, String category) {
        this.name = name;
        this.author = author;
        this.isbn = isbn;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
