import java.util.List;

public class NewsService implements INewsService {

    INewsController newsController = new NewsController();
    ICategoryController categoryController = new CategoryController();

    @Override
    public void addNews(INewsInput news) {
        newsController.addNewsItem(news);
    }

    @Override
    public DTONewsItem getNews(int id) {
        return newsController.getNewsItem(id);
    }

    @Override
    public List<DTONewsItem> getNewsList() {
        return newsController.getNewsList();
    }

    @Override
    public void renewNews(int id, INewsInput news) {
        newsController.renewNewsItem(id, news);
    }

    @Override
    public void deleteNews(int id) {
        newsController.deleteNewsItem(id);
    }

    @Override
    public List<DTOCategory> getCategoriesList() {
        return categoryController.getCategoriesList();
    }

    @Override
    public void addCategory(ICategoryInput category) {
        categoryController.addCategory(category);
    }

    @Override
    public void renewCategory(int id, ICategoryInput category) {
        categoryController.renewCategory(id, category);
    }

    @Override
    public void deleteCategory(int id) {
        categoryController.deleteCategory(id);
    }
}
