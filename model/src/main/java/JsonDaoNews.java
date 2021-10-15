import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JsonDaoNews implements IDao<DoNews> {

    ObjectMapper objectMapper;

    private static final String path = "news.json";

    public JsonDaoNews(){
        objectMapper = new ObjectMapper();
    }

    public List<DoNews> readJson() throws IOException {
        File file = new File(path);
        return objectMapper.readValue(file, new TypeReference<List<DoNews>>(){});
    }

    public void writeNews(List<DoNews> listNews) throws IOException{
        FileWriter fileWriter = new FileWriter(path);
    }

    @Override
    public DoNews get(int id) throws IOException {
        List<DoNews> listNews = readJson();
        return listNews.get(id);
    }

    @Override
    public List<DoNews> getAll() throws IOException {
        return readJson();
    }

    @Override
    public void change(DoNews news) throws IOException {
        List<DoNews> listNews = readJson();
        listNews.set(news.id,news);
        writeNews(listNews);
    }

    @Override
    public void add(DoNews news) throws IOException {
        List<DoNews> listNews = readJson();
        listNews.add(news);
        writeNews(listNews);
    }

    @Override
    public void del(int id) throws IOException {
        List<DoNews> listNews = readJson();
        listNews.remove(id);
        writeNews(listNews);
    }
}