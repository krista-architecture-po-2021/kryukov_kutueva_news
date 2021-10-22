import java.util.List;

public interface IProvider {
    <T> T get(String entityName, int id);

    <T> List<T> getAll(String entityName);

    <T> void change(String entityName, T item);

    <T> void add(String entityName, T item);

    void del(String entityName, int id);
}
