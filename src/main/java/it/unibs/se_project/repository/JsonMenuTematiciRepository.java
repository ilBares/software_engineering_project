package it.unibs.se_project.repository;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.unibs.se_project.business.MenuTematico;
import it.unibs.se_project.repository.interfaces.MenuTematiciRepository;

public class JsonMenuTematiciRepository implements MenuTematiciRepository<MenuTematico> {
    public static final String FILE_NAME = "resources/menu_tematici.json";
    private final ObjectMapper mapper = new ObjectMapper();
    private ArrayList<MenuTematico> menuTematici;

    public JsonMenuTematiciRepository() {
        try (FileReader fileReader = new FileReader(FILE_NAME)) {
            MenuTematico[] array = mapper.readValue(fileReader, MenuTematico[].class);
            setMenuTematici(array);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<MenuTematico> getMenuTematici() {
        return menuTematici;
    }

    @Override
    public void setMenuTematici(MenuTematico[] array) {
        menuTematici = array != null
            ? new ArrayList<MenuTematico>(List.of(array))
            : new ArrayList<MenuTematico>();
    }

    @Override
    public void add(MenuTematico menuTematico) {
        try {
            menuTematici.add(menuTematico);
            save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean delete(MenuTematico menuTematico) {
        boolean deleted = false;
    
        try {
            deleted = menuTematici.remove(menuTematico);
            save();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return deleted;
    }

    private void save() throws IOException {
        mapper.writeValue(new File(FILE_NAME), menuTematici);
    }
}
