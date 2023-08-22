package repository;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.unibs.se_project.business.Calendario;
import it.unibs.se_project.repository.JsonCalendarioRepository;
import it.unibs.se_project.repository.interfaces.CalendarioRepository;

public class JsonCalendarRepositoryTest {
    private CalendarioRepository<Calendario> repository;

    @Before
    public void setUp() {
        repository = new JsonCalendarioRepository();
    }

    @Test
    public void testGetCalendario() {
        Calendario calendario = repository.getCalendario();
        assertEquals(2, calendario.getCalendar().size());

        System.out.println("\nCALENDARIO: " + calendario);
    }
}
