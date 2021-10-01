import java.util.Collections;
import java.util.List;

public class NewsController implements INewsController{

    @Override
    public List<INews> getNewsList() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public News getNewsItem(int id) {
        return null;
    }

    @Override
    public void addNewsItem(INews news) {

    }

    @Override
    public void renewNewsItem(int id, INews news) {

    }

    @Override
    public void deleteNewsItem(int id) {

    }
}
