import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class CategoryController implements ICategoryController{

    @Inject
    IModel model;

    @Override
    public List<DtoCategory> getCategoriesList() {
        List<Category> categories = AllCategories.getInstance().getAllCategories();
        ArrayList<DtoCategory> dtoCategories = new ArrayList<>();
        for (Category category: categories) {
            DtoCategory dtoCategory = new DtoCategory(category.getId(), category.getName());
            dtoCategories.add(dtoCategory);
        }
        return dtoCategories;
    }

    @Override
    public int addCategory(ICategoryInput category) {
        return addCategory(category.getName());
    }

    @Override
    public int addCategory(String name) {
        int newId = getCategoryNextId();
        Category newCategory = new Category(newId, name);
        DaoCategory daoCategory = model.getDaoCategory();
        DoCategory doCategory = new DoCategory(newCategory.getId(), newCategory.getName());
        daoCategory.add(doCategory);
        return newId;
    }

    @Override
    public void changeCategory(int id, ICategoryInput category) {
        Category newCategory = new Category(id, category.getName());
        DoCategory doCategory = new DoCategory(newCategory.getId(), newCategory.getName());
        DaoCategory daoCategory = model.getDaoCategory();
        daoCategory.change(doCategory);
    }

    @Override
    public void deleteCategory(int id) {
        DaoCategory daoCategory = model.getDaoCategory();
        daoCategory.del(id);
    }

    public static int getCategoryNextId() {
        return AllCategories.getInstance().getNextFreeId();
    }
}
