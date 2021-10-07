import java.util.ArrayList;
import java.util.List;

public class CategoryController implements ICategoryController{

    @Override
    public List<DtoCategory> getCategoriesList() {
        List<Category> categories = AllCategories.getInstance().getAllCategories();
        ArrayList<DtoCategory> dtoCategories = new ArrayList<>();
        for (Category category: categories) {
            DtoCategory dtoCategory = new DtoCategory(category.getName());
            dtoCategories.add(dtoCategory);
        }
        return dtoCategories;
    }

    @Override
    public void addCategory(ICategoryInput category) {

    }

    @Override
    public void changeCategory(int id, ICategoryInput category) {

    }

    @Override
    public void deleteCategory(int id) {

    }
}
