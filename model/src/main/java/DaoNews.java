import java.util.List;

public class DaoNews implements IDao<DoNews> {

    public static final String NEWS = "news";

    private IProvider provider;

    public DaoNews(IProvider provider) {
        this.provider = provider;
    }

    @Override
    public DoNews get(int id) {
        return provider.get(NEWS, id);
    }

    @Override
    public List<DoNews> getAll() {
        return provider.getAll(NEWS);
    }

    @Override
    public void change(DoNews news){
        provider.change(NEWS, news);
    }

    @Override
    public void add(DoNews news){
        provider.add(NEWS, news);
    }

    @Override
    public void del(int id){
        provider.del(NEWS, id);
    }

    @Override
    public List<Integer> getAllIds() {
        return provider.getAllIds(NEWS);
    }
}
