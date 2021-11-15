package limpLisp;

public class Element {

    private String daten;
    private Element[] children;

    public Element(String daten, int maxChildren) {
        this.daten = daten;
        children = new Element[maxChildren];
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

    public boolean addChild(Element element) {
        for (Element child : children) {
            if (child == null) {
                child = element;
                return true;
            }
        }
        return false;
    }

    public void removeChild(int position) {
        children[position] = null;
    }

    public boolean removeChild(Element element) {
        for (Element child : children) {
            if (child == element) {
                child = null;
                return true;
            }
        }
        return false;
    }


    public int getOrder() {
        return children.length;
    }

    public void changeMaxChildren(int newMax) {

        if (newMax == children.length) return;

        // check and return if any children will be lost
        else if (newMax < children.length) {
            int count = 0;
            for (Element child : children) {
                if (child != null) count++;
            }
            if (count > newMax) {
                System.out.println("Could not change max children; lossy conversion");
                return;
            }

        }

        Element[] tempChildStorage = new Element[newMax];

        // transfer children to temp storage
        int n = 0;
        for (int i = 0; i < children.length; i++) {
            tempChildStorage[n] = children[i];
            if (tempChildStorage[n] != null) n++; // removes nulls from array
        }

        // increase array size
        children = new Element[newMax];

        // re-add children
        for (int i = 0; i < tempChildStorage.length; i++) {
            children[i] = tempChildStorage[i];
        }

    }


}
