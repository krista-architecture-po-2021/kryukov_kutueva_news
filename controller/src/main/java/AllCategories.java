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
        Category lastCategory = allCategories.get(allCategories.size() - 1);
        return (lastCategory != null) ? (lastCategory.getId() + 1) : 1;
    }

}