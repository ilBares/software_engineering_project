package it.unibs.se_project.business.dictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.unibs.se_project.business.MenuTematico;

public class MenuTematiciDictionary {
    private HashMap<String, MenuTematico> menuTematiciMap;

    @JsonCreator
    public MenuTematiciDictionary(
        @JsonProperty("menu_tematici") HashMap<String, MenuTematico> menuTematici
    ) {
        this.menuTematiciMap = menuTematici;
    }

    public MenuTematico getMenuTematico(String menuTematicoName) {
        return menuTematiciMap.get(menuTematicoName);
    }

    public void putMenuTematico(MenuTematico menuTematico) {
        menuTematiciMap.put(menuTematico.getNome(), menuTematico);
    }

    public List<MenuTematico> getMenuTematiciList() {
        return new ArrayList<>(menuTematiciMap.values());
    }

    public List<String> getMenuTematiciNames() {
        return new ArrayList<>(menuTematiciMap.keySet());
    }
}
