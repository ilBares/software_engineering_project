package it.unibs.se_project.users;

import it.unibs.se_project.business.Calendario;
import it.unibs.se_project.business.RegistroMagazzinoDictionary;
import it.unibs.se_project.controller.MagazziniereController;
import it.unibs.se_project.repository.JsonCalendarioRepository;
import it.unibs.se_project.repository.JsonRegistroMagazzinoRepository;
import it.unibs.se_project.repository.interfaces.CalendarioRepository;
import it.unibs.se_project.repository.interfaces.RegistroMagazzinoRepository;
import it.unibs.se_project.service.CalendarioService;
import it.unibs.se_project.service.RegistroMagazzinoService;
import it.unibs.se_project.view.MenuMagazziniere;

public class Magazziniere {
    public static void main(String[] args) {
        CalendarioRepository<Calendario> calendarioRepository = new JsonCalendarioRepository();
        RegistroMagazzinoRepository<RegistroMagazzinoDictionary> registroMagazzinoRepository = new JsonRegistroMagazzinoRepository();

        MagazziniereController controller = new MagazziniereController(
            new CalendarioService(calendarioRepository),
            new RegistroMagazzinoService(registroMagazzinoRepository)
        );

        MenuMagazziniere menu = new MenuMagazziniere(controller);
        menu.showMenu();
    }
}
