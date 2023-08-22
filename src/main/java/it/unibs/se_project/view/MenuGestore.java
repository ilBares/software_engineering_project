package it.unibs.se_project.view;

import java.util.List;

import it.unibs.se_project.business.Bevanda;
import it.unibs.se_project.controller.RestaurantController;
import it.unibs.se_project.view.utilities.MyMenu;
import it.unibs.se_project.view.utilities.MyMenuItem;

public class MenuGestore {
    private RestaurantController controller;
    private MyMenu menu;

    public MenuGestore(RestaurantController controller) {
        this.controller = controller;
    }

    public void showMenu() {
        this.initialize();
        menu.run();
    }

    private void initialize() {
        MyMenuItem[] items = {
            new MyMenuItem(
                "Carico lavoro per persona",
                this::optionCaricoLavoroPersona
            ),
            new MyMenuItem(
                "Numero di posti a sedere disponibili nel ristorante",
                this::optionNumeroPosti
            ),
            new MyMenuItem(
                "Insieme delle bevande",
                this::optionBevande
            ),
            new MyMenuItem(
                "Insieme dei generi (alimentari) extra",
                this::optionGeneriExtra
            ),
            new MyMenuItem(
                "Consumo pro-capite di bevande",
                this::optionBevandeProCapite
            ),
            new MyMenuItem(
                "Consumo pro-capite di generi (alimentari) extra",
                this::optionGeneriExtraProCapite
            ),
            // inserendo il nome del piatto, ne viene mostrata la ricetta
            new MyMenuItem(
                "Corrispondenza piatto-ricetta",
                this::optionPiattoRicetta
            ),
            new MyMenuItem(
                "Elenco di piatti (con relativi periodi di validità)",
                this::optionPiattoPeriodoValidita
            ),
            new MyMenuItem(
                "Elenco di menu tematici",
                this::optionMenuTematici
            ),
        };

        menu = new MyMenu("RISORANTE [utente: Gestore]", items);
    }

    private void optionCaricoLavoroPersona() {
        System.out.printf(
            "Il carico di lavoro per persona è: %d",
            controller.getCaricoLavoroPersona()
        );
    }

    private void optionNumeroPosti() {
        System.out.printf(
            "Il numero di posti a sedere disponibili nel ristorante è: %d",
            controller.getNumeroPosti()
        );
    }

    private void optionBevande() {
        List<Bevanda> bevande = controller.bevande();

        System.out.print("Insieme delle bevande:");
        bevande.stream().forEach((b) -> System.out.printf("\n• %s", b.getNome()));
    }

    private void optionGeneriExtra() {

    }

    private void optionBevandeProCapite() {

    }

    private void optionGeneriExtraProCapite() {

    }

    private void optionPiattoRicetta() {

    }

    private void optionPiattoPeriodoValidita() {

    }

    private void optionMenuTematici() {

    }
}
