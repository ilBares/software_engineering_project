package it.unibs.se_project.view;

import it.unibs.se_project.controller.RestaurantController;
import it.unibs.se_project.view.utilities.MyMenu;
import it.unibs.se_project.view.utilities.MyMenuItem;

public class MenuMagazziniere {
    private RestaurantController controller;
    private MyMenu menu;

    public MenuMagazziniere(RestaurantController controller) {
        this.controller = controller;
    }

    public void showMenu() {
        this.initialize();
        menu.run();
    }

    private void initialize() {
        MyMenuItem[] items = {
        };

        menu = new MyMenu("RISORANTE [utente: Magazziniere]", items);
    }
}
