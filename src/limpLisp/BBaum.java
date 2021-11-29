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

    public void addElementIteratively(Knoten knoten) {

        // fängt aufrufe ab bei denen gegebener knoten gleich null ist; verhindert NullPointerException
        if (knoten == null) {
            System.out.println("Smth went wrong");
            return;
        }

        // weist knoten der wurzel zu und returnt wenn wurzel leer ist; verhindert NullPointerException
        if (wurzel == null) {
            wurzel = knoten;
            return;
        }

        // vergleichsknoten (anchor) wird mit wurzel initialisiert; durchlauf startet bei wurzel
        Knoten anchor = wurzel;

        // durchläuft baum bis freier platz gefunden, returnt wenn gefunden u. angefuegt
        while (true) {

            // wenn daten des knoten kleiner/gleich dem ausgangsknoten sind
            if (knoten.getInhalt() <= anchor.getInhalt()) {

                // fügt knoten an und returnt falls links noch frei ist, returnt
                if (anchor.getLeft() == null) {
                    anchor.setLeft(knoten);
                    return;
                }

                // wenn links nicht frei ist wird der dortige knoten als vergleichsknoten zugewiesen
                else {
                    anchor = anchor.getLeft();
                }
            }

            // wenn daten des knoten größer als ausgangsknoten sind
            else {

                // fügt knoten an und returnt falls rechts noch frei ist
                if (anchor.getRight() == null) {
                    anchor.setRight(knoten);
                    return;
                }
                // wenn links nicht frei ist wird der dortige knoten als vergleichsknoten zugewiesen
                else {
                    anchor = anchor.getRight();
                }
            }
        }
    }

    public void addElementRecursively(Knoten knoten) {
        addElementRecursively(knoten, wurzel);
    }

    public void addElementRecursively(Knoten knoten, Knoten anchor) {
        if (wurzel == null) wurzel = knoten;
        else {
            if (knoten.getInhalt() <= anchor.getInhalt()) {
                if (anchor.getLeft() == null) anchor.setLeft(knoten);
                else { addElementRecursively(knoten, anchor.getLeft());
                }
            }
            else {
                if (anchor.getRight() == null) anchor.setRight(knoten);
                else { addElementRecursively(knoten, anchor.getRight());
                }
            }
        }
    }

    public Knoten getParent(Knoten child) {
        if (child == null || child == wurzel || wurzel == null || wurzel.getNumOfChildren() == 0){
            return null;
        }

        Knoten anchor = wurzel;
        while (anchor.getLeft() != child && anchor.getRight() != child) {

            int anchorData = anchor.getInhalt();
            int childData = child.getInhalt();

            if (childData < anchorData) {
                anchor = anchor.getLeft();
            }
            else if (childData > anchorData) {
                anchor = anchor.getRight();
            }

            // if you're here something went horribly wrong; data is equal
            else {
                System.out.println("well fuck");
            }
        }

        return anchor;
    }

    public Knoten getLowestFromSubtree(Knoten subtreeRoot) {

        if (subtreeRoot == null){
            return null;
        }

        Knoten anchor = subtreeRoot;
        while (anchor.getLeft() != null) {
            anchor = anchor.getLeft();
        }

        return anchor;
    }

    public Knoten getLowestFromSubtree(int keyOfSubtreeRoot) {

        // search for root of subtree
        Knoten anchor = wurzel;
        boolean shouldRun = true;
        while (shouldRun) {
            if (anchor.getInhalt() == keyOfSubtreeRoot) {
                shouldRun = false;
            }
            else if (anchor.getLeft() != null && keyOfSubtreeRoot < anchor.getInhalt()) {
                anchor = anchor.getLeft();
            }
            else if (anchor.getRight() != null) {
                anchor = anchor.getRight();
            }
            else {
                return null;
            }
        }

        return getLowestFromSubtree(anchor);
    }

    public void deleteKnoten(int key) {

        Knoten parent;
        Knoten anchor = wurzel;

        // if key is root
        if (key == wurzel.getInhalt()) {
            wurzel = null;
        }

        // if key is some other knot
        else {
            while (true) {
                int data = anchor.getInhalt();

                // found knot
                if (key == data) {

                    parent = getParent(anchor);
                    boolean isLeftChild = parent.getLeft() == anchor; // yo that's cool
                    int numOfChildren = anchor.getNumOfChildren();

                    if (numOfChildren == 0) {
                        if (isLeftChild) parent.setLeft(null);
                        else parent.setRight(null);
                    }

                    else if (numOfChildren == 1) {
                        if (isLeftChild) parent.setLeft(anchor.getLeft());
                        else parent.setRight(anchor.getRight());
                    }

                    else if (numOfChildren == 2) {
                        Knoten lowestKnot = getLowestFromSubtree(anchor.getRight());
                        Knoten lowestParent = getParent(lowestKnot);

                        if (isLeftChild) parent.setLeft(lowestKnot);
                        else parent.setRight(lowestKnot);

                        if (lowestParent != anchor) {
                            lowestParent.setLeft(lowestKnot.getRight());
                            lowestKnot.setRight(anchor.getRight());
                        }
                        lowestKnot.setLeft(anchor.getLeft());
                    }

                    anchor.setLeft(null);
                    anchor.setRight(null);

                    return;
                }

                // didn't find knot, keep parsing
                else if (key < data) anchor = anchor.getLeft();
                else anchor = anchor.getRight();
            }
        }
    }

    public void ausgebenPre() {
        if (wurzel != null) ausgebenPre(getWurzel());
        else System.out.println("Tree is empty");    }

    public void ausgebenPost() {
        if (wurzel != null) ausgebenPost(getWurzel());
        else System.out.println("Tree is empty");    }

    public void ausgebenIn() {
        if (wurzel != null) ausgebenIn(getWurzel());
        else System.out.println("Tree is empty");
    }

    private void ausgebenPre(Knoten knoten) {
        System.out.println(knoten.getInhalt());
        if (knoten.getLeft() != null)  ausgebenPre(knoten.getLeft());
        if (knoten.getRight() != null) ausgebenPre(knoten.getRight());
    }

    private void ausgebenPost(Knoten knoten) {
        if (knoten.getLeft() != null)  ausgebenPost(knoten.getLeft());
        if (knoten.getRight() != null) ausgebenPost(knoten.getRight());
        System.out.println(knoten.getInhalt());
    }

    private void ausgebenIn(Knoten knoten) {
        if (knoten.getLeft() != null)  ausgebenIn(knoten.getLeft());
        System.out.println(knoten.getInhalt());
        if (knoten.getRight() != null) ausgebenIn(knoten.getRight());
    }

    /*
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
    */
}
