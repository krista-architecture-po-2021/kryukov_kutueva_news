import java.util.List;

public class CategoryController implements ICategoryController{

    @Override
    public List<ICategoryInput> getCategoriesList() {
        return AllCategories.getInstance().getAllCategories();
    }

    @Override
    public void addCategory(ICategoryInput category) {
        //modelCategories.setCategory(category);
    }

    @Override
    public void renewCategory(int id, ICategoryInput category) {

    }

    @Override
    public void deleteCategory(int id) {

    }
}
