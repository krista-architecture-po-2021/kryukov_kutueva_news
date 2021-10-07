import java.util.List;

public interface IDao <T> {
    T get(int id);

    List<T> getAll();

    void change(int id, T item);

    void add(T item);

    void del(int id);
}
