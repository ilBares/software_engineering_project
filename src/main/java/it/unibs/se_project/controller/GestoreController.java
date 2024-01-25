package it.unibs.se_project.controller;

import java.util.List;

import it.unibs.se_project.business.Bevanda;
import it.unibs.se_project.business.GenereExtra;
import it.unibs.se_project.business.MenuTematico;
import it.unibs.se_project.business.Piatto;
import it.unibs.se_project.repository.interfaces.PiattiRepository;
import it.unibs.se_project.service.BevandeService;
import it.unibs.se_project.service.ConfigService;
import it.unibs.se_project.service.GeneriExtraService;
import it.unibs.se_project.service.MenuTematiciService;

public class GestoreController {
    // SERVICES
    private ConfigService sConfig;
    private BevandeService sBevande;
    private GeneriExtraService sGeneriExtra;
    private MenuTematiciService sMenuTematici;
    private PiattiRepository<Piatto> rPiatti;
    

    public GestoreController(
        BevandeService sBevande,
        ConfigService sConfig,
        GeneriExtraService sGeneriExtra,
        MenuTematiciService sMenuTematici,
        PiattiRepository<Piatto> rPiatti
    ) {
        this.sBevande = sBevande;
        this.sConfig = sConfig;
        this.sGeneriExtra = sGeneriExtra;
        this.sMenuTematici = sMenuTematici;
        this.rPiatti = rPiatti;
    }

    public int getCaricoLavoroPersona() {
        return sConfig.getCaricoLavoroPersona();
    }

    public int getNumeroPosti() {
        return sConfig.getNumeroPosti();
    }

    public List<Bevanda> getBevande() {
        return List.copyOf(sBevande.getBevande());
    }

    public List<GenereExtra> getGeneriExtra() {
        return List.copyOf(sGeneriExtra.getGeneriExtra());
    }

    public List<Piatto> getPiatti() {
        return List.copyOf(rPiatti.getPiatti());
    }

    public List<MenuTematico> getMenuTematici() {
        return List.copyOf(sMenuTematici.getMenuTematici());
    }

    public int getAnticipoGiorniPrenotazione() {
        return sConfig.getAnticipoGiorniPrenotazione();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Bevande: " + sBevande.getBevande());
        sb.append("Config: " + sConfig.getConfig());
        sb.append("GeneriExtra: " + sGeneriExtra.getGeneriExtra());
        sb.append("MenuTematici: " + sMenuTematici.getMenuTematici());
        sb.append("Piatti: " + rPiatti.getPiatti());

        return sb.toString();
    }
}
