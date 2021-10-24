import java.util.Date;

public class DoNews implements IBaseEntity{

    private int id;

    private String title;

    private Date date;

    private int categoryId;

    private String text;

    private String author;

    public DoNews(int id, String title, Date date, int categoryId, String text, String author) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.categoryId = categoryId;
        this.text = text;
        this.author = author;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
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
