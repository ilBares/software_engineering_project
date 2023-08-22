package repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import it.unibs.se_project.business.Bevanda;
import it.unibs.se_project.repository.JsonBevandeRepository;
import it.unibs.se_project.repository.interfaces.BevandeRepository;

public class JsonBevandeRepositoryTest {

    private BevandeRepository<Bevanda> repository;

    @Before
    public void setUp() {
        
        repository = new JsonBevandeRepository();
    }

    @Test
    public void testGetBevande() {
        List<Bevanda> bevande = repository.getBevande();
        assertEquals(2, bevande.size());

        Bevanda acqua = bevande.get(0);
        assertEquals("acqua", acqua.getNome());
        assertEquals(1.5, acqua.getQuantita(), 0);

        Bevanda vino = bevande.get(1);
        assertEquals("vino", vino.getNome());
        assertEquals(1.5, vino.getQuantita(), 0);

        repository.add(new Bevanda("coca-cola", 10));
        Bevanda cocaCola = bevande.get(2);
        assertEquals(3, bevande.size());

        repository.delete(cocaCola);
        assertEquals(2, bevande.size());

        System.out.println("\nBEVANDE: " + bevande);
    }
}
