package it.unibs.se_project.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.unibs.se_project.business.Item;
import it.unibs.se_project.business.WorkingDay;
import it.unibs.se_project.service.CalendarioService;
import it.unibs.se_project.service.RegistroMagazzinoService;

public class MagazziniereController {
    // SERVICES
    private CalendarioService sCalendario;
    private RegistroMagazzinoService sRegistroMagazzino;
    
    private Map<String, Item> dailyListaSpesa;
    

    public MagazziniereController(CalendarioService sCalendario, RegistroMagazzinoService sRegistroMagazzino) {
        this.sCalendario = sCalendario;
        this.sRegistroMagazzino = sRegistroMagazzino;
    }

    public List<Item> getDailyListaSpesa() {
        Map<String, Item> dailyListaSpesa = _getDailyListaSpesa();
        return new ArrayList<Item>(dailyListaSpesa.values());
    }

    public Item getRegistroItemFromName(String itemName) {
        return sRegistroMagazzino.getItemFromName(itemName);
    }

    public void inputItemToMagazzino(Item item) {
        sRegistroMagazzino.inputItem(item);
    }

    public void outputItemFromMagazzino(Item item) {
        sRegistroMagazzino.outputItem(item);
    }

    public void emptyDailyListaSpesa() {
        dailyListaSpesa = new HashMap<String, Item>();
    }

    private Map<String, Item> _getDailyListaSpesa() {
        if (dailyListaSpesa == null) {
            _updateDailyListaSpesa();
        }
        return dailyListaSpesa;
    }

    private void _updateDailyListaSpesa() {
        LocalDate now = LocalDate.now();
        WorkingDay wd = sCalendario.getCalendario().getCalendarioMap().get(now.toString());

        dailyListaSpesa = new HashMap<String, Item>();

        wd.getListaSpesa().keySet()
            .stream()
            .forEach(itemName -> {
                Item item = wd.getListaSpesa().get(itemName);
                Item regItem = getRegistroItemFromName(itemName);

                // each item requires +10% of quantity
                double incrementedQuantity = item.getQuantita() + 0.1 * item.getQuantita();

                if (regItem != null) {
                    incrementedQuantity -= regItem.getQuantita();
                }

                // rounding decimal value (ceiling)
                BigDecimal bd = new BigDecimal(incrementedQuantity);
                BigDecimal rounded = bd.setScale(2, RoundingMode.CEILING);

                if (incrementedQuantity > 0) {
                    Item newItem = new Item(
                        itemName,
                        rounded.doubleValue(),
                        item.getUnitaDiMisura()
                    );

                    dailyListaSpesa.put(itemName, newItem);
                }
            });
    }
}
