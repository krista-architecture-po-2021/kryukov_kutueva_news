import java.util.ArrayList;
import java.util.List;

public class PositiveNewsController extends NewsControllerDecorator{

    private String[] sadWords;

    public PositiveNewsController(INewsController newsController, String[] sadWords) {
        super(newsController);
        this.sadWords = sadWords;
    }

    @Override
    public List<DtoNewsItem> getAllNews() {
        List<DtoNewsItem> allNews = super.getAllNews();
        return filter(allNews);
    }

    private List<DtoNewsItem> filter(List<DtoNewsItem> allNews) {
        ArrayList<DtoNewsItem> filteredNews = new ArrayList<>();
        for (DtoNewsItem newsItem: allNews) {
            String text = newsItem.text;
            boolean positive = true;
            for (String sadWord: sadWords) {
                if (text.contains(sadWord)) {
                    positive = false;
                    break;
                }
            }
            if (positive) {
                filteredNews.add(newsItem);
            }
        }
        return filteredNews;
    }

}
