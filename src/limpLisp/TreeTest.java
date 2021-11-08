package limpLisp;

import org.junit.jupiter.api.Test;

public class TreeTest {

    Element[] elements;

    @Test
    public void trie() {

        fillElements(2, 15);
        Tree tree = new Tree();



    }



    public void fillElements(int maxChildren, int numOfElements) {
        for (int i = 0; i < numOfElements; i++) {
            elements[i] = new Element("e" + i, maxChildren);
        }
    }



}
