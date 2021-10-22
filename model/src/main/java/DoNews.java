import java.util.Date;

public class DoNews {

    public int id;

    public String title;

    public Date date;

    public int categoryId;

    public String text;

    public String author;

    public DoNews(int id, String title, Date date, int categoryId, String text, String author) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.categoryId = categoryId;
        this.text = text;
        this.author = author;
    }
}
