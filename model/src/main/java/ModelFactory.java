public abstract class ModelFactory {
    private static final int JSON = 1;
    private static final int DB = 2;

//    public abstract IDao getDaoNews();
//    public  abstract IDao getCategoryDao();

    public abstract DaoNews getDaoNews(int value);
    public  abstract DaoCategory getDaoCategory(int value);

    public static ModelFactory getModel(){
        return new FormatModel();
    }
}
