import java.util.List;

public interface ICategoryController {
    List<DTOCategory> getCategoriesList();
    void addCategory(ICategoryInput category);
    void renewCategory(int id, ICategoryInput category);
    void deleteCategory(int id);
}
