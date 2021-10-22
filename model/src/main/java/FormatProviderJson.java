import java.util.List;

public class FormatProviderJson implements IProvider {
    @Override
    public <T> T get(String entityName, int id) {
        return null;
    }

    @Override
    public <T> List<T> getAll(String entityName) {
        return null;
    }

    @Override
    public <T> void change(String entityName, T item) {

    }

    @Override
    public <T> void add(String entityName, T item) {

    }

    @Override
    public void del(String entityName, int id) {

    }
}
