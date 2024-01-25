package it.unibs.se_project.repository;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.unibs.se_project.business.dictionary.MenuTematiciDictionary;
import it.unibs.se_project.repository.interfaces.MenuTematiciRepository;

public class JsonMenuTematiciRepository implements MenuTematiciRepository<MenuTematiciDictionary> {
    public static final String FILE_NAME = "resources/menu_tematici.json";
    private final ObjectMapper mapper = new ObjectMapper();
    private MenuTematiciDictionary menuTematiciDictionary;

    public JsonMenuTematiciRepository() {
        try (FileReader fileReader = new FileReader(FILE_NAME)) {
            menuTematiciDictionary = mapper.readValue(fileReader, MenuTematiciDictionary.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public MenuTematiciDictionary getMenuTematiciDictionary() {
        return menuTematiciDictionary;
    }

    @Override
    public void setMenuTematiciDictionary(MenuTematiciDictionary menuTematiciDictionary) {
        this.menuTematiciDictionary = menuTematiciDictionary;
    }

    // @Override
    // public void add(MenuTematico menuTematico) {
    //     try {
    //         menuTematici.add(menuTematico);
    //         save();
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }

    // @Override
    // public boolean delete(MenuTematico menuTematico) {
    //     boolean deleted = false;
    
    //     try {
    //         deleted = menuTematici.remove(menuTematico);
    //         save();
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }

    //     return deleted;
    // }

    private void save() throws IOException {
        mapper.writeValue(new File(FILE_NAME), menuTematiciDictionary);
    }
}
