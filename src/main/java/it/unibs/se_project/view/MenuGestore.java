package it.unibs.se_project.view;

import java.util.List;

import it.unibs.se_project.business.Bevanda;
import it.unibs.se_project.business.GenereExtra;
import it.unibs.se_project.business.MenuTematico;
import it.unibs.se_project.business.Piatto;
import it.unibs.se_project.business.Ricetta;
import it.unibs.se_project.business.enums.UnitaDiMisura;
import it.unibs.se_project.controller.GestoreController;
import it.unibs.se_project.view.interfaces.ShowableMenu;
import it.unibs.se_project.view.utilities.MyMenu;
import it.unibs.se_project.view.utilities.MyMenuItem;

public class MenuGestore implements ShowableMenu {
    // BUSINESS
    private GestoreController controller;
    private MyMenu menu;

    public MenuGestore(GestoreController controller) {
        this.controller = controller;
    }

    @Override
    public void showMenu() {
        this.initialize();
        menu.run();
    }

    private void initialize() {
        MyMenuItem[] items = {
            new MyMenuItem(
                "Carico lavoro per persona",
                this::displayCaricoLavoroPersona
            ),
            new MyMenuItem(
                "Numero di posti a sedere disponibili nel ristorante",
                this::displayNumeroPosti
            ),
            new MyMenuItem(
                "Insieme delle bevande",
                this::displayBevande
            ),
            new MyMenuItem(
                "Insieme dei generi (alimentari) extra",
                this::displayGeneriExtra
            ),
            new MyMenuItem(
                "Consumo pro-capite di bevande",
                this::displayBevandeProCapite
            ),
            new MyMenuItem(
                "Consumo pro-capite di generi (alimentari) extra",
                this::displayGeneriExtraProCapite
            ),
            new MyMenuItem(
                "Corrispondenza piatto-ricetta",
                this::displayPiattoRicetta
            ),
            new MyMenuItem(
                "Elenco di piatti (con relativi periodi di validità)",
                this::displayPiattoPeriodoValidita
            ),
            new MyMenuItem(
                "Elenco di menu tematici",
                this::displayMenuTematici
            ),
        };

        menu = new MyMenu("RISTORANTE [utente: Gestore]", items);
    }

    private void displayCaricoLavoroPersona() {
        System.out.printf(
            "Il carico di lavoro per persona è: %d",
            controller.getCaricoLavoroPersona()
        );
    }

    private void displayNumeroPosti() {
        System.out.printf(
            "Il numero di posti a sedere disponibili nel ristorante è: %d",
            controller.getNumeroPosti()
        );
    }

    private void displayBevande() {
        List<Bevanda> bevande = controller.getBevande();

        System.out.print("Insieme delle bevande:");
        bevande
            .stream()
            .forEach(b -> _displayListName(b.getNome()));
    }

    private void displayGeneriExtra() {
        List<GenereExtra> generiExtra = controller.getGeneriExtra();

        System.out.print("Insieme dei generi extra:");
        generiExtra
            .stream()
            .forEach(ge -> _displayListName(ge.getNome()));
    }

    private void displayBevandeProCapite() {
        List<Bevanda> bevande = controller.getBevande();

        System.out.print("Consumo pro capite di bevande:");
        bevande
            .stream()
            .forEach(b -> _displayListNameQuantityUnit(b.getNome(), b.getQuantita(), b.getUnitaDiMisura()));
    }

    private void displayGeneriExtraProCapite() {
        List<GenereExtra> generiExtra = controller.getGeneriExtra();

        System.out.print("Consumo pro capite di generi extra:");
        generiExtra
            .stream()
            .forEach(ge -> _displayListNameQuantityUnit(ge.getNome(), ge.getQuantita(), ge.getUnitaDiMisura()));
    }

    private void displayPiattoRicetta() {
        List<Piatto> piatti = controller.getPiatti();

        System.out.print("Corrispondenze piatto - ricetta:");
        piatti
            .stream()
            .forEach(p -> _displayPiatto(p));
    }

    private void displayPiattoPeriodoValidita() {
        List<Piatto> piatti = controller.getPiatti();

        piatti
            .stream()
            .forEach(p -> {
                System.out.printf("%s• Piatto: %s, periodo validità: %s", NEWLINE, p.getNome(), p.getPeriodoValidita());
            });
    }

    private void displayMenuTematici() {
        List<MenuTematico> menuTematici = controller.getMenuTematici();

        System.out.printf("Insieme dei menu tematici:");
        menuTematici
            .stream()
            .forEach(mt -> {
                System.out.printf("%s• Menu tematico: %s, periodo validità: %s", NEWLINE, mt.getNome(), mt.getPeriodoValidita());

                mt.getNomiPiatti()
                    .stream()
                    .forEach(np -> System.out.printf("%s%s- %s", NEWLINE, INDENT, np));
            });
    }

    private void _displayListName(String name) {
        System.out.printf("%s• %s", NEWLINE, name);
    }

    private void _displayListNameQuantityUnit(String name, double quantity, UnitaDiMisura unit) {
        System.out.printf("%s• %s: %.2f [%s]", NEWLINE, name, quantity, unit);
    }

    private void _displayPiatto(Piatto piatto) {
        System.out.printf("%s• Piatto: %s", NEWLINE, piatto.getNome());
        _displayRicetta(piatto.getRicetta());
        System.out.println();
    }

    private void _displayRicetta(Ricetta ricetta) {
        System.out.printf("%s  Ricetta", NEWLINE);

        System.out.printf("%s%sporzioni: %d", NEWLINE, INDENT, ricetta.getPorzioni());        
        System.out.printf("%s%scarico lavoro per porzione: %.2f", NEWLINE, INDENT, ricetta.getCaricoLavoroPorzione());

        System.out.printf("%s%singredienti:", NEWLINE, INDENT);
        ricetta.getIngredienti()
            .stream()
            .forEach(i -> {
                System.out.printf("%s%s- %s (%.2f %s)", NEWLINE, INDENT, i.getNome(), i.getQuantita(), i.getUnitaDiMisura());
            });
    }
}
