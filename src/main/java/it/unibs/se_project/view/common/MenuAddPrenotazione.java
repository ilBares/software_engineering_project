package it.unibs.se_project.view.common;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

import it.unibs.se_project.business.MenuCarta;
import it.unibs.se_project.business.MenuTematico;
import it.unibs.se_project.business.Ordine;
import it.unibs.se_project.business.Prenotazione;
import it.unibs.se_project.view.interfaces.ShowableMenu;
import it.unibs.se_project.view.utilities.DataInput;
import it.unibs.se_project.view.utilities.MyMenu;
import it.unibs.se_project.view.utilities.MyMenuItem;

public class MenuAddPrenotazione implements ShowableMenu {
    private MyMenu menu;
    private Consumer<Prenotazione> onConfirm;

    private Prenotazione prenotazione;
    private MenuCarta menuCarta;
    private List<MenuTematico> menuTematici;

    public MenuAddPrenotazione(
        String clientName,
        int numeroCoperti,
        MenuCarta menuCarta,
        List<MenuTematico> menuTematici,
        Consumer<Prenotazione> onConfirm
    ) {
        
        this.prenotazione = Prenotazione.emptyPrenotazione(clientName, numeroCoperti);
        this.menuCarta = menuCarta;
        this.menuTematici = menuTematici;
        this.onConfirm = onConfirm;
    }

    @Override
    public void showMenu() {
        this.initialize();
        menu.run();
    }

    private void initialize() {
        MyMenuItem[] items = {
            new MyMenuItem(
                "Aggiungi un Piatto",
                this::addPiatto
            ),
            new MyMenuItem(
                "Aggiungi un Menu Tematico",
                this::addMenuTematico
            ),
            new MyMenuItem(
                "Riepilogo prenotazione",
                this::displaySummaryPrenotazione
            ),
            new MyMenuItem(
                "Conferma prenotazione",
                this::confirmOrdini
            ),
        };

        menu = new MyMenu("GESTIONE PRENOTAZIONE", items);
    }

    private void addPiatto() {
        String message = "Nome del piatto: ";
        String nomePiatto = DataInput.readNotEmptyString(message);

        message = "Numero di persone che prendono questo piatto: ";
        int numeroPersone = DataInput.readPositiveInt(message);

        if (menuCarta.contains(nomePiatto)) {
            Ordine ordine = new Ordine(nomePiatto, numeroPersone);
            prenotazione.addOrdine(ordine);
        } else {
            System.out.println("Piatto non contenuto nel Menu alla Carta del giorno.");
        }
    }

    private void addMenuTematico() {
        String input = DataInput.readNotEmptyString("Nome del menu tematico: ");

        try {
            MenuTematico menuTematico = menuTematici
                .stream()
                .filter((mt) -> mt.getNome().equalsIgnoreCase(input.toLowerCase()))
                .findFirst()
                .get();
            
            menuTematico.getNomiPiatti()
                .stream()
                .forEach((p) -> prenotazione.addOrdine(new Ordine(p, 1)));
        } catch (NoSuchElementException e) {
            System.out.printf("%sNon esiste il menu tematico \"%s\"", NEWLINE, input);
        }
    }

    private void displaySummaryPrenotazione() {
        System.out.printf("%sNome cliente: %s", NEWLINE, prenotazione.getNome());
        System.out.printf("%sNumero coperti: %s", NEWLINE, prenotazione.getNumeroCoperti());
        prenotazione.getOrdini()
            .stream()
            .forEach(p -> {
                System.out.printf("%s%s- Nome piatto: %s (quantità: )",
                    NEWLINE,
                    INDENT,
                    p.getNomePiatto(),
                    p.getNumeroPersone()
                );
            });
    }

    private void confirmOrdini() {
        if (_isNumeroOrdiniValid()) {
            onConfirm.accept(prenotazione);
            
            System.out.println("Gli ordini sono stati aggiunti alla prenotazione.");
            System.out.println("Effettua altre modifiche (da confermare) o esci per tornare al menu principale.");
        } else {
            System.out.println("Il numero di ordini aggiunti alla prenotazione non è sufficiente.");
        }
    }

    private boolean _isNumeroOrdiniValid() {
        int numeroOrdini = prenotazione.getNumeroCoperti();

        return numeroOrdini >= prenotazione.getNumeroCoperti();
    }
}
