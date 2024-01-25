package it.unibs.se_project.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WorkingDay {
    private List<Prenotazione> prenotazioni;
    private HashMap<String, ItemListaSpesa> listaSpesaMap;

    @JsonCreator
    public WorkingDay(
        @JsonProperty("prenotazioni") Prenotazione[] prenotazioni,
        @JsonProperty("lista_spesa") HashMap<String, ItemListaSpesa> listaSpesaMap
    ) {
        this.prenotazioni = new ArrayList<Prenotazione>(List.of(prenotazioni));
        this.listaSpesaMap = listaSpesaMap;
    }

    public static WorkingDay emptyWorkingDay() {
        return new WorkingDay(new Prenotazione[0], new HashMap<String, ItemListaSpesa>());
    }

    @JsonProperty("prenotazioni")
    public List<Prenotazione> getPrenotazioni() {
        return prenotazioni;
    }

    @JsonProperty("lista_spesa")
    public Map<String, ItemListaSpesa> getListaSpesa() {
        return Map.copyOf(listaSpesaMap);
    }

    public void addBevande(List<Bevanda> bevande, int numeroCoperti) {
        bevande
            .stream()
            .forEach(b -> _addItemToListaSpesa(b, numeroCoperti));
    }

    public void addGeneriExtra(List<GenereExtra> generiExtra, int numeroCoperti) {
        generiExtra
            .stream()
            .forEach(ge -> _addItemToListaSpesa(ge, numeroCoperti));
    }

    // precondizione: i piatti della prenotazione devono essere contenuti nel menuCarta
    public void addPrenotazione(Prenotazione prenotazione, MenuCarta menuCarta) {
        prenotazioni.add(prenotazione);

        prenotazione.getOrdini()
            .stream()
            .forEach(o -> {
                Ricetta ricetta = menuCarta.getPiatto(o.getNomePiatto()).getRicetta();
                _addRicettaToListaSpesa(ricetta, o.getNumeroPersone());
            });
    }

    private void _addRicettaToListaSpesa(Ricetta ricetta, int porzioni) {
        ricetta.getIngredienti()
            .stream()
            .forEach(i -> {
                _addItemToListaSpesa(i, (double) porzioni / ricetta.getPorzioni());
            });
    }

    private void _addItemToListaSpesa(Item item, double quantita) {
        double updatedQuantity = item.getQuantita() * quantita;

        if (listaSpesaMap.containsKey(item.getNome())) {
            listaSpesaMap.get(item.getNome()).updateQuantita(updatedQuantity);
        }
        
        ItemListaSpesa ils = new ItemListaSpesa(
            item.getNome(),
            updatedQuantity,
            item.getUnitaDiMisura()
        );

        listaSpesaMap.put(ils.getNome(), ils);
    }

    @Override
    public String toString() {
        return "WorkingDay [prenotazioni=" + prenotazioni
            + ", listaSpesa=" + listaSpesaMap + "]";
    }
}
