# software engineering project

## TEMA
Sistema software di supporto alla raccolta di prenotazioni e alla generazione dell'elenco giornaliero di prodotti da
acquistare da parte di un ristorante (lavora solo su prenotazione - prenotazione effettuata almeno 1 giorno feriale di
anticipo - solo giorni feriali - 1 pasto al giorno).

Sono gestite 3 tipologie di utenti:
1. __gestore__:
   - inizializza e visualizza i dati di configurazione;
   - crea e visualizza ricettario e i menu

2. __addetto alle prenotazioni__
   - raccoglie (e aggiunge) le prenotazioni

3. __magazziniere__
    - usa la lista della spesa per fare acquisti
    - aggiorna il registro delle merci in giacenza in magazzino

## DOMINIO APPLICATIVO
__Ricetta__ ==> stabilita dal _gestore_
__Piatto__ ==> stabilita dal _gestore_
__MenuTematico__ ==> stabilita dal _gestore_
__MenuCarta__ ==> generato ogni giorno dall'elenco di piatti validi
__Prenotazione__ ==> aggiunta dall'_addetto alle prenotazioni_
__Bevanda__ ==> stabilito dal _gestore_



