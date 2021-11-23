package limpLisp;

import org.junit.jupiter.api.Test;

public class BBaumTest {

    @Test
    public void printTest() {
        Knoten a = new Knoten(30);
        Knoten b = new Knoten(15);
        Knoten c = new Knoten(36);
        Knoten d = new Knoten(7);
        Knoten e = new Knoten(21);
        Knoten f = new Knoten(34);
        Knoten g = new Knoten(41);
        Knoten h = new Knoten(3);
        Knoten i = new Knoten(11);
        Knoten j = new Knoten(16);
        Knoten k = new Knoten(25);
        Knoten l = new Knoten(33);

        BBaum baum = new BBaum(a);
        a.setLeft(b);
        a.setRight(c);
        b.setLeft(d);
        b.setRight(e);
        c.setLeft(f);
        c.setRight(g);
        d.setLeft(h);
        d.setRight(i);
        e.setLeft(j);
        e.setRight(k);
        f.setLeft(l);

        System.out.println("Pre:");
        baum.ausgebenPre();
        System.out.println(" ");
        System.out.println("Post:");
        baum.ausgebenPost();
        System.out.println("");
        System.out.println("In:");
        baum.ausgebenIn();

    }

    @Test
    public void addTest() {
        Knoten[] knotenArray = {
                new Knoten(30),
                new Knoten(15),
                new Knoten(36),
                new Knoten(7),
                new Knoten(21),
                new Knoten(34),
                new Knoten(41),
                new Knoten(3),
                new Knoten(11),
                new Knoten(16),
                new Knoten(25),
                new Knoten(33)
        };

        BBaum tree = new BBaum();
        for (Knoten knoten : knotenArray) {
            tree.addElementIteratively(knoten);
        }

        String nl = System.lineSeparator();
        System.out.println("Pre:");
        tree.ausgebenPre();
        System.out.println(nl + "Post:");
        tree.ausgebenPost();
        System.out.println(nl + "In:");
        tree.ausgebenIn();

    }

    @Test
    public void addTest2() {
        Knoten[] knotenArray = {
                new Knoten(30),
                new Knoten(15),
                new Knoten(36),
                new Knoten(7),
                new Knoten(21),
                new Knoten(34),
                new Knoten(41),
                new Knoten(3),
                new Knoten(11),
                new Knoten(16),
                new Knoten(25),
                new Knoten(33)
        };

        BBaum tree = new BBaum();
        for (Knoten knoten : knotenArray) {
            tree.addElementRecursively(knoten, tree.getWurzel());
        }

        String nl = System.lineSeparator();
        System.out.println("Pre:");
        tree.ausgebenPre();
        System.out.println(nl + "Post:");
        tree.ausgebenPost();
        System.out.println(nl + "In:");
        tree.ausgebenIn();

    }

}