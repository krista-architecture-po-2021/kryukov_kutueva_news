import java.util.List;

public interface INewsController {
    List<DtoNewsItem> getAllNews();
    DtoNewsItem getNewsItem(int id);
    void addNewsItem(INewsInput newsInput);
    void changeNewsItem(int id, INewsInput newsInput);
    void deleteNewsItem(int id);

    DtoCategoryNewsTitles getNewsByCategory(String category);
    DtoAllAuthors getAllAuthors();
}
