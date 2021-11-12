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

    public void addKnoten(Knoten knoten) {
        Knoten anchor = wurzel;
        boolean shouldRun = true;
        while (shouldRun) {

            // warn if same
            if (anchor.getInhalt() == knoten.getInhalt()) {
                System.out.println("Knots have same value");
            }

            // if smaller
            if (anchor.getInhalt() < knoten.getInhalt()) {

            }

            // if bigger
            else {

            }
        }
    }

    public void deleteKnoten(Knoten knoten) {

    }

    // TODO
    public void ausgebenPre(Knoten knoten) {
        System.out.println(knoten.getInhalt());
        try {
            ausgebenPre(knoten.getLeft());
        } catch (NullPointerException ignored) {}

        try {
            ausgebenPre(knoten.getRight());
        } catch (NullPointerException ignored) {}
    }

    // TODO
    public void ausgebenPost(Knoten knoten) {
        try {
            ausgebenPre(knoten.getLeft());
        } catch (NullPointerException ignored) {}

        try {
            ausgebenPre(knoten.getRight());
        } catch (NullPointerException ignored) {}

        System.out.println(knoten.getInhalt());
    }

    // TODO
    public void ausgebenIn(Knoten knoten) {
        try {
            ausgebenPre(knoten.getLeft());
        } catch (NullPointerException ignored) {}

        System.out.println(knoten.getInhalt());

        try {
            ausgebenPre(knoten.getRight());
        } catch (NullPointerException ignored) {}

    }

    public Knoten getByPfad(boolean[] directions) {

    }

    public Knoten[] getKnotenPre() {

    }

    public Knoten[] getKnotenPost() {

    }

    public Knoten[] getKnotenIn() {

    }

    public int berechneWidth() {

    }

    public int berechneDepth() {

    }

    // TODO
    public void clear() {
        wurzel = null;
    }






}
