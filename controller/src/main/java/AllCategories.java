import java.util.ArrayList;
import java.util.List;

public class AllCategories implements IAllCategories {

    private static volatile AllCategories instance;

    private ArrayList<ICategoryInput> allCategories = new ArrayList<>();

    public void setAllCategories(List<ICategoryInput> categories) {
        allCategories = (ArrayList<ICategoryInput>) categories;
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
    public List<ICategoryInput> getAllCategories() {
        return allCategories;
    }
}