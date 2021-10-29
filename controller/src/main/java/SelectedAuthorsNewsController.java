import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectedAuthorsNewsController extends NewsControllerDecorator {

    private String[] selectedAuthors;

    public SelectedAuthorsNewsController(INewsController newsController, String[] selectedAuthors) {
        super(newsController);
        this.selectedAuthors = selectedAuthors;
    }

    @Override
    public List<DtoNewsItem> getAllNews() {
        List<DtoNewsItem> allNews = super.getAllNews();
        return filter(allNews);
    }

    private List<DtoNewsItem> filter(List<DtoNewsItem> allNews) {
        ArrayList<DtoNewsItem> filteredNews = new ArrayList<>();
        for (DtoNewsItem newsItem: allNews) {
            boolean hasAuthor = false;
            for (String author: selectedAuthors) {
                if(newsItem.author.equals(author)) {
                    hasAuthor = true;
                    break;
                }
            }
            if (hasAuthor) {
                filteredNews.add(newsItem);
            }
        }
        return filteredNews;
    }
}
