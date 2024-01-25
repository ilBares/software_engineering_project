package repository;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.unibs.se_project.business.GenereExtra;
import it.unibs.se_project.business.dictionary.GeneriExtraDictionary;
import it.unibs.se_project.repository.JsonGeneriExtraRepository;
import it.unibs.se_project.repository.interfaces.GeneriExtraRepository;

public class JsonGeneriExtraTest {
    private GeneriExtraRepository<GeneriExtraDictionary> repository;

    @Before
    public void setUp() {
        repository = new JsonGeneriExtraRepository();
    }

    @Test
    public void testGetGeneriExtra() {
        GeneriExtraDictionary generiExtra = repository.getGeneriExtraDictionary();

        GenereExtra pane = generiExtra.getGenereExtra("pane");
        assertEquals("pane", pane.getNome());
        assertEquals(1, pane.getQuantita(), 0);

        GenereExtra grissini = generiExtra.getGenereExtra("grissini");
        assertEquals("grissini", grissini.getNome());
        assertEquals(1, grissini.getQuantita(), 0);

        // repository.add(new GenereExtra("patatine", 10));
        // GenereExtra patatine = generiExtra.get(2);
        // assertEquals(3, generiExtra.size());

        // repository.delete(patatine);
        // assertEquals(2, generiExtra.size());

        System.out.println("\nGENERI_ALIMENTARI: " + generiExtra);
    }
}
