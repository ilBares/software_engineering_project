package it.unibs.se_project.repository;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.unibs.se_project.business.dictionary.GeneriExtraDictionary;
import it.unibs.se_project.repository.interfaces.GeneriExtraRepository;

public class JsonGeneriExtraRepository implements GeneriExtraRepository<GeneriExtraDictionary>{
    public static final String FILE_NAME = "resources/generi_extra.json";
    private final ObjectMapper mapper = new ObjectMapper();
    private GeneriExtraDictionary genereExtraDictionary;
    
    public JsonGeneriExtraRepository() {
        try (FileReader fileReader = new FileReader(FILE_NAME)) {
            genereExtraDictionary = mapper.readValue(fileReader, GeneriExtraDictionary.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public GeneriExtraDictionary getGeneriExtraDictionary() {
        return genereExtraDictionary;
    }

    @Override
    public void setGeneriExtraDictionary(GeneriExtraDictionary generiExtraDictionary) {
        this.genereExtraDictionary = generiExtraDictionary;
    }

    // @Override
    // public void add(GenereExtra genereExtra) {
    //     try {
    //         generiExtra.add(genereExtra);
    //         save();
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }

    // @Override
    // public boolean delete(GenereExtra genereExtra) {
    //     boolean deleted = false;
    
    //     try {
    //         deleted = generiExtra.remove(genereExtra);
    //         save();
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }

    //     return deleted;
    // }

    private void save() throws IOException {
        mapper.writeValue(new File(FILE_NAME), genereExtraDictionary);
    }
}
