import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FormatProviderDB implements IProvider{

    public static final String NEWS = "news";

    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/newsservice";

    @Override
    public <T extends IBaseEntity> T get(String entityName, int id) {
        if (NEWS.equals(entityName)) {
            return (T) getNews(id);
        }
        return (T) getCategory(id);
    }

    @Override
    public <T extends IBaseEntity> List<T> getAll(String entityName) {
        if(NEWS.equals(entityName)) {
            return (List<T>) getAllNews();
        } else {
            return (List<T>) getAllCategories();
        }
    }

    @Override
    public <T extends IBaseEntity> void change(String entityName, T item) {
        if (NEWS.equals(entityName)) {
            changeNews((DoNews) item);
        } else {
            changeCategory((DoCategory) item);
        }
    }

    @Override
    public <T extends IBaseEntity> void add(String entityName, T item) {
        if (NEWS.equals(entityName)) {
            addNews((DoNews) item);
        } else {
            addCategory((DoCategory) item);
        }
    }

    @Override
    public void del(String entityName, int id) {
        String query = "DELETE FROM " + entityName + " WHERE id = ?";
        QueryRunner queryRunner = new QueryRunner();
        DbUtils.loadDriver(JDBC_DRIVER);
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            queryRunner.update(connection, query, id);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Integer> getAllIds(String entityName) {
        String query = "SELECT id FROM " + entityName;
        ArrayList<Integer> idList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int usedId = resultSet.getInt("id");
                idList.add(usedId);
            }
        }
        catch  (SQLException e) {
            System.out.println(e.getMessage());
        }
        return idList;
    }

    private DoNews getNews(int id) {
        String query = "SELECT * FROM news WHERE id = ?";
        ResultSetHandler<DoNews> handler = new BeanHandler<>(DoNews.class);
        QueryRunner queryRunner = new QueryRunner();
        DbUtils.loadDriver(JDBC_DRIVER);
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            return queryRunner.query(connection, query, handler, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private DoCategory getCategory(int id) {
        String query = "SELECT * FROM categories WHERE id = ?";
        ResultSetHandler<DoCategory> handler = new BeanHandler<>(DoCategory.class);
        QueryRunner queryRunner = new QueryRunner();
        DbUtils.loadDriver(JDBC_DRIVER);
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            return queryRunner.query(connection, query, handler, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<DoCategory> getAllCategories() {
        String query = "SELECT * FROM categories";
        ResultSetHandler<List<DoCategory>> handler = new BeanListHandler<>(DoCategory.class);
        QueryRunner queryRunner = new QueryRunner();
        DbUtils.loadDriver(JDBC_DRIVER);
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            return queryRunner.query(connection, query, handler);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<DoNews> getAllNews() {
        String query = "SELECT * FROM news";
        ResultSetHandler<List<DoNews>> handler = new BeanListHandler<>(DoNews.class);
        QueryRunner queryRunner = new QueryRunner();
        DbUtils.loadDriver(JDBC_DRIVER);
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            return queryRunner.query(connection, query, handler);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void changeNews(DoNews item) {
        String query = "UPDATE news SET title = ?, date = ?, categoryId = ?, text = ?, author = ? WHERE id = ?";
        QueryRunner queryRunner = new QueryRunner();
        DbUtils.loadDriver(JDBC_DRIVER);
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            queryRunner.update(connection, query, item.getTitle(),
                    item.getDate(), item.getCategoryId(), item.getText(), item.getAuthor(), item.getId());
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void changeCategory(DoCategory item) {
        String query = "UPDATE categories SET name = ? WHERE id = ?";
        QueryRunner queryRunner = new QueryRunner();
        DbUtils.loadDriver(JDBC_DRIVER);
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            queryRunner.update(connection, query, item.getName(), item.getId());
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addNews(DoNews item) {
        String query = "INSERT INTO news (id, title, date, categoryId, text, author) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        QueryRunner queryRunner = new QueryRunner();
        DbUtils.loadDriver(JDBC_DRIVER);
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            queryRunner.update(connection, query, item.getId(),
                    item.getTitle(), item.getDate(), item.getCategoryId(), item.getText(), item.getAuthor());
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addCategory(DoCategory item) {
        String query = "INSERT INTO categories (id, name) VALUES (?, ?)";
        DbUtils.loadDriver(JDBC_DRIVER);
        QueryRunner queryRunner = new QueryRunner();
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            queryRunner.update(connection, query, item.getId(), item.getName());
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
