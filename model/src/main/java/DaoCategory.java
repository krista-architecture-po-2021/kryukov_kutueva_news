import java.util.List;

public class DaoCategory implements IDao<DoCategory> {

    public static final String CATEGORY = "categories";

    private IProvider provider;

    public DaoCategory(IProvider provider) {
        this.provider = provider;
    }

    @Override
    public DoCategory get(int id) {
        return provider.get(CATEGORY, id);
    }

    @Override
    public List<DoCategory> getAll() {
        return provider.getAll(CATEGORY);
    }

    @Override
    public void change(DoCategory item) {
        provider.change(CATEGORY, item);
    }

    @Override
    public void add(DoCategory item) {
        provider.add(CATEGORY, item);
    }

    @Override
    public void del(int id) {
        provider.del(CATEGORY, id);
    }

    @Override
    public List<Integer> getAllIds() {
        return provider.getAllIds(CATEGORY);
    }

}
