import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestApi {

    @Test
    public void addNews() {
        INewsService newsService = new NewsService();
        INews news = new News("NewYear","31.12");
        newsService.addNews(news);
        News returnedNews = (News) newsService.getNewsList().get(0);
        assertEquals(news, returnedNews);
    }

    @Test
    public void getNews() {
        INewsService newsService = new NewsService();
        INews news = new News("NewYear","31.12");
        newsService.addNews(news);
        News returnedNews = (News) newsService.getNews(1);
        assertEquals(news, returnedNews);
    }

    @Test
    public void renewNews() {
        INewsService newsService = new NewsService();
        INews news1 = new News("NewYear","31.12");
        newsService.addNews(news1);
        INews news2 = new News("NewYear", "01.01");
        newsService.renewNews(1, news2);
        News returnedNews = (News) newsService.getNews(1);
        assertEquals(news2, returnedNews);
    }

    @Test
    public void deleteNews() {
        INewsService newsService = new NewsService();
        INews news1 = new News("NewYear","31.12");
        newsService.addNews(news1);
        assertFalse(newsService.getNewsList().isEmpty());
        newsService.deleteNews(1);
        assertTrue(newsService.getNewsList().isEmpty());
    }

    @Test
    public void getNewsList() {
        INewsService newsService = new NewsService();
        INews news1 = new News("NewYear","31.12");
        newsService.addNews(news1);
        INews news2 = new News("NewYear", "01.01");
        newsService.addNews(news2);
        List<INews> newsList = newsService.getNewsList();
        assertEquals(2, newsList.size());
        INews returnedNews1 = newsList.get(0);
        assertEquals(returnedNews1, news1);
        INews returnedNews2 = newsList.get(1);
        assertEquals(returnedNews2, news2);
    }

    @Test
    public void addCategory() {
        INewsService newsService = new NewsService();
        ICategory category = new Category("Holidays");
        newsService.addCategory(category);
        List<ICategory> categoriesList = newsService.getCategoriesList();
        assertFalse(categoriesList.isEmpty());
        ICategory returnedCategory = categoriesList.get(0);
        assertEquals(category, returnedCategory);
    }

    @Test
    public void renewCategory() {
        INewsService newsService = new NewsService();
        ICategory category1 = new Category("Holidays");
        newsService.addCategory(category1);
        ICategory category2 = new Category("Politics");
        newsService.renewCategory(1, category2);
        List<ICategory> categoriesList = newsService.getCategoriesList();
        assertFalse(categoriesList.isEmpty());
        ICategory returnedCategory = categoriesList.get(0);
        assertEquals(category2, returnedCategory);
    }

    @Test
    public void deleteCategory() {
        INewsService newsService = new NewsService();
        ICategory category1 = new Category("Holidays");
        List<ICategory> categoriesList = newsService.getCategoriesList();
        newsService.addCategory(category1);
        assertFalse(categoriesList.isEmpty());
        newsService.deleteCategory(1);
        List<ICategory> categoriesList2 = newsService.getCategoriesList();
        assertTrue(categoriesList2.isEmpty());
    }

    @Test
    public void getCategoriesList() {
        INewsService newsService = new NewsService();
        ICategory category1 = new Category("Holidays");
        newsService.addCategory(category1);
        ICategory category2 = new Category("Politics");
        newsService.addCategory(category2);
        List<ICategory> categoriesList = newsService.getCategoriesList();
        ICategory returnedCategory1 = categoriesList.get(0);
        assertEquals(category1, returnedCategory1);
        ICategory returnedCategory2 = categoriesList.get(1);
        assertEquals(category2, returnedCategory2);
    }
}
