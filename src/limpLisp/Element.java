package limpLisp;

public class Element {

    private String daten;
    private Element[] children;

    public Element(String daten, int order) {
        this.daten = daten;
        children = new Element[order];
    }

    public void setDaten(String daten) {
        this.daten = daten;
    }

    public String getDaten() {
        return daten;
    }

    public Element[] getChildren() {
        return children;
    }

    public Element getChild(int position) {
        return children[position];
    }

    public void setChild(Element element, int position) {
        this.children[position] = element;
    }

    public int getOrder() {
        return children.length;
    }


}
