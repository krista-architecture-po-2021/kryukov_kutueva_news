import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DbConnection {

    private static final String url = "jdbc:mysql://localhost:3306/test";
    private static final String user = "root";
    private static final String password = "root";

    private static Connection connection;

    public void open() {
        try (Connection connection1 = connection = DriverManager.getConnection(url, user, password)) {
    } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public DoCategory getCategory(int id) {
        return null;
    }

    public <T> List<T> getAllCategories() {
        return null;
    }

    public void changeCategory(DoCategory doCategory) {

    }

    public void addCategory(DoCategory doCategory) {

    }

    public void delCategory(int id) {

    }

    public DoNews getNews(int id) {
        return null;
    }

    public List getAllNews() {
        return null;
    }

    public void changeNews(DoNews doNews) {

    }

    public void addNews(DoNews doNews) {

    }

    public void delNews(int id) {

    }
}
