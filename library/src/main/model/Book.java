
public class Book {
    private String title;
    private String author;
    private String ISBN;        // nr op een boek //
    private int publicationYear;

    public Book(String title, String author, String ISBN, int publicationYear) {
        setTitle(title);    // roept de setter-methode setTitle aan om de titel van het boek in te stellen op de meegegeven waarde.
        setAuthor(author);  //* 
        setISBN(ISBN);      // *
        setPublicationYear(publicationYear);    // *
    }

    public String getTitle() {   // titel vn boek word opgehaald 
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {       // controleert of de meegegeven titel null is OF alleen uit witruimte bestaat.
            throw new IllegalArgumentException("Title is required."); // als waarde voeldoet -> foutmelding
        }
        this.title = title.trim();     //  Als de titel geldig is, wordt deze ingesteld op de title variabele, nadat
                                      // eventuele voorloop- en achterloop-witruimte zijn verwijderd met behulp van de
                                     // trim() methode
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Author is required.");
        }
        this.author = author.trim();
    }

    public String getISBN() {
        return ISBN;
    }

}