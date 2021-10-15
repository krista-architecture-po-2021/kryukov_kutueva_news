import java.util.ArrayList;
import java.util.List;

public class DbDaoCategory implements IDao<DoCategory> {

    List<DoCategory> listCategory;

    public DbDaoCategory(){
        listCategory = new ArrayList<>();
    }

    @Override
    public DoCategory get(int id) {
        return listCategory.get(id);
    }

    @Override
    public List<DoCategory> getAll() {
        return listCategory;
    }

    @Override
    public void change(DoCategory item) {
        listCategory.set(item.id,item);
    }

    @Override
    public void add(DoCategory item) {
        listCategory.add(item);
    }

    @Override
    public void del(int id) {
        listCategory.remove(id);
    }
}
