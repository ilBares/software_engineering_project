package it.unibs.se_project;

import it.unibs.se_project.controller.RestaurantController;
import it.unibs.se_project.repository.JsonBevandeRepository;
import it.unibs.se_project.repository.JsonCalendarioRepository;
import it.unibs.se_project.repository.JsonConfigRepository;
import it.unibs.se_project.repository.JsonGeneriExtraRepository;
import it.unibs.se_project.repository.JsonMenuTematiciRepository;
import it.unibs.se_project.repository.JsonPiattiRepository;
import it.unibs.se_project.repository.JsonRegistroMagazzinoRepository;
import it.unibs.se_project.view.MenuAddettoPrenotazioni;

public class AddettoPrenotazioni {
    public static void main(String[] args) {
        // create [interface] ConfigStore = JsonConfigStore() [implements ConfigStore]
        // create ConfigService(ConfigStore)

        // create Controller with ConfigService

        // DEVO PASSARE I SERVICES, NON LE REPOSITORIES
        RestaurantController controller = new RestaurantController(
            new JsonBevandeRepository(),
            new JsonCalendarioRepository(),
            new JsonConfigRepository(),
            new JsonGeneriExtraRepository(),
            new JsonMenuTematiciRepository(),
            new JsonPiattiRepository(),
            new JsonRegistroMagazzinoRepository()
        );

        controller.toString();

        MenuAddettoPrenotazioni menu = new MenuAddettoPrenotazioni(controller);
        menu.showMenu();
    }
}
