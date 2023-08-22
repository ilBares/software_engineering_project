package it.unibs.se_project.service;

import it.unibs.se_project.business.RegistroMagazzino;
import it.unibs.se_project.repository.interfaces.RegistroMagazzinoRepository;

public class RegistroMagazzinoService {
    private final RegistroMagazzinoRepository<RegistroMagazzino> repository;
    private RegistroMagazzino registroMagazzino;

    public RegistroMagazzinoService(RegistroMagazzinoRepository<RegistroMagazzino> calendarioRepository) {
        this.repository = calendarioRepository;
    }

    public RegistroMagazzino getRegistroMagazzino() {
        if (registroMagazzino == null) {
            registroMagazzino = repository.getRegistroMagazzino();
        }
        return registroMagazzino;
    }

    public void updateRegistroMagazzino(RegistroMagazzino registroMagazzino) {
        repository.updateRegistroMagazzino(registroMagazzino);

    }

}