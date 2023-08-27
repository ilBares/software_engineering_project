package it.unibs.se_project;

import it.unibs.se_project.controller.MagazziniereController;
import it.unibs.se_project.view.MenuMagazziniere;

public class Magazziniere {
    public static void main(String[] args) {
        // create [interface] ConfigStore = JsonConfigStore() [implements ConfigStore]
        // create ConfigService(ConfigStore)

        // create Controller with ConfigService

        // DEVO PASSARE I SERVICES, NON LE REPOSITORIES
        MagazziniereController controller = new MagazziniereController(
        );

        controller.toString();

        MenuMagazziniere menu = new MenuMagazziniere(controller);
        menu.showMenu();
    }
}
