package it.unibs.se_project.service;

import it.unibs.se_project.business.Item;
import it.unibs.se_project.business.RegistroMagazzinoDictionary;
import it.unibs.se_project.repository.interfaces.RegistroMagazzinoRepository;

public class RegistroMagazzinoService {
    private final RegistroMagazzinoRepository<RegistroMagazzinoDictionary> repository;

    public RegistroMagazzinoService(RegistroMagazzinoRepository<RegistroMagazzinoDictionary> calendarioRepository) {
        this.repository = calendarioRepository;
    }

    public RegistroMagazzinoDictionary getRegistroMagazzinoDictionary() {
        return repository.getRegistroMagazzinoDictionary();
    }

    public void updateRegistroMagazzino(RegistroMagazzinoDictionary registroMagazzino) {
        repository.updateRegistroMagazzinoDictionary(registroMagazzino);
    }

    public Item getItemFromName(String itemName) {
        return getRegistroMagazzinoDictionary().getRegistroMagazzino().get(itemName);
    }

    public void inputItem(Item item) {
        getRegistroMagazzinoDictionary().input(item);
        repository.updateRegistroMagazzinoDictionary(getRegistroMagazzinoDictionary());
    }

    public void outputItem(Item item) {
        getRegistroMagazzinoDictionary().output(item);
        repository.updateRegistroMagazzinoDictionary(getRegistroMagazzinoDictionary());
    }
}