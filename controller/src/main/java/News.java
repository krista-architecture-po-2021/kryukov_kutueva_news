import java.util.Date;
import java.util.Objects;

public class News{

    private String title;

    private Date date;

    private String category;

    private String text;

    private String author;

    public News(INewsInput newsInput, Date date) {
        this.title = newsInput.getTitle();
        this.category = newsInput.getCategory();
        this.text = newsInput.getText();
        this.author = newsInput.getAuthor();
        this.date = date;
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
