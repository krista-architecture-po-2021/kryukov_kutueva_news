import java.util.List;

public class FormatProviderDB implements IProvider{

    public static final String NEWS = "news";
    public static final String CATEGORY = "category";

    @Override
    public <T> T get(String entityName, int id) {

        }
        return null;
    }


    @Override
    public <T> List<T> getAll(String entityName) {

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
