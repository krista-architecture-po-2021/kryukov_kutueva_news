import java.util.List;

public class NewsService implements INewsService {

    INewsController newsController = new NewsController();
    ICategoryController categoryController = new CategoryController();

    @Override
    public void addNews(INewsInput news) {
        newsController.addNewsItem(news);
    }

    @Override
    public DtoNewsItem getNews(int id) {
        return newsController.getNewsItem(id);
    }

    @Override
    public List<DtoNewsItem> getNewsList() {
        return newsController.getAllNews();
    }

    @Override
    public void changeNews(int id, INewsInput news) {
        newsController.changeNewsItem(id, news);
    }

    @Override
    public void deleteNews(int id) {
        newsController.deleteNewsItem(id);
    }

    @Override
    public List<DtoCategory> getCategoriesList() {
        return categoryController.getCategoriesList();
    }

    @Override
    public void addCategory(ICategoryInput category) {
        categoryController.addCategory(category);
    }

    @Override
    public void changeCategory(int id, ICategoryInput category) {
        categoryController.changeCategory(id, category);
    }

    @Override
    public void deleteCategory(int id) {
        categoryController.deleteCategory(id);
    }
}
