package it.unibs.se_project.repository;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.unibs.se_project.business.Calendario;
import it.unibs.se_project.repository.interfaces.CalendarioRepository;

public class JsonCalendarioRepository implements CalendarioRepository<Calendario> {
    public static final String FILE_NAME = "resources/calendario.json";
    private final ObjectMapper mapper = new ObjectMapper();
    private Calendario calendario;

    public JsonCalendarioRepository() {
        try (FileReader fileReader = new FileReader(FILE_NAME)) {
            calendario = mapper.readValue(fileReader, Calendario.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Calendario getCalendario() {
        return calendario;
    }

    @Override
    public void updateCalendario(Calendario calendario) {
        try {
            this.calendario = calendario;
            save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void save() throws IOException {
        mapper.writeValue(new File(FILE_NAME), calendario);
    }
}
