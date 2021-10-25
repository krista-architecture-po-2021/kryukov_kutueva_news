public interface IModel {
    IDao getDaoNews();
    IDao getDaoCategory();
    //List<DaoNews> getDaoNewsByCategory(int categoryId);
}
