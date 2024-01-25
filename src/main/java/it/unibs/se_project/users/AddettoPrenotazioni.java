package it.unibs.se_project.users;

import it.unibs.se_project.business.Calendario;
import it.unibs.se_project.business.Config;
import it.unibs.se_project.business.dictionary.BevandeDictionary;
import it.unibs.se_project.business.dictionary.GeneriExtraDictionary;
import it.unibs.se_project.business.dictionary.MenuTematiciDictionary;
import it.unibs.se_project.controller.AddettoPrenotazioniController;
import it.unibs.se_project.repository.JsonBevandeRepository;
import it.unibs.se_project.repository.JsonCalendarioRepository;
import it.unibs.se_project.repository.JsonConfigRepository;
import it.unibs.se_project.repository.JsonGeneriExtraRepository;
import it.unibs.se_project.repository.JsonMenuTematiciRepository;
import it.unibs.se_project.repository.JsonPiattiRepository;
import it.unibs.se_project.repository.interfaces.BevandeRepository;
import it.unibs.se_project.repository.interfaces.CalendarioRepository;
import it.unibs.se_project.repository.interfaces.ConfigRepository;
import it.unibs.se_project.repository.interfaces.GeneriExtraRepository;
import it.unibs.se_project.repository.interfaces.MenuTematiciRepository;
import it.unibs.se_project.service.BevandeService;
import it.unibs.se_project.service.CalendarioService;
import it.unibs.se_project.service.ConfigService;
import it.unibs.se_project.service.GeneriExtraService;
import it.unibs.se_project.service.MenuTematiciService;
import it.unibs.se_project.view.MenuAddettoPrenotazioni;

public class AddettoPrenotazioni {
    public static void main(String[] args) {
        CalendarioRepository<Calendario> calendarioRepository = new JsonCalendarioRepository();
        ConfigRepository<Config> configRepository = new JsonConfigRepository();
        MenuTematiciRepository<MenuTematiciDictionary> menuTematiciRepository = new JsonMenuTematiciRepository();
        BevandeRepository<BevandeDictionary> bevandeRepository = new JsonBevandeRepository();
        GeneriExtraRepository<GeneriExtraDictionary> generiExtraRepository = new JsonGeneriExtraRepository();

        AddettoPrenotazioniController controller = new AddettoPrenotazioniController(
            new CalendarioService(calendarioRepository),
            new ConfigService(configRepository),
            new MenuTematiciService(menuTematiciRepository),
            new BevandeService(bevandeRepository),
            new GeneriExtraService(generiExtraRepository),
            new JsonPiattiRepository()
        );

        MenuAddettoPrenotazioni menu = new MenuAddettoPrenotazioni(controller);
        menu.showMenu();
    }
}
