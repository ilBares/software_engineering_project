package it.unibs.se_project.repository;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.unibs.se_project.model.Config;
import it.unibs.se_project.repository.interfaces.ConfigRepository;

public class JsonConfigRepository implements ConfigRepository<Config> {
    public static final String FILE_NAME = "src/main/resources/config.json";
    private final ObjectMapper mapper = new ObjectMapper();
    private Config config;

    public JsonConfigRepository() {
      try (FileReader fileReader = new FileReader(FILE_NAME)) {
        config = mapper.readValue(fileReader, Config.class);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    @Override
    public Config getConfig() {
      return config;
    }

    @Override
    public void updateConfig(Config config) {
      try {
        this.config = config;
        save();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    private void save() throws IOException {
      mapper.writeValue(new File(FILE_NAME), config);
    }
}
