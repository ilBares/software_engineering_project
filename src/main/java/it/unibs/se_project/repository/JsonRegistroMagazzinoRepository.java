package it.unibs.se_project.repository;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.unibs.se_project.business.RegistroMagazzinoDictionary;
import it.unibs.se_project.repository.interfaces.RegistroMagazzinoRepository;

public class JsonRegistroMagazzinoRepository implements RegistroMagazzinoRepository<RegistroMagazzinoDictionary> {
    public static final String FILE_NAME = "resources/sample_registro_magazzino.json";
    private final ObjectMapper mapper = new ObjectMapper();
    private RegistroMagazzinoDictionary registroMagazzinoDictionary;

    public JsonRegistroMagazzinoRepository() {
        try (FileReader fileReader = new FileReader(FILE_NAME)) {
            registroMagazzinoDictionary = mapper.readValue(fileReader, RegistroMagazzinoDictionary.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public RegistroMagazzinoDictionary getRegistroMagazzinoDictionary() {
        return registroMagazzinoDictionary;
    }

    @Override
    public void updateRegistroMagazzinoDictionary(RegistroMagazzinoDictionary registroMagazzinoDictionary) {
        try {
            this.registroMagazzinoDictionary = registroMagazzinoDictionary;
            save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void save() throws IOException {
        mapper.writeValue(new File(FILE_NAME), registroMagazzinoDictionary);
    }
}
