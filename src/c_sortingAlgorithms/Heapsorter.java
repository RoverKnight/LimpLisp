package c_sortingAlgorithms;

import a_dataStructures.linkedLists.Element;
import a_dataStructures.trees.BBaum;
import a_dataStructures.trees.Knoten;

import java.util.ArrayList;
import java.util.List;

public class Heapsorter {


    int[] array;


    public Heapsorter(int[] array) {
        this.array = array;
    }


    public int[] sort() {
        for (int i = 0; i < array.length; i++) {
            //System.out.println("call " + i);
            heapify(i, 0, i);
            //Ramalam.printArray(array, "=> ");
        }
        return array;
    }

    private void heapify(int subRootIndex, int depth, int offset) {


        //System.out.println("  heapify " + array[subRootIndex] + " @ [" + subRootIndex + "] - " + depth);

        // kinder-indexe berechnen
        int c1 = (subRootIndex - offset) * 2 + offset + 1;
        int c2 = c1 + 1;

        // abbrechen wenn elem keine kinder hat
        if (c1 >= array.length) return;

        // rekursives aufrufen fuer kinderelemente
        heapify(c1, depth + 1, offset);
        //System.out.println("  (next child)");
        heapify(c2, depth + 1, offset);

        //System.out.println("  back to " + array[subRootIndex] + " @ [" + subRootIndex + "] - " + depth);

        // sortieren innerhalb des 3-element heaps; groeßtes element kommt nach oben
        try {

            // mit linkem kind tauschen falls dieses größer
            if (array[c1] > array[subRootIndex]) {
                //System.out.println("    switching " + array[subRootIndex] + " @ [" + subRootIndex + "] w/ " + array[c1] + " @ [" + c1 + "]");
                int temp = array[c1];
                array[c1] = array[subRootIndex];
                array[subRootIndex] = temp;
            }

            // mit rechtem kind tauschen falls dieses größer
            if (array[c2] > array[subRootIndex]) {
                //System.out.println("    switching " + array[subRootIndex] + " @ [" + subRootIndex + "] w/ " + array[c2] + " @ [" + c2 + "]");
                int temp = array[c2];
                array[c2] = array[subRootIndex];
                array[subRootIndex] = temp;
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {}
    }



}
