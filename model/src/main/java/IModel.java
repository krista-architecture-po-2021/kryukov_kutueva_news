import java.util.List;

public interface IModel {
    IDao<DoNews> getDaoNews();
    IDao<DoCategory> getDaoCategory();
    //List<DaoNews> getDaoNewsByCategory(int categoryId);
}
