public abstract class ModelFactory {
    private static final int JSON = 1;
    private static final int DB = 2;

//    public abstract IDao getDaoNews();
//    public  abstract IDao getCategoryDao();

    public abstract DaoNews getDaoNews(int value);
    public  abstract DaoCategory getCategoryDao(int value);

    public static ModelFactory getModel(int value){
        if (value == JSON)
            return new JsonModel();
        return new DbModel();
    }
}
