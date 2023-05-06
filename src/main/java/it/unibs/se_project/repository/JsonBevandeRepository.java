package it.unibs.se_project.repository;

import java.util.List;
import it.unibs.se_project.model.Bevanda;
import it.unibs.se_project.repository.interfaces.BevandeRepository;


public class JsonBevandeRepository implements BevandeRepository<Bevanda> {
    public static final String PATH = "resources/bevande.json";

    @Override
    public List<Bevanda> getBevande() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getListBevande'");
    }
}
