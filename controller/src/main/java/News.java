import java.util.Date;
import java.util.Objects;

public class News{

    private int id;

    private String title;

    private Date date;

    private String category;

    private String text;

    private String author;

    public News(int id, String title, Date date, String category, String text, String author) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.category = category;
        this.text = text;
        this.author = author;
    }

    public News(INewsInput newsInput, Date date, int id) {
        this.title = newsInput.getTitle();
        this.category = newsInput.getCategory();
        this.text = newsInput.getText();
        this.author = newsInput.getAuthor();
        this.date = date;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    void setTitle(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
