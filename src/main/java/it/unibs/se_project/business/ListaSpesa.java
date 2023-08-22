package it.unibs.se_project.business;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ListaSpesa {
    private List<ItemListaSpesa> listaSpesa;

    @JsonCreator
    public ListaSpesa(
        @JsonProperty("lista_della_spesa") ItemListaSpesa listaSpesa[]
    ) {
        this.listaSpesa = List.of(listaSpesa);
    }

    // TODO "add item"

    public List<ItemListaSpesa> getListaSpesa() {
        return listaSpesa;
    }

    @Override
    public String toString() {
        return "ListaSpesa [listaSpesa=" + listaSpesa + "]";
    }
}
