package it.unibs.se_project.controller;

import java.time.LocalDate;
import java.util.List;

import it.unibs.se_project.business.Calendario;
import it.unibs.se_project.business.Config;
import it.unibs.se_project.business.MenuCarta;
import it.unibs.se_project.business.MenuTematico;
import it.unibs.se_project.business.Period;
import it.unibs.se_project.business.Piatto;
import it.unibs.se_project.business.Prenotazione;
import it.unibs.se_project.repository.interfaces.CalendarioRepository;
import it.unibs.se_project.repository.interfaces.ConfigRepository;
import it.unibs.se_project.repository.interfaces.MenuTematiciRepository;
import it.unibs.se_project.repository.interfaces.PiattiRepository;

public class AddettoPrenotazioniController {
    // TODO
    // ADD PRENOTAZIONE AGGIUNGERA' IN AUTOMATICO GENERI EXTRA E BEVANDE
    // PRIMA DI AGGIUNGERLA SULLA LISTA DELLA SPESA

    // REPOSITORIES
    private CalendarioRepository<Calendario> rCalendario;
    private ConfigRepository<Config> rConfig;
    private MenuTematiciRepository<MenuTematico> rMenuTematici;
    private PiattiRepository<Piatto> rPiatti;
    
    public AddettoPrenotazioniController(
        CalendarioRepository<Calendario> rCalendario,
        ConfigRepository<Config> rConfig,
        MenuTematiciRepository<MenuTematico> rMenuTematici,
        PiattiRepository<Piatto> rPiatti
    ) {
        this.rCalendario = rCalendario;
        this.rConfig = rConfig;
        this.rMenuTematici = rMenuTematici;
        this.rPiatti = rPiatti;
    }

    public MenuCarta getMenuCarta(LocalDate date) {
        List<Piatto> piatti = rPiatti.getPiatti()
            .stream()
            .filter(p -> Period.dateIncludedInPeriod(date, p.getPeriodoValidita()))
            .toList();

        return new MenuCarta(date, piatti);
    }

    public MenuCarta getMenuCarta() {
        return getMenuCarta(LocalDate.now());
    }

    public List<String> getNomiPiatti() {
        return getMenuCarta().getPiattiNameList();
    }

    public List<MenuTematico> getMenuTematici() {
        return rMenuTematici.getMenuTematici();
    }

    public List<Prenotazione> getPrenotazioni() {
        return rCalendario.getCalendario().getPrenotazioni();
    }

    public List<Prenotazione> getPrenotazioni(LocalDate date) {
        return rCalendario.getCalendario().getPrenotazioni(date);
    }

    public int getAnticipoGiorniPrenotazione() {
        return rConfig.getConfig().getAnticipoGiorniPrenotazione();
    }

    public boolean storePrenotazione(Prenotazione prenotazione) {
        // TODO MOVE TO CALENDARIO SERVICE
        Calendario calendarioUpdated = rCalendario.getCalendario();

        calendarioUpdated.addPrenotazione(prenotazione, LocalDate.now(), rPiatti.getPiatti());
        rCalendario.updateCalendario(calendarioUpdated);

        return true;
    }

    public int getNumeroPosti() {
        return rConfig.getConfig().getNumeroPosti();
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

    public boolean validateNumeroCoperti(LocalDate date, int numeroCoperti) {
        return numeroCoperti + getNumeroPrenotazioni(date) <= getNumeroPosti();
    }
}
