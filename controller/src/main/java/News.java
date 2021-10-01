import java.util.Objects;

public class News implements INews {

    private String title,date = "";

    private String category;

    public News(String newYear, String s) {
    }

    @Override
    public void addNews(String tit,String dt) {

    }

    void setTitle(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
