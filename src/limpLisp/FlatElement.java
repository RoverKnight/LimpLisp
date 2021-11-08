package limpLisp;

public class FlatElement {

    private String daten;
    private FlatElement naechstes;

    public FlatElement(String daten) {
        this.daten = daten;
    }

    public void setDaten(String daten) {
        this.daten = daten;
    }

    public String getDaten() {
        return daten;
    }

    public FlatElement getNaechstes() {
        return naechstes;
    }

    public void setNaechstes(FlatElement naechstes) {
        this.naechstes = naechstes;
    }


}
