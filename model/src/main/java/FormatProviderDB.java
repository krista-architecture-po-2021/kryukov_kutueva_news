import java.util.List;

public class FormatProviderDB implements IProvider{

    public static final String NEWS = "news";
    public static final String CATEGORY = "category";

    DbConnection dbConnection = new DbConnection();

    @Override
    public <T extends IBaseEntity> T get(String entityName, int id) {
        return null;
    }


    @Override
    public <T extends IBaseEntity> List<T> getAll(String entityName) {
        return null;
    }

    @Override
    public <T extends IBaseEntity> void change(String entityName, T item) {

    }

    @Override
    public <T extends IBaseEntity> void add(String entityName, T item) {
        dbConnection.add(entityName, item);
    }

    @Override
    public void del(String entityName, int id) {

    }
}
