package it.unibs.se_project.repository;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.unibs.se_project.model.GenereAlimentare;
import it.unibs.se_project.repository.interfaces.GeneriAlimentariRepository;

public class JsonGeneriAlimentariRepository implements GeneriAlimentariRepository<GenereAlimentare>{
    public static final String FILE_NAME = "src/main/resources/generi_alimentari.json";
    private final ObjectMapper mapper = new ObjectMapper();
    private ArrayList<GenereAlimentare> generiAlimentari;
    
    public JsonGeneriAlimentariRepository() {
        try (FileReader fileReader = new FileReader(FILE_NAME)) {
            GenereAlimentare[] array = mapper.readValue(fileReader, GenereAlimentare[].class);
            setGeneriAlimentari(array);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<GenereAlimentare> getGeneriAlimentari() {
        return generiAlimentari;
    }

    @Override
    public void setGeneriAlimentari(GenereAlimentare[] array) {
        generiAlimentari = array != null
            ? new ArrayList<GenereAlimentare>(List.of(array))
            : null;
    }

    @Override
    public void add(GenereAlimentare genereAlimentare) {
        try {
            generiAlimentari.add(genereAlimentare);
            save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean delete(GenereAlimentare genereAlimentare) {
        boolean deleted = false;
    
        try {
            deleted = generiAlimentari.remove(genereAlimentare);
            save();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return deleted;
    }

    private void save() throws IOException {
        mapper.writeValue(new File(FILE_NAME), generiAlimentari);
    }
}
