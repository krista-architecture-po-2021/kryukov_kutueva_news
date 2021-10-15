import java.util.List;

public interface ICategoryController {
    List<DtoCategory> getCategoriesList();
    int addCategory(ICategoryInput category);
    int addCategory(String name);
    void changeCategory(int id, ICategoryInput category);
    void deleteCategory(int id);
}
