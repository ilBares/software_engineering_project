package it.unibs.se_project.view.common;

import java.util.function.BiConsumer;

import it.unibs.se_project.business.MenuCarta;
import it.unibs.se_project.business.MenuTematico;
import it.unibs.se_project.business.Ordine;
import it.unibs.se_project.business.Period;
import it.unibs.se_project.business.Piatto;
import it.unibs.se_project.business.Prenotazione;
import it.unibs.se_project.business.dictionary.MenuTematiciDictionary;
import it.unibs.se_project.view.interfaces.ShowableMenu;
import it.unibs.se_project.view.utilities.DataInput;
import it.unibs.se_project.view.utilities.MyMenu;
import it.unibs.se_project.view.utilities.MyMenuItem;

public class MenuAddPrenotazione implements ShowableMenu {
    private MyMenu menu;
    private BiConsumer<Prenotazione, MenuCarta> onConfirm;

    private Prenotazione prenotazione;
    private final MenuCarta menuCarta;
    private final double caricoLavoroResiduo;
    private MenuTematiciDictionary menuTematiciDictionary;

    public MenuAddPrenotazione(
        String clientName,
        int numeroCoperti,
        double caricoLavoroResiduo,
        MenuCarta menuCarta,
        MenuTematiciDictionary menuTematiciDictionary,
        BiConsumer<Prenotazione, MenuCarta> onConfirm
    ) {
        
        this.prenotazione = Prenotazione.emptyPrenotazione(clientName, numeroCoperti);
        this.caricoLavoroResiduo = caricoLavoroResiduo;
        this.menuCarta = menuCarta;
        this.menuTematiciDictionary = menuTematiciDictionary;
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
        menu.changeExitText("Annulla prenotazione");
    }

    private void addPiatto() {
        String message = "Nome del piatto: ";
        String nomePiatto = DataInput.readNotEmptyString(message);

        if (menuCarta.contains(nomePiatto)) {
            message = "Numero di porzioni: ";
            int numeroPersone = DataInput.readPositiveInt(message);

            Ordine ordine = new Ordine(nomePiatto, numeroPersone);
            prenotazione.addOrdine(ordine);
        } else {
            System.out.println("Piatto non contenuto nel Menu alla Carta del giorno.");
        }
    }

    private void addMenuTematico() {
        String input = DataInput.readNotEmptyString("Nome del menu tematico: ");

        MenuTematico menuTematico = menuTematiciDictionary.getMenuTematico(input);

        if (_validateMenuTematico(menuTematico)) {
            menuTematico.getNomiPiatti()
                .stream()
                .forEach((p) -> prenotazione.addOrdine(new Ordine(p, 1)));
        } else {
            System.out.printf(
                "Il menu tematico \"%s\" non è disponibile in data %s.",
                input,
                menuCarta.getDate()
            );
        }
    }

    private void displaySummaryPrenotazione() {
        System.out.printf("%sNome cliente: %s", NEWLINE, prenotazione.getCliente());
        System.out.printf("%sNumero coperti: %s", NEWLINE, prenotazione.getNumeroCoperti());
        prenotazione.getOrdini()
            .stream()
            .forEach(p -> {
                System.out.printf("%s%s- Nome piatto: %s (%s porzioni)",
                    NEWLINE,
                    INDENT,
                    p.getNomePiatto(),
                    p.getNumeroPersone()
                );
            });
    }

    private void confirmOrdini() {
        if (_validateOrdini()) {
            _setCaricoLavoroRichiesto();
            if (_validateCaricoLavoroRichiesto()) {
                onConfirm.accept(prenotazione, menuCarta);
                System.out.println("Gli ordini sono stati aggiunti alla prenotazione.");
            } else {
                System.out.println("Prenotazione annullata. Carico lavoro richiesto troppo elevato.");
            }
            System.out.println("Sarai reinderizzato al menu principale.");
            
            menu.end();
        } else {
            System.out.println("Il numero di ordini aggiunti alla prenotazione non è sufficiente.");
        }
    }

    private boolean _validateMenuTematico(MenuTematico menuTematico) {
        return menuTematico != null
            && Period.dateIncludedInPeriod(menuCarta.getDate(), menuTematico.getPeriodoValidita());
    }

    private boolean _validateOrdini() {
        return _calculateNumeroOrdini() >= prenotazione.getNumeroCoperti();
    }

    private boolean _validateCaricoLavoroRichiesto() {
        return prenotazione.getCaricoLavoroRichiesto() <= caricoLavoroResiduo;
    }

    private void _setCaricoLavoroRichiesto() {
        double caricoLavoroRichiesto = prenotazione.getOrdini()
            .stream()
            .mapToDouble(o -> {
                Piatto p = menuCarta.getPiatto(o.getNomePiatto());
                return p.getCaricoLavoro() * o.getNumeroPersone();
            })
            .sum();
        prenotazione.setCaricoLavoroRichiesto(caricoLavoroRichiesto);
    }

    private int _calculateNumeroOrdini() {
        return prenotazione.getOrdini()
            .stream()
            .mapToInt(Ordine::getNumeroPersone)
            .sum();
    }
}
