import java.util.List;

public interface IDaoNews {
    News getNews(int id);

    List<News> getAllNews();

    void changeNews(News news);

    void addNews(News news);

    void delNews(News news);
}
