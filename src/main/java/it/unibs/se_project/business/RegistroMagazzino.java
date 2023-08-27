package it.unibs.se_project.business;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RegistroMagazzino {
    private List<Item> registroMagazzino;

    @JsonCreator
    public RegistroMagazzino(
        @JsonProperty("registro_magazzino") Item[] registroMagazzino
    ) {
        this.registroMagazzino = List.of(registroMagazzino);
    }

    public void input(Item item) {
        registroMagazzino.add(item);
    }
    
    public List<Item> getRegistroMagazzino() {
        return registroMagazzino;
    }

    @Override
    public String toString() {
        return "RegistroMagazzino [registroMagazzino=" + registroMagazzino.toString() + "]";
    }
}
