package repository;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.unibs.se_project.business.dictionary.MenuTematiciDictionary;
import it.unibs.se_project.repository.JsonMenuTematiciRepository;
import it.unibs.se_project.repository.interfaces.MenuTematiciRepository;

public class JsonMenuTematiciRepositoryTest {
    private MenuTematiciRepository<MenuTematiciDictionary> repository;

    @Before
    public void setUp() {
        repository = new JsonMenuTematiciRepository();
    }

    @Test
    public void testGetMenuTematici() {
        MenuTematiciDictionary menuTematici = repository.getMenuTematiciDictionary();

        // assertEquals(menuTematici.size(), 2);
        assertEquals(menuTematici.getMenuTematico("Menu Natale").getNomiPiatti().get(1), "pasta");

        System.out.println("\nMENU_TEMATICI: " + menuTematici);
    }
}
