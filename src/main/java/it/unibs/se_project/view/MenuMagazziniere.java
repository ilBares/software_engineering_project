package it.unibs.se_project.view;

import it.unibs.se_project.controller.MagazziniereController;
import it.unibs.se_project.view.interfaces.ShowableMenu;
import it.unibs.se_project.view.utilities.MyMenu;
import it.unibs.se_project.view.utilities.MyMenuItem;

public class MenuMagazziniere implements ShowableMenu {
    private MagazziniereController controller;
    private MyMenu menu;

    public MenuMagazziniere(MagazziniereController controller) {
        this.controller = controller;
    }

    @Override
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
