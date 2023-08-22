package it.unibs.se_project.controller;

import java.util.List;

import it.unibs.se_project.business.Bevanda;
import it.unibs.se_project.business.Calendario;
import it.unibs.se_project.business.Config;
import it.unibs.se_project.business.GenereExtra;
import it.unibs.se_project.business.MenuTematico;
import it.unibs.se_project.business.Piatto;
import it.unibs.se_project.business.RegistroMagazzino;
import it.unibs.se_project.repository.interfaces.BevandeRepository;
import it.unibs.se_project.repository.interfaces.CalendarioRepository;
import it.unibs.se_project.repository.interfaces.ConfigRepository;
import it.unibs.se_project.repository.interfaces.GeneriExtraRepository;
import it.unibs.se_project.repository.interfaces.MenuTematiciRepository;
import it.unibs.se_project.repository.interfaces.PiattiRepository;
import it.unibs.se_project.repository.interfaces.RegistroMagazzinoRepository;

public class RestaurantController {
    /// REPOSITORIES
    private BevandeRepository<Bevanda> bevande;
    private CalendarioRepository<Calendario> calendario;
    private ConfigRepository<Config> config;
    private GeneriExtraRepository<GenereExtra> generiExtra;
    private MenuTematiciRepository<MenuTematico> menuTematici;
    private PiattiRepository<Piatto> piatti;
    private RegistroMagazzinoRepository<RegistroMagazzino> registroMagazzino;

    // TODO
    // separate into 3 different controllers:
    // GestoreController
    // AddettoPrenotazioniController
    // MagazziniereController
    public RestaurantController(
        BevandeRepository<Bevanda> bevandeRepository,
        CalendarioRepository<Calendario> calendarioRepository,
        ConfigRepository<Config> configRepository,
        GeneriExtraRepository<GenereExtra> generiExtraRepository,
        MenuTematiciRepository<MenuTematico> menuTematiciRepository,
        PiattiRepository<Piatto> piattiRepository,
        RegistroMagazzinoRepository<RegistroMagazzino> registroMagazzinoRepository
    ) {
        bevande = bevandeRepository;
        calendario = calendarioRepository;
        config = configRepository;
        generiExtra = generiExtraRepository;
        menuTematici = menuTematiciRepository;
        piatti = piattiRepository;
        registroMagazzino = registroMagazzinoRepository;
    }

    public int getCaricoLavoroPersona() {
        return config.getConfig().getCaricoLavoroPersona();
    }

    public int getNumeroPosti() {
        return config.getConfig().getNumeroPosti();
    }

    public List<Bevanda> bevande() {
        return bevande.getBevande();
    }

    public List<GenereExtra> generiExtra() {
        return generiExtra.getGeneriExtra();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Bevande: " + bevande.toString());
        sb.append("Calendario: " + calendario.toString());
        sb.append("Config: " + config.toString());
        sb.append("GeneriExtra: " + generiExtra.toString());
        sb.append("MenuTematici: " + menuTematici.toString());
        sb.append("Piatti: " + piatti.toString());
        sb.append("RegistroMagazzino: " + registroMagazzino.toString());

        return sb.toString();
    }
}
