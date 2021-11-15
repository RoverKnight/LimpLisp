package limpLisp;

public class BBaum {

    private Knoten wurzel;


    public BBaum() {

    }

    public BBaum(Knoten wurzel) {
        this.wurzel = wurzel;
    }


    public Knoten getWurzel() {
        return wurzel;
    }

    /**
     * @param knoten Der Knoten der angefuegt werden soll.
     * @author goose
     *
     */
    public void addElement(Knoten knoten) {

        // fängt aufrufe ab bei denen gegebenes elem gleich null ist; verhindert NullPointerException
        if (knoten == null) {
            System.out.println("Smth went wrong");
            return;
        }

        // weißt wurzel dem element zu und returnt wenn wurzel leer ist; verhindert Endlosschleife
        if (wurzel == null) {
            wurzel = knoten;
            return;
        }

        // ausgangsknoten (anchor) wird mit wurzel initialisiert; durchlauf startet bei wurzel
        Knoten anchor = wurzel;

        // durchläuft baum bis freier platz gefunden wird, returnt wenn gefunden u. angefuegt
        while (true) {

            // wenn daten des elems kleiner/gleich dem ausgangsknoten sind
            if (knoten.getInhalt() <= anchor.getInhalt()) {
                if (anchor.getLeft() == null) {
                    anchor.setLeft(knoten);
                    return;
                }
                else {
                    anchor = anchor.getLeft();
                }
            }

            // wenn daten des elems größer als ausgangsknoten sind
            else {
                if (anchor.getRight() == null) {
                    anchor.setRight(knoten);
                    return;
                }
                else {
                    anchor = anchor.getRight();
                }
            }
        }

    }

    public void deleteKnoten(Knoten knoten) {

    }

    public void ausgebenPre() {
        ausgebenPre(getWurzel());
    }

    public void ausgebenPost() {
        ausgebenPost(getWurzel());
    }

    public void ausgebenIn() {
        ausgebenIn(getWurzel());
    }

    private void ausgebenPre(Knoten knoten) {
        System.out.println(knoten.getInhalt());
        try {
            ausgebenPre(knoten.getLeft());
        } catch (NullPointerException ignored) {}

        try {
            ausgebenPre(knoten.getRight());
        } catch (NullPointerException ignored) {}
    }

    private void ausgebenPost(Knoten knoten) {
        try {
            ausgebenPost(knoten.getLeft());
        } catch (NullPointerException ignored) {}

        try {
            ausgebenPost(knoten.getRight());
        } catch (NullPointerException ignored) {}

        System.out.println(knoten.getInhalt());
    }

    private void ausgebenIn(Knoten knoten) {
        try {
            ausgebenIn(knoten.getLeft());
        } catch (NullPointerException ignored) {}

        System.out.println(knoten.getInhalt());

        try {
            ausgebenIn(knoten.getRight());
        } catch (NullPointerException ignored) {}

    }

    public Knoten getByPfad(boolean[] directions) {
        return null;
    }

    public Knoten[] getKnotenPre() {
        return null;
    }

    public Knoten[] getKnotenPost() {
        return null;
    }

    public Knoten[] getKnotenIn() {
        return null;
    }

    public int berechneWidth() {
        return 0;
    }

    public int berechneDepth() {
        return 0;
    }

    public void clear() {
        wurzel = null;
    }






}
