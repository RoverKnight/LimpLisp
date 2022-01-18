package c_sortingAlgorithms;

import x_randomShit.FuckYouException;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Ramalam {

    public Ramalam() {

    }

    public static int searchMe(int[] nums, int wantedNum) throws FuckYouException {

        int upperLimit = nums.length;
        int lowerLimit = nums[0];

        while(true) {
            int half = (lowerLimit + upperLimit) / 2;

            if (upperLimit <= lowerLimit + 1 && nums[half] != wantedNum) throw new FuckYouException();

            if (wantedNum < nums[half]) upperLimit = half;
            else if (wantedNum > nums[half]) lowerLimit = half;
            else return half;
        }

    }

    public static int[] bubbleSort(int[] array) {

        /* gesamtes array durchlaufen bis sortiert ist
         * (ausgangsbedingung: keinen tausch durchführen; bei tausch wird i zurückgesetzt)
         */
        for (int i = 1; i < array.length; i++) {

            // werte tauschen falls der rechte kleiner als sein linker nachbar ist
            if (array[i - 1] > array[i]) {
                int temp = array[i]; // hilfsvariable zum werte tauschen
                array[i] = array[i - 1];
                array[i - 1] = temp;

                // von vorne anfangen
                i = 0; // i muss gleich 0 (nicht 1) gesetzt werden, da i im nächsten durchlauf inkrementiert wird
            }
        }

        return array;
    }

    public static int[] insertionSort(int[] unsortedArray) {
        return new int[]{0};
    }

    public static int[] selectionSort(int[] unsortedArray) {
        return new int[]{0};
    }

    /** überträgt inhalte eines arrays in eine liste; anordnung der inhalte wird nicht berücksichtigt! */
    public static List<Integer> convertToList(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int j : array) {
            list.add(j);
            //System.out.println("A - " + array[i] + " ::: L - " + list.get(i));
        }
        return list;
    }

    public static int[] badCocktailSort(int[] unsortedArray) {

        // variablen vorbereiten
        int highestIndex;
        int lowestIndex;
        List<Integer> highest = new ArrayList<>();
        List<Integer> lowest = new ArrayList<>();
        List<Integer> unsorted;
        int[] sorted = new int[unsortedArray.length];

        // gegebenes array zu liste konvertieren
        unsorted = convertToList(unsortedArray);

        // elemente in zwei listen einsortieren
        while (unsorted.size() > 0) {

            // indexe zurücksetzen um IndexOutOfBoundsException vorzubeugen
            highestIndex = 0;
            lowestIndex = 0;

            // unsortierte menge nach größtem/kleinstem wert durchsuchen, indexe merken
            for (int i = 1; i < unsorted.size(); i++) {
                if (unsorted.get(i) < unsorted.get(lowestIndex)) lowestIndex = i;
                else if (unsorted.get(i) > unsorted.get(highestIndex)) highestIndex = i;
            }

            // größten/kleinsten wert der entsprechenden menge anfügen
            if (unsorted.size() != 1) {
                lowest.add(unsorted.get(lowestIndex));
                highest.add(0, unsorted.get(highestIndex));
            }
            else lowest.add(unsorted.get(0));

            /* größten/kleinsten wert aus der unsortierten menge entfernen
             * (if-bedingungen verhindern, dass durch aufrückende elemente das falsche aussortiert wird)
             */
            if (lowestIndex < highestIndex) {
                unsorted.remove(highestIndex);
                unsorted.remove(lowestIndex);
            }
            else if (lowestIndex > highestIndex) {
                unsorted.remove(lowestIndex);
                unsorted.remove(highestIndex);
            }
            else unsorted.remove(0);
        }

        // sortierte listen zusammenführen
        lowest.addAll(highest);

        // sortierte liste zu array konvertieren und returnen
        for (int i = 0; i < lowest.size(); i++) {
            sorted[i] = lowest.get(i);
        }

        /* COOLER CONVERSION METHOD >:D
        int i = 0;
        try {
            while (true) {
                sorted[i] = lowest.get(0);
                lowest.remove(0);
                i++;
            }
        } catch (IndexOutOfBoundsException ignored) {}
        */

        return sorted;

    }

    public static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) return false;
        }
        return true;
    }

    public static void printArray(int[] array, String identifier) {
        if (!identifier.isEmpty()) System.out.print(identifier + " ");
        for (int i = 0; i < array.length; i++) {
            if (i != array.length - 1) System.out.print(array[i] + ", ");
            else System.out.print(array[i]);
        }
        System.out.println();
    }

    public static void printArray(int[] array, String identifier, int indent) {
        String indentStr = "";
        for (int i = 0; i < indent; i++) {
            indentStr += " ";
        }

        if (!identifier.isEmpty()) System.out.print(indent + identifier + " ");
        for (int i = 0; i < array.length; i++) {
            if (i != array.length - 1) System.out.print(array[i] + ", ");
            else System.out.print(array[i]);
        }
        System.out.println();
    }

}
