package repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import it.unibs.se_project.model.MenuTematico;
import it.unibs.se_project.repository.JsonMenuTematiciRepository;
import it.unibs.se_project.repository.interfaces.MenuTematiciRepository;

public class JsonMenuTematiciRepositoryTest {
    private MenuTematiciRepository<MenuTematico> repository;

    @Before
    public void setUp() {
        repository = new JsonMenuTematiciRepository();
    }

    @Test
    public void testGetMenuTematici() {
        List<MenuTematico> menuTematici = repository.getMenuTematici();

        assertEquals(menuTematici.size(), 2);
        assertEquals(menuTematici.get(0).getPiatti()[1], "pasta");

        System.out.println("\nMENU_TEMATICI: " + menuTematici);
    }
}
