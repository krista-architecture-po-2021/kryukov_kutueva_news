import java.util.Date;
import java.util.List;

public class NewsService implements INewsService {

    INewsController newsController;
    ICategoryController categoryController = new CategoryController();

    String[] sadWords;
    String[] selectedAuthors;
    Date publicationDate;

    public NewsService(String[] sadWords, String[] selectedAuthors, Date publicationDate) {
        this.sadWords = sadWords;
        this.selectedAuthors = selectedAuthors;
        this.publicationDate = publicationDate;
        getNewsController();
    }

    private void getNewsController() {
        newsController = new NewsController();
        if (sadWords != null) {
            newsController = new PositiveNewsController(newsController, sadWords);
        }
        if (selectedAuthors != null) {
            newsController = new SelectedAuthorsNewsController(newsController, selectedAuthors);
        }
        if (publicationDate != null) {
            newsController = new RecentNewsController(newsController, publicationDate);
        }
    }

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
