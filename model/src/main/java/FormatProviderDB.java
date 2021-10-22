import java.util.List;

public class FormatProviderDB implements IProvider{

    public static final String NEWS = "news";
    public static final String CATEGORY = "category";

    @Override
    public Object get(String entityName, int id) {
        if (NEWS.equals(entityName)) {
            DbConnection dbConnection = new DbConnection();
            dbConnection.open();
            DoNews doNews = dbConnection.getNews(id);
            dbConnection.close();
            return doNews;
        } else if (CATEGORY.equals(entityName)) {
            DbConnection dbConnection = new DbConnection();
            dbConnection.open();
            DoCategory doCategory = dbConnection.getCategory(id);
            dbConnection.close();
            return doCategory;
        }
        return null;
    }


    @Override
    public <T> List<T> getAll(String entityName) {
        if (NEWS.equals(entityName)) {
            DbConnection dbConnection = new DbConnection();
            dbConnection.open();
            List<T> newsList = dbConnection.getAllNews();
            dbConnection.close();
            return newsList;
        } //else (CATEGORY.equals(entityName)) {
            DbConnection dbConnection = new DbConnection();
            dbConnection.open();
            List<T> categoryList = dbConnection.getAllCategories();
            dbConnection.close();
            return categoryList;
        //}
    }

    @Override
    public <T> void change(String entityName, T item) {
        if (NEWS.equals(entityName)) {
            DbConnection dbConnection = new DbConnection();
            dbConnection.open();
            dbConnection.changeNews((DoNews) item);
            dbConnection.close();
        }
    }

    @Override
    public <T> void add(String entityName, T item) {

    }

    @Override
    public void del(String entityName, int id) {

    }
}
