package limpLisp;

import org.junit.jupiter.api.Test;

public class ListeTest {

    private Liste liste = new Liste();
    private Element[] elements = {
            new Element("0"),
            new Element("1"),
            new Element("2"),
            new Element("3"),
    };

    public void prepareInOrder() {
        for (Element element : elements) {
            liste.hintenAnfuegen(element);
        }
    }

    @Test
    public void allTheGoddamnTests() {}

    @Test
    public void addToFront() {
        // add each to front
        for (Element element : elements) {
            liste.vorneAnfuegen(element);
        }

        // print data (expected order: 3, 2, 1, 0
        try {
            liste.ausgeben();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void delete() {
        prepareInOrder();
        liste.vorneLoeschen();
        liste.loeschen(2);
        try {
            liste.ausgeben();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void x() {}


}
