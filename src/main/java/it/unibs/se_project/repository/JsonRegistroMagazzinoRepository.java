package it.unibs.se_project.repository;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.unibs.se_project.business.RegistroMagazzino;
import it.unibs.se_project.repository.interfaces.RegistroMagazzinoRepository;

public class JsonRegistroMagazzinoRepository implements RegistroMagazzinoRepository<RegistroMagazzino> {
    public static final String FILE_NAME = "resources/sample_registro_magazzino.json";
    private final ObjectMapper mapper = new ObjectMapper();
    private RegistroMagazzino registroMagazzino;

    public JsonRegistroMagazzinoRepository() {
        try (FileReader fileReader = new FileReader(FILE_NAME)) {
            registroMagazzino = mapper.readValue(fileReader, RegistroMagazzino.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public RegistroMagazzino getRegistroMagazzino() {
        return registroMagazzino;
    }

    @Override
    public void updateRegistroMagazzino(RegistroMagazzino registroMagazzino) {
        try {
            this.registroMagazzino = registroMagazzino;
            save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void save() throws IOException {
        mapper.writeValue(new File(FILE_NAME), registroMagazzino);
    }
}
