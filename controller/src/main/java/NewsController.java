import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewsController implements INewsController{

    /*@Inject
    private IModel model;*/

    @Override
    public List<DtoNewsItem> getAllNews() {
        IDao<DoNews> daoNews = ModelFactory.getModel().getDaoNews(1);
        List<DoNews> doNewsList = daoNews.getAll();
        List<DtoNewsItem> dtoNewsItems = new ArrayList<>();
        for (DoNews doNews: doNewsList) {
            IDao<DoCategory> daoCategory = ModelFactory.getModel().getDaoCategory(1);
            DoCategory doCategory = daoCategory.get(doNews.getCategoryId());
            News news = new News(doNews.getId(), doNews.getTitle(), doNews.getDate(), doCategory.getName(), doNews.getText(), doNews.getAuthor());
            DtoNewsItem dtoNewsItem = new DtoNewsItem(news);
            dtoNewsItems.add(dtoNewsItem);
        }
        return dtoNewsItems;
    }

    @Override
    public DtoNewsItem getNewsItem(int id) {
        IDao<DoNews> daoNews = ModelFactory.getModel().getDaoNews(1);
        DoNews doNews = daoNews.get(id);
        IDao<DoCategory> daoCategory = ModelFactory.getModel().getDaoCategory(1);
        DoCategory doCategory = daoCategory.get(doNews.getCategoryId());
        News news = new News(doNews.getId(), doNews.getTitle(), doNews.getDate(), doCategory.getName(), doNews.getText(), doNews.getAuthor());
        return new DtoNewsItem(news);
    }

    @Override
    public void addNewsItem(INewsInput newsInput) {
       News news = new News(newsInput, new Date(), getNewsNextId());
       int categoryId = getCategoryIdByName(news.getCategory());
       DoNews doNews = new DoNews(news.getId(), news.getTitle(), news.getDate(),
               categoryId, news.getText(), news.getAuthor());
        IDao<DoNews> daoNews = ModelFactory.getModel().getDaoNews(1);
       daoNews.add(doNews);
    }

    @Override
    public void changeNewsItem(int id, INewsInput newsInput) {
        IDao<DoNews> daoNews = ModelFactory.getModel().getDaoNews(1);
        News news = new News(newsInput, new Date(), id);
        int categoryId = getCategoryIdByName(news.getCategory());
        DoNews doNews = new DoNews(news.getId(), news.getTitle(), news.getDate(),
                categoryId, news.getText(), news.getAuthor());
        daoNews.change(doNews);
    }

    @Override
    public void deleteNewsItem(int id) {
        IDao<DoNews> daoNews = ModelFactory.getModel().getDaoNews(1);
        daoNews.del(id);
    }

    @Override
    public List<DtoNewsItem> getNewsByCategory(String category) {
        ArrayList<DtoNewsItem> filteredNews = new ArrayList<>();
        List<DtoNewsItem> allNews = getAllNews();
        for (DtoNewsItem newsItem: allNews) {
            if (category.equals(newsItem.category)) {
                filteredNews.add(newsItem);
            }
        }
        return filteredNews;
    }

    public static int getNewsNextId() {
        IDao<DoNews> daoNews = ModelFactory.getModel().getDaoNews(1);
        List<Integer> usedIds = daoNews.getAllIds();
        for (int i = 1; i <= usedIds.size(); i++) {
            if (usedIds.get(i - 1) != i) {
                return i;
            }
        }
        return usedIds.size() + 1;
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
