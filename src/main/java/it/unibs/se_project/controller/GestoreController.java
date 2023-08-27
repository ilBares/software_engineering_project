package it.unibs.se_project.controller;

import java.util.List;

import it.unibs.se_project.business.Bevanda;
import it.unibs.se_project.business.Calendario;
import it.unibs.se_project.business.Config;
import it.unibs.se_project.business.GenereExtra;
import it.unibs.se_project.business.MenuTematico;
import it.unibs.se_project.business.Piatto;
import it.unibs.se_project.business.RegistroMagazzino;
import it.unibs.se_project.repository.interfaces.BevandeRepository;
import it.unibs.se_project.repository.interfaces.CalendarioRepository;
import it.unibs.se_project.repository.interfaces.ConfigRepository;
import it.unibs.se_project.repository.interfaces.GeneriExtraRepository;
import it.unibs.se_project.repository.interfaces.MenuTematiciRepository;
import it.unibs.se_project.repository.interfaces.PiattiRepository;
import it.unibs.se_project.repository.interfaces.RegistroMagazzinoRepository;

public class GestoreController {
    // REPOSITORIES
    private CalendarioRepository<Calendario> rCalendario;
    private ConfigRepository<Config> rConfig;
    private BevandeRepository<Bevanda> rBevande;
    private GeneriExtraRepository<GenereExtra> rGeneriExtra;
    private MenuTematiciRepository<MenuTematico> rMenuTematici;
    private PiattiRepository<Piatto> rPiatti;
    private RegistroMagazzinoRepository<RegistroMagazzino> rRegistroMagazzino;
    

    public GestoreController(
        CalendarioRepository<Calendario> rCalendario,
        ConfigRepository<Config> rConfig,
        BevandeRepository<Bevanda> rBevande,
        GeneriExtraRepository<GenereExtra> rGeneriExtra,
        MenuTematiciRepository<MenuTematico> rMenuTematici,
        PiattiRepository<Piatto> rPiatti,
        RegistroMagazzinoRepository<RegistroMagazzino> rRegistroMagazzino
    ) {
        this.rCalendario = rCalendario;
        this.rBevande = rBevande;
        this.rConfig = rConfig;
        this.rGeneriExtra = rGeneriExtra;
        this.rMenuTematici = rMenuTematici;
        this.rPiatti = rPiatti;
        this.rRegistroMagazzino = rRegistroMagazzino;
    }

    public int getCaricoLavoroPersona() {
        return rConfig.getConfig().getCaricoLavoroPersona();
    }

    public int getNumeroPosti() {
        return rConfig.getConfig().getNumeroPosti();
    }

    public List<Bevanda> getBevande() {
        return List.copyOf(rBevande.getBevande());
    }

    public List<GenereExtra> getGeneriExtra() {
        return List.copyOf(rGeneriExtra.getGeneriExtra());
    }

    public List<Piatto> getPiatti() {
        return List.copyOf(rPiatti.getPiatti());
    }

    public List<MenuTematico> getMenuTematici() {
        return List.copyOf(rMenuTematici.getMenuTematici());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Bevande: " + rBevande.getBevande());
        sb.append("Calendario: " + rCalendario.getCalendario());
        sb.append("Config: " + rConfig.getConfig());
        sb.append("GeneriExtra: " + rGeneriExtra.getGeneriExtra());
        sb.append("MenuTematici: " + rMenuTematici.getMenuTematici());
        sb.append("Piatti: " + rPiatti.getPiatti());
        sb.append("RegistroMagazzino: " + rRegistroMagazzino.getRegistroMagazzino());

        return sb.toString();
    }
}
