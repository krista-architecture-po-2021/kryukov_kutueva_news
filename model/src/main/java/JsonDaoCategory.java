import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JsonDaoCategory implements IDao<DoCategory> {

    ObjectMapper objectMapper;

    private static final String path = "category.json";

    public JsonDaoCategory(){
        objectMapper = new ObjectMapper();
    }

    public List<DoCategory> readJson(){
        File file = new File(path);
        try {
            return objectMapper.readValue(file, new TypeReference<List<DoCategory>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void writeCategory(List<DoCategory> listCategory){
        try {
            FileWriter fileWriter = new FileWriter(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public DoCategory get(int id){
        List<DoCategory> listCategory = readJson();
        return listCategory.get(id);
    }

    @Override
    public List<DoCategory> getAll(){
        return readJson();
    }

    @Override
    public void change(DoCategory item){
        List<DoCategory> listCategory = readJson();
        listCategory.set(item.id,item);
        writeCategory(listCategory);
    }

    @Override
    public void add(DoCategory item){
        List<DoCategory> listCategory = readJson();
        listCategory.add(item);
        writeCategory(listCategory);
    }

    @Override
    public void del(int id){
        List<DoCategory> listCategory = readJson();
        listCategory.remove(id);
        writeCategory(listCategory);
    }
}
