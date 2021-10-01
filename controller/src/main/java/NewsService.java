import java.util.List;

public class NewsService implements INewsService {

    INewsController newsController = new NewsController();
    ICategoryController categoryController = new CategoryController();

    @Override
    public void addNews(INews news) {
        newsController.addNewsItem(news);
    }

    @Override
    public INews getNews(int id) {
        return newsController.getNewsItem(id);
    }

    @Override
    public List<INews> getNewsList() {
        return newsController.getNewsList();
    }

    @Override
    public void renewNews(int id, INews news) {
        newsController.renewNewsItem(id, news);
    }

    @Override
    public void deleteNews(int id) {
        newsController.deleteNewsItem(id);
    }

    @Override
    public List<ICategory> getCategoriesList() {
        return categoryController.getCategoriesList();
    }

    @Override
    public void addCategory(ICategory category) {
        categoryController.addCategory(category);
    }

    @Override
    public void renewCategory(int id, ICategory category) {
        categoryController.renewCategory(id, category);
    }

    @Override
    public void deleteCategory(int id) {
        categoryController.deleteCategory(id);
    }
}
