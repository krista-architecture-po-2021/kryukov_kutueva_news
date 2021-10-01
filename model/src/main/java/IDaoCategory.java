import java.util.List;

public interface IDaoCategory {
    News getCategory(int id);

    List<Category> getAllCategory();

    void changeCategory(Category category);

    void addCategory(Category category);

    void delCategory(Category category);
}
