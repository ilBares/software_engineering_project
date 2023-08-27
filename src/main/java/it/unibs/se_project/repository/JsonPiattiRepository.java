package it.unibs.se_project.repository;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.unibs.se_project.business.Piatto;
import it.unibs.se_project.repository.interfaces.PiattiRepository;

public class JsonPiattiRepository implements PiattiRepository<Piatto> {
    public static final String FILE_NAME = "resources/piatti.json";
    private final ObjectMapper mapper = new ObjectMapper();
    private ArrayList<Piatto> piatti;

    public JsonPiattiRepository() {
        try (FileReader fileReader = new FileReader(FILE_NAME)) {
            Piatto[] array = mapper.readValue(fileReader, Piatto[].class);
            setPiatti(array);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Piatto> getPiatti() {
        return piatti;
    }

    @Override
    public void setPiatti(Piatto[] array) {
        piatti = array != null
            ? new ArrayList<Piatto>(List.of(array))
            : new ArrayList<Piatto>();
    }

    @Override
    public void add(Piatto piatto) {
        try {
            piatti.add(piatto);
            save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean delete(Piatto piatto) {
        boolean deleted = false;
    
        try {
            deleted = piatti.remove(piatto);
            save();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return deleted;
    }

    private void save() throws IOException {
        mapper.writeValue(new File(FILE_NAME), piatti);
    }
}
