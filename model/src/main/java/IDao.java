import java.io.IOException;
import java.util.List;

public interface IDao <T> {
    T get(int id) throws IOException;

    List<T> getAll() throws IOException;

    void change(T item) throws IOException;

    void add(T item) throws IOException;

    void del(int id) throws IOException;
}
