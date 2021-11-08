package limpLisp;

public class Queue {

    private FlatElement anfang = null;
    private int laenge = 0;

    public Queue() {

    }


    public boolean isEmpty() {
        return anfang == null;
    }

    public void enter(FlatElement newElement) {
        if (anfang == null) anfang = newElement;
        else {
            FlatElement currentElement = anfang;
            while (currentElement.getNaechstes() != null) {
                currentElement = currentElement.getNaechstes();
            }
            currentElement.setNaechstes(newElement);
            laenge++;
        }
    }

    public FlatElement getFront() {
        return anfang;
    }

    public FlatElement remove() {
        if (anfang == null) return null;
        FlatElement removedElement = anfang;
        anfang = anfang.getNaechstes();
        laenge--;
        return removedElement;
    }


}
