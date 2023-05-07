package repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import it.unibs.se_project.model.GenereAlimentare;
import it.unibs.se_project.repository.JsonGeneriAlimentariRepository;
import it.unibs.se_project.repository.interfaces.GeneriAlimentariRepository;

public class JsonGeneriAlimentariTest {
    private GeneriAlimentariRepository<GenereAlimentare> repository;

    @Before
    public void setUp() {
        repository = new JsonGeneriAlimentariRepository();
    }

    @Test
    public void testGetGeneriAlimentari() {
        List<GenereAlimentare> generiAlimentari = repository.getGeneriAlimentari();
        assertEquals(2, generiAlimentari.size());

        GenereAlimentare pane = generiAlimentari.get(0);
        assertEquals("pane", pane.getNome());
        assertEquals(1, pane.getQuantita(), 0);

        GenereAlimentare grissini = generiAlimentari.get(1);
        assertEquals("grissini", grissini.getNome());
        assertEquals(1, grissini.getQuantita(), 0);

        repository.add(new GenereAlimentare("patatine", 10));
        GenereAlimentare patatine = generiAlimentari.get(2);
        assertEquals(3, generiAlimentari.size());

        repository.delete(patatine);
        assertEquals(2, generiAlimentari.size());

        System.out.println("\nGENERI_ALIMENTARI: " + generiAlimentari);
    }
}
