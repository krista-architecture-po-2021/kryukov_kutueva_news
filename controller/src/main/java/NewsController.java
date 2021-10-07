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
        return null;
    }

    @Override
    public void addNewsItem(INewsInput newsInput) {
        new News(newsInput, new Date());
    }

    @Override
    public void changeNewsItem(int id, INewsInput newsInput) {

    }

    @Override
    public void deleteNewsItem(int id) {

    }

    @Override
    public DtoCategoryNewsTitles getNewsByCategory(String category) {
        return null;
    }

    @Override
    public DtoAllAuthors getAllAuthors() {
        return null;
    }
}
