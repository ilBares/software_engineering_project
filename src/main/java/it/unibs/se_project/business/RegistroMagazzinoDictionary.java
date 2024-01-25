package it.unibs.se_project.business;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RegistroMagazzinoDictionary {
    private HashMap<String, Item> registroMagazzino;

    @JsonCreator
    public RegistroMagazzinoDictionary(
        @JsonProperty("registro_magazzino") HashMap<String, Item> registroMagazzino
    ) {

        this.registroMagazzino = registroMagazzino;
    }

    public void input(Item item) {
        Item oldItem = registroMagazzino.get(item.getNome());

        if (oldItem != null) {
            BigDecimal bd = new BigDecimal(oldItem.getQuantita() + item.getQuantita());
            BigDecimal rounded = bd.setScale(2, RoundingMode.HALF_UP);

            registroMagazzino.put(
                item.getNome(),
                new Item(
                    oldItem.getNome(),
                    rounded.doubleValue(),
                    oldItem.getUnitaDiMisura()
                )
            );
        } else {
            registroMagazzino.put(item.getNome(), item);
        }
    }

    public void output(Item item) {
        Item oldItem = registroMagazzino.get(item.getNome());

        if (oldItem != null) {
            BigDecimal bd = new BigDecimal(oldItem.getQuantita() - item.getQuantita());
            BigDecimal rounded = bd.setScale(2, RoundingMode.HALF_UP);

            registroMagazzino.put(
                item.getNome(),
                new Item(
                    oldItem.getNome(),
                    rounded.doubleValue(),
                    oldItem.getUnitaDiMisura()
                )
            );
        }
    }
    
    @JsonProperty("registro_magazzino")
    public HashMap<String, Item> getRegistroMagazzino() {
        return registroMagazzino;
    }

    @Override
    public String toString() {
        return "RegistroMagazzino [registroMagazzino="+ registroMagazzino + "]";
    }
}
