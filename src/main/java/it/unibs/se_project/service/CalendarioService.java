package it.unibs.se_project.service;

import java.time.LocalDate;
import java.util.List;

import it.unibs.se_project.business.Bevanda;
import it.unibs.se_project.business.Calendario;
import it.unibs.se_project.business.GenereExtra;
import it.unibs.se_project.business.MenuCarta;
import it.unibs.se_project.business.Prenotazione;
import it.unibs.se_project.repository.interfaces.CalendarioRepository;

public class CalendarioService {
    private final CalendarioRepository<Calendario> repository;

    public CalendarioService(CalendarioRepository<Calendario> calendarioRepository) {
        this.repository = calendarioRepository;
    }

    public Calendario getCalendario() {
        Calendario calendario = repository.getCalendario();
        boolean removed = calendario.removeOldPrenotazioni();

        if (removed) {
            repository.updateCalendario(calendario);
        }
        
        return repository.getCalendario();
    }

    public void updateCalendario(Calendario calendario) {
        repository.updateCalendario(calendario);
    }

    public List<Prenotazione> getPrenotazioni() {
        return getCalendario().getPrenotazioni();
    }

    public List<Prenotazione> getPrenotazioni(LocalDate date) {
        return getCalendario().getPrenotazioni(date);
    }

    public int getNumeroPrenotazioni(LocalDate date) {
        List<Prenotazione> prenotazioni = getPrenotazioni(date);

        if (prenotazioni.isEmpty()) {
            return 0;
        }
        
        return prenotazioni
            .stream()
            .mapToInt(Prenotazione::getNumeroCoperti)
            .sum();
    }

    public double getCaricoLavoroGiornaliero(LocalDate date) {
        return getPrenotazioni(date)
            .stream()
            .mapToDouble(Prenotazione::getCaricoLavoroRichiesto)
            .sum();
    }

    public void storePrenotazione(Prenotazione prenotazione, MenuCarta menuCarta, List<Bevanda> bevande, List<GenereExtra> generiExtra) {
        Calendario calendarioUpdated = getCalendario();

        calendarioUpdated.addPrenotazione(prenotazione, menuCarta, bevande, generiExtra);
        updateCalendario(calendarioUpdated);
    }
}
