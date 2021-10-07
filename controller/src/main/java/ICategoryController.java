import java.util.List;

public interface ICategoryController {
    List<DtoCategory> getCategoriesList();
    void addCategory(ICategoryInput category);
    void changeCategory(int id, ICategoryInput category);
    void deleteCategory(int id);
}
