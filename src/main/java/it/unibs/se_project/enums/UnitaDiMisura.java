package it.unibs.se_project.enums;

public enum UnitaDiMisura {
    LITRO("L"),
    KILOGRAMMO("KG"),
    ETTOGRAMMO("HG");

    private final String abbreviazione;

    UnitaDiMisura(String abbreviazione) {
        this.abbreviazione = abbreviazione;
    }

    public String getAbbreviazione() {
        return abbreviazione;
    }
}
