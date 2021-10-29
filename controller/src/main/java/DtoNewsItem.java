import java.util.Date;
import java.util.Objects;

public class DtoNewsItem {
    public int id;
    public String title;
    public Date date;
    public String category;
    public String text;
    public String author;

    public DtoNewsItem(News news) {
        this.id = news.getId();
        this.title = news.getTitle();
        this.date = news.getDate();
        this.category = news.getCategory();
        this.text = news.getText();
        this.author = news.getAuthor();
    }
}
