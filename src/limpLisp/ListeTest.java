package limpLisp;

import org.junit.jupiter.api.Test;

public class ListeTest {

    private Liste liste = new Liste();
    private FlatElement[] elements = {
            new FlatElement("0"),
            new FlatElement("1"),
            new FlatElement("2"),
            new FlatElement("3"),
    };

    public void prepareInOrder() {
        for (FlatElement element : elements) {
            liste.hintenAnfuegen(element);
        }
    }

    @Test
    public void allTheGoddamnTests() {}

    @Test
    public void addToFront() {
        // add each to front
        for (FlatElement element : elements) {
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
        liste.loeschen(3);
        try {
            liste.ausgeben();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void x() {}


}
