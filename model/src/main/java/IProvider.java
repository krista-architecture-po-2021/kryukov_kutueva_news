import java.util.List;

public interface IProvider {
    <T extends IBaseEntity> T get(String entityName, int id);

    <T extends IBaseEntity> List<T> getAll(String entityName);

    <T extends IBaseEntity> void change(String entityName, T item);

    <T extends IBaseEntity> void add(String entityName, T item);

    <T extends IBaseEntity> void del(String entityName, int id);

    <T extends IBaseEntity> List<Integer> getAllIds(String entityName);
}
