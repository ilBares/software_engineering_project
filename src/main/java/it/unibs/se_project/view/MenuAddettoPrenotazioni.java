package it.unibs.se_project.view;

import java.time.LocalDate;
import java.util.List;

import it.unibs.se_project.business.MenuCarta;
import it.unibs.se_project.business.Prenotazione;
import it.unibs.se_project.controller.AddettoPrenotazioniController;
import it.unibs.se_project.view.common.MenuAddPrenotazione;
import it.unibs.se_project.view.interfaces.ShowableMenu;
import it.unibs.se_project.view.utilities.DataInput;
import it.unibs.se_project.view.utilities.MyMenu;
import it.unibs.se_project.view.utilities.MyMenuItem;

public class MenuAddettoPrenotazioni implements ShowableMenu {
    // BUSINESS
    private AddettoPrenotazioniController controller;
    private MyMenu menu;

    public MenuAddettoPrenotazioni(AddettoPrenotazioniController controller) {
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
                "Visualizza il Menu alla Carta di oggi",
                this::displayDailyMenuCarta
            ),
            new MyMenuItem(
                "Visualizza il Menu alla Carta in base alla data",
                this::displayMenuCarta
            ),
            new MyMenuItem(
                "Aggiungi una prenotazione",
                this::addPrenotazione
            ),
            new MyMenuItem(
                "Mostra le prenotazioni di oggi",
                this::showDailyPrenotazioni
            ),
            new MyMenuItem(
                "Mostra l'elenco delle prenotazioni",
                this::showPrenotazioni
            )
        };

        menu = new MyMenu("RISORANTE [utente: Addetto alle Prenotazioni]", items);
    }

    private void displayDailyMenuCarta() {
        System.out.println("Menu alla carta di oggi:");
        controller.getMenuCarta().getPiattiNameList()
            .stream()
            .forEach(this::_displayListName);
    }

    private void displayMenuCarta() {
        String message = "Inserisci la data della quale vuoi vedere il Menu alla Carta: ";
        LocalDate isoDate = DataInput.readISODate(message, controller.getAnticipoGiorniPrenotazione());

        System.out.println("Menu alla carta:");
        controller.getMenuCarta(isoDate).getPiattiNameList()
            .stream()
            .forEach(this::_displayListName);
    }

    private void addPrenotazione() {
        String message = "Data in cui vuoi aggiungere la prenotazione: ";
        LocalDate isoDate = DataInput.readISODate(message, controller.getAnticipoGiorniPrenotazione());
        MenuCarta menuCarta = controller.getMenuCarta(isoDate);

        message = "Nome del cliente a cui associare la prenotazione: ";
        String name = DataInput.readNotEmptyString(message);

        message = "Numero di coperti per la prenotazione: ";
        int numeroCoperti = DataInput.readPositiveInt(message);

        if (controller.validateNumeroCoperti(isoDate, numeroCoperti)) {
            MenuAddPrenotazione optionMenu = new MenuAddPrenotazione(
                name,
                numeroCoperti,
                menuCarta,
                controller.getMenuTematici(),
                this::storePrenotazione
            );
            optionMenu.showMenu();
        }
    }

    private void storePrenotazione(Prenotazione prenotazione) {
        controller.storePrenotazione(prenotazione);
    }

    private void showDailyPrenotazioni() {
        _displayPrenotazioni(controller.getPrenotazioni(LocalDate.now()));
    }

    private void showPrenotazioni() {
        _displayPrenotazioni(controller.getPrenotazioni());
    }

    private void _displayPrenotazioni(List<Prenotazione> prenotazioni) {
        if (!prenotazioni.isEmpty()) {
            prenotazioni
                .stream()
                .forEach(p -> {
                    System.out.printf("%s• %s (%d coperti)", NEWLINE, p.getNome(), p.getNumeroCoperti());
                    
                    p.getOrdini()
                        .stream()
                        .forEach((o) -> System.out.printf("%s%s- %d (%s persone)",
                            NEWLINE,
                            INDENT,
                            o.getNumeroPersone(),
                            o.getNomePiatto()
                        ));
                });
        }
    }

    private void _displayListName(String name) {
        System.out.printf("%s• %s", NEWLINE, name);
    }
}
