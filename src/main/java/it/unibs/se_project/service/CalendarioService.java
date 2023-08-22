package it.unibs.se_project.service;

import it.unibs.se_project.business.Calendario;
import it.unibs.se_project.repository.interfaces.CalendarioRepository;

public class CalendarioService {
    private final CalendarioRepository<Calendario> repository;

    public CalendarioService(CalendarioRepository<Calendario> calendarioRepository) {
        this.repository = calendarioRepository;
    }

    public Calendario getCalendario() {
        return repository.getCalendario();
    }

    public void updateCalendario(Calendario calendario) {
        repository.updateCalendario(calendario);
    }
}
