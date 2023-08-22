package it.unibs.se_project.business;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WorkingDay {
    /// yyyy-mm-dd
    private Date day;
    private Prenotazione[] prenotazioni;
    private ListaSpesa listaSpesa;
    // private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @JsonCreator
    public WorkingDay(
        // @JsonProperty("day") String dayString,
        @JsonProperty("prenotazioni") Prenotazione[] prenotazioni,
        @JsonProperty("lista_della_spesa") ItemListaSpesa[] itemsListaSpesa
    ) throws ParseException {
        // this.day = dateFormat.parse(dayString);
        this.prenotazioni = prenotazioni;
        this.listaSpesa = new ListaSpesa(itemsListaSpesa);
    }

    public Date getDay() {
        return day;
    }

    public Prenotazione[] getPrenotazioni() {
        return prenotazioni;
    }

    public ListaSpesa getListaSpesa() {
        return listaSpesa;
    }

    @Override
    public String toString() {
        return "WorkingDay [prenotazioni=" + Arrays.toString(prenotazioni) + ", listaSpesa="
                + listaSpesa + "]";
    }
}
