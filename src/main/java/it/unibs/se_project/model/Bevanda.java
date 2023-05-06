package it.unibs.se_project.model;

import it.unibs.se_project.enums.UnitaDiMisura;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.databind.*;

public class Bevanda extends ItemExtra {
    ObjectMapper mapper = new ObjectMapper();
    
    public Bevanda(String nome, double quantita, UnitaDiMisura unitaDiMisura) {
        super(nome, quantita, unitaDiMisura);
    }
}
