import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AllCategories implements IAllCategories {

    private static volatile AllCategories instance;

    private ArrayList<Category> allCategories = new ArrayList<>();

    public void setAllCategories(List<Category> categories) {
        allCategories = (ArrayList<Category>) categories;
    }

    private AllCategories() {};

    public static AllCategories getInstance(){
        AllCategories localInstance = instance;
        if (localInstance == null) {
            synchronized (AllCategories.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new AllCategories();
                    DaoCategory daoCategory = ModelFactory.getModel().getDaoCategory(NewsService.CONTROLLER);
                    List<DoCategory> doCategories = daoCategory.getAll();
                    List<Category> categories = new ArrayList<>();
                    for (DoCategory doCat: doCategories) {
                        Category category = new Category(doCat.getId(), doCat.getName());
                        categories.add(category);
                    }
                    instance.setAllCategories(categories);
                }
            }
        }
        return localInstance;
    }

    @Override
    public List<Category> getAllCategories() {
        return allCategories;
    }

    @Override
    public int getNextFreeId() {
        for (int i = 1; i <= allCategories.size(); i ++) {
            if (i != allCategories.get(i - 1).getId()) {
                return i;
            }
        }
        return allCategories.size() + 1;
    }

}