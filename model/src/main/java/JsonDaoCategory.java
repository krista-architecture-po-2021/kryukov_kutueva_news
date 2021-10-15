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

    public List<DoCategory> readJson() throws IOException {
        File file = new File(path);
        return objectMapper.readValue(file, new TypeReference<List<DoCategory>>(){});
    }

    public void writeCategory(List<DoCategory> listCategory) throws IOException{
        FileWriter fileWriter = new FileWriter(path);
    }

    @Override
    public DoCategory get(int id) throws IOException {
        List<DoCategory> listCategory = readJson();
        return listCategory.get(id);
    }

    @Override
    public List<DoCategory> getAll() throws IOException {
        return readJson();
    }

    @Override
    public void change(DoCategory item) throws IOException {
        List<DoCategory> listCategory = readJson();
        listCategory.set(item.id,item);
        writeCategory(listCategory);
    }

    @Override
    public void add(DoCategory item) throws IOException {
        List<DoCategory> listCategory = readJson();
        listCategory.add(item);
        writeCategory(listCategory);
    }

    @Override
    public void del(int id) throws IOException {
        List<DoCategory> listCategory = readJson();
        listCategory.remove(id);
        writeCategory(listCategory);
    }
}
