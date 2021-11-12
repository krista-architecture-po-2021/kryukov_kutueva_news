import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestApi {

    private void compareNewsInputOutput(INewsInput newsInput, DtoNewsItem newsOutput) {
        assertEquals(newsInput.getTitle(), newsOutput.title);
        assertEquals(newsInput.getCategory(), newsOutput.category);
        assertEquals(newsInput.getText(), newsOutput.text);
        assertEquals(newsInput.getAuthor(), newsOutput.author);
    }

    private void compareCategoryInputOutput(ICategoryInput categoryInput, DtoCategory categoryOtput) {
        assertEquals(categoryInput.getName(), categoryOtput.categoryName);
    }

    @Test
    public void addNews() {
        INewsService newsService = new NewsService(null, null, null);
        INewsInput news = new NewsInput("New Year", "Holidays", "Year 2021 has come!", "Nataliia Kutueva");
        newsService.addNews(news);
        DtoNewsItem returnedNews = newsService.getNewsList().get(0);
        compareNewsInputOutput(news, returnedNews);
    }

    @Test
    public void getNews() {
        INewsService newsService = new NewsService(null, null, null);
        INewsInput news = new NewsInput("New Year2", "Holidays", "Year 2021 has come again!", "Nataliia Kutueva");
        newsService.addNews(news);
        DtoNewsItem returnedNews = newsService.getNews(1);
        compareNewsInputOutput(news, returnedNews);
    }

    @Test
    public void updateNews() {
        INewsService newsService = new NewsService(null, null, null);
        INewsInput news1 = new NewsInput("Lab5", "Study", "We are depeloping a News Service", "NataliiaKutueva");
        newsService.addNews(news1);
        INewsInput news2 = new NewsInput("Lab5", "Job", "We are working", "Nataliia Kututeva");
        newsService.changeNews(3, news2);
        DtoNewsItem returnedNews = newsService.getNews(3);
        compareNewsInputOutput(news2, returnedNews);
    }

    @Test
    public void deleteNews() {
        INewsService newsService = new NewsService(null, null, null);
        INewsInput news = new NewsInput("New Year", "Holidays", "Year 2021 has come!", "Nataliia Kutueva");
        newsService.addNews(news);
        assertFalse(newsService.getNewsList().isEmpty());
        newsService.deleteNews(1);
        assertTrue(newsService.getNewsList().isEmpty());
    }

    @Test
    public void getNewsList() {
        INewsService newsService = new NewsService(null, null, null);
        INewsInput news1 = new NewsInput("Lab5", "Study", "We are depeloping a News Service", "NataliiaKutueva");
        newsService.addNews(news1);
        INewsInput news2 = new NewsInput("Lab5", "Job", "We are working", "Nataliia Kututeva");
        newsService.addNews(news2);
        List<DtoNewsItem> newsList = newsService.getNewsList();
        assertEquals(2, newsList.size());
        DtoNewsItem returnedNews1 = newsList.get(0);
        compareNewsInputOutput(news1, returnedNews1);
        DtoNewsItem returnedNews2 = newsList.get(1);
        compareNewsInputOutput(news2, returnedNews2);
    }

    @Test
    public void addCategory() {
        INewsService newsService = new NewsService(null, null, null);
        ICategoryInput category = new CategoryInput("Holidays2");
        newsService.addCategory(category);
        List<DtoCategory> categoriesList = newsService.getCategoriesList();
        assertFalse(categoriesList.isEmpty());
        DtoCategory returnedCategory = categoriesList.get(1);
        compareCategoryInputOutput(category, returnedCategory);
    }

    @Test
    public void updateCategory() {
        INewsService newsService = new NewsService(null, null, null);
        ICategoryInput category1 = new CategoryInput("Holidays5");
        newsService.addCategory(category1);
        ICategoryInput category2 = new CategoryInput("Politics");
        newsService.changeCategory(5, category2);
        List<DtoCategory> categoriesList = newsService.getCategoriesList();
        DtoCategory returnedCategory = categoriesList.get(4);
        compareCategoryInputOutput(category2, returnedCategory);
    }

    @Test
    public void deleteCategory() {
        INewsService newsService = new NewsService(null, null, null);
        ICategoryInput category1 = new CategoryInput("Holidays");
        newsService.addCategory(category1);
        List<DtoCategory> categoriesList = newsService.getCategoriesList();
        assertFalse(categoriesList.isEmpty());
        newsService.deleteCategory(1);
        List<DtoCategory> categoriesList2 = newsService.getCategoriesList();
        assertTrue(categoriesList2.isEmpty());
    }

    @Test
    public void getAllCategories() {
        INewsService newsService = new NewsService(null, null, null);
        ICategoryInput category1 = new CategoryInput("Holidays");
        newsService.addCategory(category1);
        ICategoryInput category2 = new CategoryInput("Politics");
        newsService.addCategory(category2);
        List<DtoCategory> categoriesList = newsService.getCategoriesList();
        DtoCategory returnedCategory1 = categoriesList.get(0);
        compareCategoryInputOutput(category1, returnedCategory1);
        DtoCategory returnedCategory2 = categoriesList.get(1);
        compareCategoryInputOutput(category2, returnedCategory2);
    }

    @Test
    public void getPositiveNews() {
        String[] sadWords = new String[3];
        sadWords[0] = "coronavirus";
        sadWords[1] = "disease";
        sadWords[2] = "death";
        INewsService newsService = new NewsService(sadWords, null, null);
        INewsInput news1 = new NewsInput("New Year", "Holidays", "Year 2021 has come!", "Nataliia Kutueva");
        INewsInput news2 = new NewsInput("Covid", "Problems", "Russia has reported a record 1,159 deaths from Covid in the past 24 hours.", "Nataliia Kutueva");
        INewsInput news3 = new NewsInput("Covid", "Problems",
                "More than 230 million people have been sickened and more than 4 million have died of the coronavirus since January 2020", "Nataliia Kutueva");
        INewsInput news4 = new NewsInput("Covid", "Problems", "Covid is a serious disease", "Nataliia Kutueva");
        newsService.addNews(news1);
        newsService.addNews(news2);
        newsService.addNews(news3);
        newsService.addNews(news4);
        List<DtoNewsItem> returnedNews = newsService.getNewsList();
        assertEquals(1, returnedNews.size());
        compareNewsInputOutput(news1, returnedNews.get(0));
    }
}
