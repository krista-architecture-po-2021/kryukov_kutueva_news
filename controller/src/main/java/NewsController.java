import javax.inject.Inject;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class NewsController implements INewsController{

    @Inject
    private IModel model;

    @Override
    public List<DtoNewsItem> getAllNews() {

        return Collections.EMPTY_LIST;
    }

    @Override
    public DtoNewsItem getNewsItem(int id) {
        DaoNews daoNews = model.getDaoNews();
        DoNews doNews = daoNews.get(id);
        DaoCategory daoCategory = model.getDaoCategory();
        DoCategory doCategory = daoCategory.get(doNews.categoryId);
        News news = new News(doNews.id, doNews.title, doNews.date, doCategory.name, doNews.text, doNews.author);
        return new DtoNewsItem(news);
    }

    @Override
    public void addNewsItem(INewsInput newsInput) {
       News news = new News(newsInput, new Date(), getNewsNextId());
       int categoryId = getCategoryIdByName(news.getCategory());
       DoNews doNews = new DoNews(news.getId(), news.getTitle(), news.getDate(),
               categoryId, news.getText(), news.getAuthor());
       DaoNews daoNews = model.getDaoNews();
       daoNews.add(doNews);
    }

    @Override
    public void changeNewsItem(int id, INewsInput newsInput) {
        DaoNews daoNews = model.getDaoNews();
        News news = new News(newsInput, new Date(), id);
        int categoryId = getCategoryIdByName(news.getCategory());
        DoNews doNews = new DoNews(news.getId(), news.getTitle(), news.getDate(),
                categoryId, news.getText(), news.getAuthor());
        daoNews.change(doNews);
    }

    @Override
    public void deleteNewsItem(int id) {
        DaoNews daoNews = model.getDaoNews();
        daoNews.del(id);
    }

    @Override
    public DtoCategoryNewsTitles getNewsByCategory(String category) {
        return null;
    }

    @Override
    public DtoAllAuthors getAllAuthors() {
        return null;
    }

    public static int getNewsNextId() {
        return 0;
    }

    public static int getCategoryIdByName(String name) {
        List<Category> allCategories = AllCategories.getInstance().getAllCategories();
        for (Category category: allCategories) {
            if (name.equals(category.getName())) {
                return category.getId();
            }
        }
        CategoryController categoryController = new CategoryController();
        return categoryController.addCategory(name);
    }
}
