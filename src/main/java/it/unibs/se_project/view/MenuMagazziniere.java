package it.unibs.se_project.view;

import it.unibs.se_project.business.Item;
import it.unibs.se_project.controller.MagazziniereController;
import it.unibs.se_project.view.interfaces.ShowableMenu;
import it.unibs.se_project.view.utilities.DataInput;
import it.unibs.se_project.view.utilities.MyMenu;
import it.unibs.se_project.view.utilities.MyMenuItem;

public class MenuMagazziniere implements ShowableMenu {
    // BUSINESS
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
            new MyMenuItem(
                "Visualizza la lista della spesa di oggi",
                this::displayDailyListaSpesa
            ),
            new MyMenuItem(
                "Aggiungi i prodotti della lista della spesa nel magazzino",
                this::addDailyListaSpesaToMagazzino
            ),
            new MyMenuItem(
                "Aggiungi ingredienti non consumati nel magazzino",
                this::addIngredienteToMagazzino
            ),
            new MyMenuItem(
                "Porta ingredienti in cucina",
                this::useIngrediente
            ),
            new MyMenuItem(
                "Porta generi extra o bevande in sala da pranzo",
                this::useItem
            ),
            new MyMenuItem(
                "Scarta ingredienti",
                this::removeIngrediente
            ),

            new MyMenuItem(
                "Scarta generi extra o bevande",
                this::removeItem
            ),
        };

        menu = new MyMenu("RISTORANTE [utente: Magazziniere]", items);
    }

    // TODO
    // Emit an event to be handled from controller
    // Menu should be initialized inside controller
    // Menu handled "displayDailyListaSpesa" event with View.displayListaSpesa(dailyListaSpesa)
    // Controller "implements ActionListener"
    private void displayDailyListaSpesa() {
        controller.getDailyListaSpesa()
            .stream()
            .forEach(i -> {
                System.out.printf(
                    "%s• %s: %s [%s]",
                    NEWLINE,
                    i.getNome(),
                    i.getQuantita(),
                    i.getUnitaDiMisura()
                );
            });
    }

    private void addDailyListaSpesaToMagazzino() {
        controller.getDailyListaSpesa()
            .stream()
            .forEach(controller::inputItemToMagazzino);
        
        if (!controller.getDailyListaSpesa().isEmpty()) {
            System.out.println("I prodotti presenti nella lista della spesa aggiunti in magazzino");
            controller.emptyDailyListaSpesa();
        } else {
            System.out.println("Non ci sono altri prodotti da acquistare");
        }
    }

    private void addIngredienteToMagazzino() {
        String messaggio = "Inserisci il nome dell'ingrediente non consumato: ";
        String itemName = DataInput.readNotEmptyString(messaggio);

        Item item = controller.getRegistroItemFromName(itemName);

        if (item != null) {
            messaggio = "Inserisci la quantità non consumata: ";
            double quantita = DataInput.readPositiveDouble(messaggio);
            
            Item newItem = new Item(itemName, quantita, item.getUnitaDiMisura());
            controller.inputItemToMagazzino(newItem);

            System.out.printf(
                "%s%s [%s] di %s aggiunti in magazzino",
                NEWLINE,
                quantita,
                item.getUnitaDiMisura(),
                item.getNome()
            );
        } else {
            System.out.println("Ingrediente non presente nella lista della spesa di oggi");
        }
    }

    private void useIngrediente() {
        String messaggio = "Inserisci il nome dell'ingrediente da portare in cucina: ";
        String itemName = DataInput.readNotEmptyString(messaggio);

        Item item = controller.getRegistroItemFromName(itemName);

        if (item != null) {
            _useItem(item);
        } else {
            System.out.println("Ingrediente non presente nella lista della spesa di oggi");
        }
    }

    private void useItem() {
        String messaggio = "Inserisci il nome della bevanda o del genere extra da portare in sala da pranzo: ";
        String itemName = DataInput.readNotEmptyString(messaggio);

        Item item = controller.getRegistroItemFromName(itemName);

        if (item != null) {
            _useItem(item);
        } else {
            System.out.println("Ingrediente non presente nella lista della spesa di oggi");
        }
    }

    private void removeIngrediente() {
        String messaggio = "Inserisci il nome dell'ingrediente da scartare: ";
        String itemName = DataInput.readNotEmptyString(messaggio);

        Item item = controller.getRegistroItemFromName(itemName);

        if (item != null) {
            _useItem(item);
        } else {
            System.out.println("Ingrediente non presente nella lista della spesa di oggi");
        }
    }

    private void removeItem() {
        String messaggio = "Inserisci il nome della bevanda o del genere extra da scartare: ";
        String itemName = DataInput.readNotEmptyString(messaggio);

        Item item = controller.getRegistroItemFromName(itemName);

        if (item != null) {
            _useItem(item);
        } else {
            System.out.println("Ingrediente non presente nella lista della spesa di oggi");
        }
    }

    private void _useItem(Item item) {
        String messaggio = "Inserisci la quantità: ";
        double quantita = DataInput.readPositiveDouble(messaggio);
        
        if (quantita <= item.getQuantita()) {
            Item newItem = new Item(item.getNome(), quantita, item.getUnitaDiMisura());
            controller.outputItemFromMagazzino(newItem);

            System.out.printf(
                "%s%s [%s] di %s rimossi dal magazzino",
                NEWLINE,
                quantita,
                item.getUnitaDiMisura(),
                item.getNome()
            );
        } else {
            System.out.println("Quantità invalida (deve essere inferiore alla quantità presente in magazzino)");
        }
    }
}
