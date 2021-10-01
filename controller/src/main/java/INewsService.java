import java.util.List;

public interface INewsService {
    void addNews(INews news);
    INews getNews(int id);
    List<INews> getNewsList();
    void renewNews(int id, INews news);
    void deleteNews(int id);

    List<ICategory> getCategoriesList();
    void addCategory(ICategory category);
    void renewCategory(int id, ICategory category);
    void deleteCategory(int id);
}
