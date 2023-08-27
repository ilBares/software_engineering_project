package it.unibs.se_project.repository;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.unibs.se_project.business.Bevanda;
import it.unibs.se_project.repository.interfaces.BevandeRepository;

public class JsonBevandeRepository implements BevandeRepository<Bevanda> {
    public static final String FILE_NAME = "resources/bevande.json";
    private final ObjectMapper mapper = new ObjectMapper();
    private ArrayList<Bevanda> bevande;

    public JsonBevandeRepository() {
        try (FileReader fileReader = new FileReader(FILE_NAME)) {
            Bevanda[] array = mapper.readValue(fileReader, Bevanda[].class);
            setBevande(array);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Bevanda> getBevande() {
        return bevande;
    }

    @Override
    public void setBevande(Bevanda[] array) {
        bevande = array != null
            ? new ArrayList<Bevanda>(List.of(array))
            : new ArrayList<Bevanda>();
    }

    @Override
    public void add(Bevanda bevanda) {
        try {
            bevande.add(bevanda);
            save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean delete(Bevanda bevanda) {
        boolean deleted = false;
    
        try {
            deleted = bevande.remove(bevanda);
            save();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return deleted;
    }

    private void save() throws IOException {
        mapper.writeValue(new File(FILE_NAME), bevande);
    }
}
