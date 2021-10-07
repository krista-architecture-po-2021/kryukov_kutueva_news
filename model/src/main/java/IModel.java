import java.util.List;

public interface IModel {
    DaoNews getDaoNews();
    DaoCategory getDaoCategory();
    //List<DaoNews> getDaoNewsByCategory(int categoryId);
}
