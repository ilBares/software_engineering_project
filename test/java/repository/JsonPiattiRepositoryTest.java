package repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import it.unibs.se_project.domain.Piatto;
import it.unibs.se_project.enums.UnitaDiMisura;
import it.unibs.se_project.repository.JsonPiattiRepository;
import it.unibs.se_project.repository.interfaces.PiattiRepository;

public class JsonPiattiRepositoryTest {
    private PiattiRepository<Piatto> repository;

    @Before
    public void setUp() {
        repository = new JsonPiattiRepository();
    }

    @Test
    public void testGetPiatti() {
        List<Piatto> piatti = repository.getPiatti();

        assertEquals(piatti.size(), 2);
        assertEquals(piatti.get(0).getRicetta().getIngredienti().get(1).getNome(), "limone");
        assertEquals(piatti.get(0).getRicetta().getIngredienti().get(0).getUnitaDiMisura(), UnitaDiMisura.KG);

        System.out.println("\nPIATTI: " + piatti);
    }
}
