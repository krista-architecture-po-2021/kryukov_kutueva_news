import java.util.List;

public interface INewsController {
    List<DTONewsItem> getNewsList();
    DTONewsItem getNewsItem(int id);
    void addNewsItem(INewsInput newsInput);
    void renewNewsItem(int id, INewsInput newsInput);
    void deleteNewsItem(int id);
}
