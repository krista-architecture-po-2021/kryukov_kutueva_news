import java.util.List;

public interface INewsController {
    List<INews> getNewsList();
    INews getNewsItem(int id);
    void addNewsItem(INews news);
    void renewNewsItem(int id, INews news);
    void deleteNewsItem(int id);
}
