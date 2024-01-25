package it.unibs.se_project.controller;

import java.time.LocalDate;
import java.util.List;

import it.unibs.se_project.business.MenuCarta;
import it.unibs.se_project.business.MenuTematico;
import it.unibs.se_project.business.Period;
import it.unibs.se_project.business.Piatto;
import it.unibs.se_project.business.Prenotazione;
import it.unibs.se_project.business.dictionary.MenuTematiciDictionary;
import it.unibs.se_project.repository.interfaces.PiattiRepository;
import it.unibs.se_project.service.BevandeService;
import it.unibs.se_project.service.CalendarioService;
import it.unibs.se_project.service.ConfigService;
import it.unibs.se_project.service.GeneriExtraService;
import it.unibs.se_project.service.MenuTematiciService;

public class AddettoPrenotazioniController {
    // SERVICES
    private CalendarioService sCalendario;
    private ConfigService sConfig;
    private MenuTematiciService sMenuTematici;
    private BevandeService sBevande;
    private GeneriExtraService sGeneriExtra;
    private PiattiRepository<Piatto> rPiatti;
    
    
    public AddettoPrenotazioniController(
        CalendarioService sCalendario,
        ConfigService sConfig,
        MenuTematiciService sMenuTematici,
        BevandeService sBevande,
        GeneriExtraService sGeneriExtra,
        PiattiRepository<Piatto> rPiatti
    ) {
        this.sCalendario = sCalendario;
        this.sConfig = sConfig;
        this.sMenuTematici = sMenuTematici;
        this.sBevande = sBevande;
        this.sGeneriExtra = sGeneriExtra;
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
        return sMenuTematici.getMenuTematici();
    }

    public MenuTematiciDictionary getMenuTematiciDictionary() {
        return sMenuTematici.getMenuTematiciDictionary();
    }

    public List<Prenotazione> getPrenotazioni() {
        return sCalendario.getPrenotazioni();
    }

    public List<Prenotazione> getPrenotazioni(LocalDate date) {
        return sCalendario.getPrenotazioni(date);
    }

    public int getAnticipoGiorniPrenotazione() {
        return sConfig.getAnticipoGiorniPrenotazione();
    }

    public void storePrenotazione(Prenotazione prenotazione, MenuCarta menuCarta) {
        sCalendario.storePrenotazione(
            prenotazione,
            menuCarta,
            sBevande.getBevande(),
            sGeneriExtra.getGeneriExtra()
        );
    }

    public int getNumeroPosti() {
        return sConfig.getNumeroPosti();
    }

    public int getNumeroPrenotazioni(LocalDate date) {
        return sCalendario.getNumeroPrenotazioni(date);
    }

    public double getCaricoLavoroResiduo(LocalDate date) {
        return sConfig.getCaricoLavoroSostenibile() - sCalendario.getCaricoLavoroGiornaliero(date);
    }

    public boolean validateNumeroCoperti(LocalDate date, int numeroCoperti) {
        return numeroCoperti + getNumeroPrenotazioni(date) <= getNumeroPosti();
    }
}
