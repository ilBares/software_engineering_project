package repository;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.unibs.se_project.business.Config;
import it.unibs.se_project.enums.UnitaDiMisura;
import it.unibs.se_project.repository.JsonConfigRepository;
import it.unibs.se_project.repository.interfaces.ConfigRepository;

public class JsonConfigRepositoryTest {
    private ConfigRepository<Config> repository;

    @Before
    public void setUp() {
        repository = new JsonConfigRepository();
    }

    @Test
    public void testGetConfig() {
        Config config = repository.getConfig();

        int anticipoGiorniPrenotazione = config.getAnticipoGiorniPrenotazione();
        assertEquals(60, anticipoGiorniPrenotazione);

        UnitaDiMisura unitaGeneriExtra = config.getUnitaGeneriExtra();
        assertEquals(UnitaDiMisura.HG, unitaGeneriExtra);

        System.out.println("\nCONFIG: " + config);
    }
}
