import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class CategoryController implements ICategoryController{

    /*@Inject
    IModel model;*/

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
        DaoCategory daoCategory = ModelFactory.getModel().getDaoCategory(1);
        DoCategory doCategory = new DoCategory(newCategory.getId(), newCategory.getName());
        daoCategory.add(doCategory);
        updateCategoryCache(daoCategory);
        return newId;
    }

    @Override
    public void changeCategory(int id, ICategoryInput category) {
        Category newCategory = new Category(id, category.getName());
        DoCategory doCategory = new DoCategory(newCategory.getId(), newCategory.getName());
        DaoCategory daoCategory = ModelFactory.getModel().getDaoCategory(1);
        daoCategory.change(doCategory);
        updateCategoryCache(daoCategory);
    }

    @Override
    public void deleteCategory(int id) {
        DaoCategory daoCategory = ModelFactory.getModel().getDaoCategory(1);
        daoCategory.del(id);
        updateCategoryCache(daoCategory);
    }

    public static int getCategoryNextId() {
        return AllCategories.getInstance().getNextFreeId();
    }

    private void updateCategoryCache(DaoCategory daoCategory) {
        List<DoCategory> doCategories = daoCategory.getAll();
        List<Category> categories = new ArrayList<>();
        for (DoCategory doCat: doCategories) {
            Category category = new Category(doCat.getId(), doCat.getName());
            categories.add(category);
        }
        AllCategories.getInstance().setAllCategories(categories);
    }
}
