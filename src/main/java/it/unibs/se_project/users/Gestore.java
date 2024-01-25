package it.unibs.se_project.users;

import it.unibs.se_project.business.Config;
import it.unibs.se_project.business.dictionary.BevandeDictionary;
import it.unibs.se_project.business.dictionary.GeneriExtraDictionary;
import it.unibs.se_project.business.dictionary.MenuTematiciDictionary;
import it.unibs.se_project.controller.GestoreController;
import it.unibs.se_project.repository.JsonBevandeRepository;
import it.unibs.se_project.repository.JsonConfigRepository;
import it.unibs.se_project.repository.JsonGeneriExtraRepository;
import it.unibs.se_project.repository.JsonMenuTematiciRepository;
import it.unibs.se_project.repository.JsonPiattiRepository;
import it.unibs.se_project.repository.interfaces.BevandeRepository;
import it.unibs.se_project.repository.interfaces.ConfigRepository;
import it.unibs.se_project.repository.interfaces.GeneriExtraRepository;
import it.unibs.se_project.repository.interfaces.MenuTematiciRepository;
import it.unibs.se_project.service.BevandeService;
import it.unibs.se_project.service.ConfigService;
import it.unibs.se_project.service.GeneriExtraService;
import it.unibs.se_project.service.MenuTematiciService;
import it.unibs.se_project.view.MenuGestore;

public class Gestore {
    public static void main(String[] args) {
        BevandeRepository<BevandeDictionary> bevandeRepository = new JsonBevandeRepository();
        ConfigRepository<Config> configRepository = new JsonConfigRepository();
        GeneriExtraRepository<GeneriExtraDictionary> generiExtraRepository = new JsonGeneriExtraRepository();
        MenuTematiciRepository<MenuTematiciDictionary> menuTematiciRepository = new JsonMenuTematiciRepository();

        GestoreController controller = new GestoreController(
            new BevandeService(bevandeRepository),
            new ConfigService(configRepository),
            new GeneriExtraService(generiExtraRepository),
            new MenuTematiciService(menuTematiciRepository),
            new JsonPiattiRepository()
        );

        MenuGestore menu = new MenuGestore(controller);
        menu.showMenu();
    }
}
