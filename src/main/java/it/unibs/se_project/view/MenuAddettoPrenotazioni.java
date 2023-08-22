package it.unibs.se_project.view;

import it.unibs.se_project.controller.RestaurantController;
import it.unibs.se_project.view.utilities.MyMenu;
import it.unibs.se_project.view.utilities.MyMenuItem;

public class MenuAddettoPrenotazioni {
    private RestaurantController controller;
    private MyMenu menu;

    public MenuAddettoPrenotazioni(RestaurantController controller) {
        this.controller = controller;
    }

    public void showMenu() {
        this.initialize();
        menu.run();
    }

    private void initialize() {
        MyMenuItem[] items = {
            new MyMenuItem(
                "Aggiungi una prenotazione",
                this::optionAddPrenotazione
            ),
            new MyMenuItem(
                "Mostra le prenotazioni di oggi",
                this::optionShowTodayPrenotazioni
            ),
            new MyMenuItem(
                "Mostra l'elenco delle prenotazioni",
                this::optionShowPrenotazioni
            )
        };

        menu = new MyMenu("RISORANTE [utente: Addetto alle Prenotazioni]", items);
    }

    private void optionAddPrenotazione() {

    }

    private void optionShowTodayPrenotazioni() {
        
    }

    private void optionShowPrenotazioni() {

    }
}
