import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FormatProviderJson implements IProvider {

    public static final String NEWS = "news";
    public static final String CATEGORY = "category";
    public static final String PATH_NEWS = "news.json";
    public static final String PATH_CATEGORY = "category.json";

    ObjectMapper objectMapper;
    String path;

    public FormatProviderJson(){
        objectMapper = new ObjectMapper();
    }

    @Override
    public <T extends IBaseEntity> T get(String entityName, int id) {
        choosePath(entityName);
        List<T> list = readJson();
        return list.get(id);

    }

    @Override
    public <T extends IBaseEntity> List<T> getAll(String entityName) {
        choosePath(entityName);
        return readJson();
    }

    @Override
    public <T extends IBaseEntity> void change(String entityName, T item) {
        choosePath(entityName);
        List<T> list = readJson();

        list.set(item.getId(),item);


    }

    @Override
    public <T extends IBaseEntity> void add(String entityName, T item) {

    }

    @Override
    public void del(String entityName, int id) {

    }

    public <T> List<T> readJson(){
        File file = new File(path);
        try {
            return objectMapper.readValue(file, new TypeReference<List<T>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T> void writeNews(List<T> list){
        try {
            FileWriter fileWriter = new FileWriter(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void choosePath(String entityName){
        if(NEWS.equals(entityName)) {
            path = PATH_NEWS;
        }
        else{
            path = PATH_CATEGORY;
        }
    }

}
