package it.unibs.se_project.enums;

public enum UnitaDiMisura {
    L("LITRO"),
    KG("KILOGRAMMO"),
    HG("ETTOGRAMMO");

    private final String extended;

    UnitaDiMisura(String extended) {
        this.extended = extended;
    }

    public String getExtendedName() {
        return extended;
    }
}
