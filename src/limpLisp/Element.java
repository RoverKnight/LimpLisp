package limpLisp;

public class Element {

    private String daten;
    private Element naechstes;

    public Element(String daten) {
        this.daten = daten;
    }

    public void setDaten(String daten) {
        this.daten = daten;
    }

    public String getDaten() {
        return daten;
    }

    public Element getNaechstes() {
        return naechstes;
    }

    public void setNaechstes(Element naechstes) {
        this.naechstes = naechstes;
    }


}
