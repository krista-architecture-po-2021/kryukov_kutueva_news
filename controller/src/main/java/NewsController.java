import java.util.Collections;
import java.util.Date;
import java.util.List;

public class NewsController implements INewsController{

    @Override
    public List<DTONewsItem> getNewsList() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public DTONewsItem getNewsItem(int id) {
        return null;
    }

    @Override
    public void addNewsItem(INewsInput newsInput) {
        new News(newsInput.getTitle(), new Date(), newsInput.getCategory(), newsInput.getText());
    }

    @Override
    public void renewNewsItem(int id, INewsInput newsInput) {

    }

    @Override
    public void deleteNewsItem(int id) {

    }
}
