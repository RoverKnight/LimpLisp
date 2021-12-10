package a_dataStructures.linkedLists;

public class Queue {

    private Element anfang = null;
    private int laenge = 0;

    public Queue() {

    }


    public boolean isEmpty() {
        return anfang == null;
    }

    public void enter(Element newElement) {
        if (anfang == null) anfang = newElement;
        else {
            Element currentElement = anfang;
            while (currentElement.getNaechstes() != null) {
                currentElement = currentElement.getNaechstes();
            }
            currentElement.setNaechstes(newElement);
            laenge++;
        }
    }

    public Element getFront() {
        return anfang;
    }

    public Element remove() {
        if (anfang == null) return null;
        Element removedElement = anfang;
        anfang = anfang.getNaechstes();
        laenge--;
        return removedElement;
    }


}
