import java.util.List;

public interface INewsService {
    void addNews(INewsInput news);
    DtoNewsItem getNews(int id);
    List<DtoNewsItem> getNewsList();
    void changeNews(int id, INewsInput news);
    void deleteNews(int id);

    List<DtoCategory> getCategoriesList();
    void addCategory(ICategoryInput category);
    void changeCategory(int id, ICategoryInput category);
    void deleteCategory(int id);
}
