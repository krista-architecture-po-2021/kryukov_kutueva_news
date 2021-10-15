import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class DbDaoNews implements IDao<DoNews> {

    List<DoNews> listNews;

    public DbDaoNews(){
        listNews.add(new DoNews(1,"tets1",new Date(31,12,2021),1,"NewYear1","qq"));
        listNews.add(new DoNews(2,"tets2",new Date(31,12,2022),2,"NewYear2","ww"));
        listNews.add(new DoNews(3,"tets3",new Date(31,12,2023),3,"NewYear3","ee"));
    }

    @Override
    public DoNews get(int id) {
        return listNews.get(id);
    }

    @Override
    public List<DoNews> getAll() {
        return listNews;
    }

    @Override
    public void change(DoNews news){
        listNews.add(news.id,news);
    }

    @Override
    public void add(DoNews news){
        listNews.add(news);
    }

    @Override
    public void del(int id){
        listNews.remove(id);
    }
}
