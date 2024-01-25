package it.unibs.se_project.service;

import java.util.List;

import it.unibs.se_project.business.MenuTematico;
import it.unibs.se_project.business.dictionary.MenuTematiciDictionary;
import it.unibs.se_project.repository.interfaces.MenuTematiciRepository;

public class MenuTematiciService {
    private final MenuTematiciRepository<MenuTematiciDictionary> repository;

    public MenuTematiciService(MenuTematiciRepository<MenuTematiciDictionary> repository) {
        this.repository = repository;
    }

    public List<MenuTematico> getMenuTematici() {
        return repository.getMenuTematiciDictionary().getMenuTematiciList();
    }

    public List<String> getMenuTematiciNames() {
        return repository.getMenuTematiciDictionary().getMenuTematiciNames();
    }

    public MenuTematiciDictionary getMenuTematiciDictionary() {
        return repository.getMenuTematiciDictionary();
    }

    public void addMenuTematico(MenuTematico menuTematico) {
        repository.getMenuTematiciDictionary().putMenuTematico(menuTematico);
    }

    public void getMenuTematicoFromName(String menuTematicoName) {
        repository.getMenuTematiciDictionary().getMenuTematico(menuTematicoName);
    }
}
