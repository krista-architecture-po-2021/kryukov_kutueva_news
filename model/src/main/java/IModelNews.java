import java.util.List;

public interface IModelNews {

    List<INews> getAllNews();

    INews getNewsItem(int id);
    void setNewsItem(int id, INews news);

}
