import javax.inject.Inject;
import java.util.List;

public class CategoryController implements ICategoryController{

    @Override
    public List<ICategory> getCategoriesList() {
        return AllCategories.getInstance().getAllCategories();
    }

    @Override
    public void addCategory(ICategory category) {
        //modelCategories.setCategory(category);
    }

    @Override
    public void renewCategory(int id, ICategory category) {

    }

    @Override
    public void deleteCategory(int id) {

    }
}
