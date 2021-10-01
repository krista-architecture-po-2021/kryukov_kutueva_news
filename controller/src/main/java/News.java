import java.util.Date;
import java.util.Objects;

public class News{

    private String title;

    private Date date;

    private String category;

    private String text;

    public News(String title, Date date, String category, String text) {
        this.title = title;
        this.date = date;
        this.category = category;
        this.text = text;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return Objects.equals(title, news.title) && Objects.equals(date, news.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, date);
    }

}
