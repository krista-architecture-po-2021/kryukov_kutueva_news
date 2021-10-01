import java.util.List;

public interface INewsService {
    void addNews(INewsInput news);
    INewsInput getNews(int id);
    List<INewsInput> getNewsList();
    void renewNews(int id, INewsInput news);
    void deleteNews(int id);

    List<ICategoryInput> getCategoriesList();
    void addCategory(ICategoryInput category);
    void renewCategory(int id, ICategoryInput category);
    void deleteCategory(int id);
}
