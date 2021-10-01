import java.util.List;

public interface ICategoryController {
    List<ICategory> getCategoriesList();
    void addCategory(ICategory category);
    void renewCategory(int id, ICategory category);
    void deleteCategory(int id);
}
