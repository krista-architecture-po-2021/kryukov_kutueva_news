import java.util.List;

public abstract class NewsControllerDecorator implements INewsController{

    private INewsController newsController;

    public NewsControllerDecorator(INewsController newsController) {
        this.newsController = newsController;
    }

    @Override
    public List<DtoNewsItem> getAllNews() {
        return newsController.getAllNews();
    }

    @Override
    public DtoNewsItem getNewsItem(int id) {
        return newsController.getNewsItem(id);
    }

    @Override
    public void addNewsItem(INewsInput newsInput) {
        newsController.addNewsItem(newsInput);
    }

    @Override
    public void changeNewsItem(int id, INewsInput newsInput) {
        newsController.changeNewsItem(id, newsInput);
    }

    @Override
    public void deleteNewsItem(int id) {
        newsController.deleteNewsItem(id);
    }

    @Override
    public List<DtoNewsItem> getNewsByCategory(String category) {
        return newsController.getNewsByCategory(category);
    }

}
