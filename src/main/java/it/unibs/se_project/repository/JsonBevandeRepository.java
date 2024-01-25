package it.unibs.se_project.repository;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.unibs.se_project.business.dictionary.BevandeDictionary;
import it.unibs.se_project.repository.interfaces.BevandeRepository;

public class JsonBevandeRepository implements BevandeRepository<BevandeDictionary> {
    public static final String FILE_NAME = "resources/bevande.json";
    private final ObjectMapper mapper = new ObjectMapper();
    private BevandeDictionary bevandeDictionary;

    public JsonBevandeRepository() {
        try (FileReader fileReader = new FileReader(FILE_NAME)) {
            bevandeDictionary = mapper.readValue(fileReader, BevandeDictionary.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public BevandeDictionary getBevandeDictionary() {
        return bevandeDictionary;
    }

    @Override
    public void setBevandeDictionary(BevandeDictionary bevandeDictionary) {
        this.bevandeDictionary = bevandeDictionary;
    }

    // @Override
    // public void add(Bevanda bevanda) {
    //     try {
    //         bevande.add(bevanda);
    //         save();
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }

    // @Override
    // public boolean delete(Bevanda bevanda) {
    //     boolean deleted = false;
    
    //     try {
    //         deleted = bevande.remove(bevanda);
    //         save();
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }

    //     return deleted;
    // }

    // public void add(Bevanda bevanda) {
    //     try {
    //         bevandeDictionary.putBevanda(bevanda);
    //         save();
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }

    private void save() throws IOException {
        mapper.writeValue(new File(FILE_NAME), bevandeDictionary);
    }
}
