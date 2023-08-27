package it.unibs.se_project;

import it.unibs.se_project.controller.AddettoPrenotazioniController;
import it.unibs.se_project.repository.JsonCalendarioRepository;
import it.unibs.se_project.repository.JsonConfigRepository;
import it.unibs.se_project.repository.JsonMenuTematiciRepository;
import it.unibs.se_project.repository.JsonPiattiRepository;
import it.unibs.se_project.view.MenuAddettoPrenotazioni;

public class AddettoPrenotazioni {
    public static void main(String[] args) {
        // create [interface] ConfigStore = JsonConfigStore() [implements ConfigStore]
        // create ConfigService(ConfigStore)

        // create Controller with ConfigService

        // DEVO PASSARE I SERVICES, NON LE REPOSITORIES
        AddettoPrenotazioniController controller = new AddettoPrenotazioniController(
            new JsonCalendarioRepository(),
            new JsonConfigRepository(),
            new JsonMenuTematiciRepository(),
            new JsonPiattiRepository()
        );

        controller.toString();

        MenuAddettoPrenotazioni menu = new MenuAddettoPrenotazioni(controller);
        menu.showMenu();
    }
}
