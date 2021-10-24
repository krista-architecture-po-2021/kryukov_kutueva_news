import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class DbConnection {

    public static final String NEWS = "news";
    public static final String CATEGORY = "category";

    private static final String user = "root";
    private static final String password = "root";

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/newsservice";

    public <T> T get(String entityName, int id) {
        if (NEWS.equals(entityName)) {
            return (T) getNews(id);
        }
        return (T) getCategory(id);
    }

    private DoNews getNews(int id) {
        ResultSetHandler<DoNews> handler = new BeanHandler<>(DoNews.class);
        QueryRunner queryRunner = new QueryRunner();
        DbUtils.loadDriver(JDBC_DRIVER);
        try (Connection connection = DriverManager.getConnection(DB_URL, user, password);) {
            String query = "SELECT * FROM news WHERE id = ?";
            return queryRunner.query(connection, query, handler, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private DoCategory getCategory(int id) {
        ResultSetHandler<DoCategory> handler = new BeanHandler<>(DoCategory.class);
        QueryRunner queryRunner = new QueryRunner();
        DbUtils.loadDriver(JDBC_DRIVER);
        try (Connection connection = DriverManager.getConnection(DB_URL, user, password)) {
            String query = "SELECT * FROM categories WHERE id = ?";
            return queryRunner.query(connection, query, handler, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T> List<T> getAll(String entityName) {
        return null;
    }

    private List<DoCategory> getAllCategories() {
        ResultSetHandler<List<DoCategory>> handler = new BeanListHandler<>(DoCategory.class);
        QueryRunner queryRunner = new QueryRunner();
        DbUtils.loadDriver(JDBC_DRIVER);
        try (Connection connection = DriverManager.getConnection(DB_URL, user, password)) {
            String query = "SELECT * FROM categories";
            return queryRunner.query(connection, query, handler);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T> void changeCategory(T doCategory) {

    }

    public void addCategory(DoCategory doCategory) {

    }

    public void delCategory(int id) {

    }

}
