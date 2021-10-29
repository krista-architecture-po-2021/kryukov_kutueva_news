import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecentNewsController extends NewsControllerDecorator {

    private Date publicationDate;

    public RecentNewsController(INewsController newsController, Date publicationDate) {
        super(newsController);
        this.publicationDate = publicationDate;
    }

    @Override
    public List<DtoNewsItem> getAllNews() {
        List<DtoNewsItem> allNews = super.getAllNews();
        return filter(allNews);
    }

    private List<DtoNewsItem> filter(List<DtoNewsItem> allNews) {
        ArrayList<DtoNewsItem> filteredNews = new ArrayList<>();
        for (DtoNewsItem dtoNewsItem: allNews) {
            if (dtoNewsItem.date.equals(publicationDate) || dtoNewsItem.date.after(publicationDate)) {
                filteredNews.add(dtoNewsItem);
            }
        }
        return filteredNews;
    }
}
