package it.unibs.se_project.repository;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.unibs.se_project.business.GenereExtra;
import it.unibs.se_project.repository.interfaces.GeneriExtraRepository;

public class JsonGeneriExtraRepository implements GeneriExtraRepository<GenereExtra>{
    public static final String FILE_NAME = "resources/generi_extra.json";
    private final ObjectMapper mapper = new ObjectMapper();
    private ArrayList<GenereExtra> generiExtra;
    
    public JsonGeneriExtraRepository() {
        try (FileReader fileReader = new FileReader(FILE_NAME)) {
            GenereExtra[] array = mapper.readValue(fileReader, GenereExtra[].class);
            setGeneriExtra(array);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<GenereExtra> getGeneriExtra() {
        return generiExtra;
    }

    @Override
    public void setGeneriExtra(GenereExtra[] array) {
        generiExtra = array != null
            ? new ArrayList<GenereExtra>(List.of(array))
            : new ArrayList<GenereExtra>();
    }

    @Override
    public void add(GenereExtra genereExtra) {
        try {
            generiExtra.add(genereExtra);
            save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean delete(GenereExtra genereExtra) {
        boolean deleted = false;
    
        try {
            deleted = generiExtra.remove(genereExtra);
            save();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return deleted;
    }

    private void save() throws IOException {
        mapper.writeValue(new File(FILE_NAME), generiExtra);
    }
}
