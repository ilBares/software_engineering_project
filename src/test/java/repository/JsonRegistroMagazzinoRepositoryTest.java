package repository;

import org.junit.Before;
import org.junit.Test;

import it.unibs.se_project.business.RegistroMagazzinoDictionary;
import it.unibs.se_project.repository.JsonRegistroMagazzinoRepository;
import it.unibs.se_project.repository.interfaces.RegistroMagazzinoRepository;

public class JsonRegistroMagazzinoRepositoryTest {
    private RegistroMagazzinoRepository<RegistroMagazzinoDictionary> repository;

    @Before
    public void setUp() {
        repository = new JsonRegistroMagazzinoRepository();
    }

    @Test
    public void testGetRegistroMagazzino() {
        RegistroMagazzinoDictionary registroMagazzinoDictionary = repository.getRegistroMagazzinoDictionary();
        
        // assertEquals(2, registroMagazzinoDictionary.getItemList().size());

        // registroMagazzino.input(new Ingrediente("salsa", 0.2, UnitaDiMisura.L));
        // registroMagazzino.input(new ItemListaSpesa("carote", 3, UnitaDiMisura.HG));
        // registroMagazzino.input(new GenereExtra("funghi", 4));
        // registroMagazzino.input(new Bevanda("spuma", 10));

        // repository.updateRegistroMagazzino(registroMagazzino);

        // assertEquals(6, registroMagazzino.getRegistroMagazzino().size());

        System.out.println("\nREGISTRO MAGAZZINO: " + registroMagazzinoDictionary);
    }
}
