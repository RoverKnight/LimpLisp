package c_sortingAlgorithms;

import x_randomShit.FuckYouException;

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

    public static int[] bubbleSort(int[] unsortedArray) {

    }

    public static int[] insertionSort(int[] unsortedArray) {

    }

    public static int[] selectionSort(int[] unsortedArray) {

    }

    public static int[] wrongCocktailSort(int[] unsortedArray) {

        // variablen vorbereiten
        int highestIndex = 0;
        int lowestIndex = 0;
        List<Integer> highest = new ArrayList<Integer>();
        List<Integer> lowest = new ArrayList<Integer>();
        List<Integer> unsorted = new ArrayList<Integer>();
        int[] sorted = new int[unsortedArray.length];

        // gegebenes array zu liste konvertieren
        for (int num : unsortedArray) {
            unsorted.add(num);
        }

        // elemente in zwei sortierte listen sortieren
        while (unsorted.size() > 0) {

            // unsortierte menge nach größtem/kleinstem wert parsen
            for (int i = 1; i < unsorted.size(); i++) {
                if (unsorted.get(i) < unsorted.get(lowestIndex)) lowestIndex = i;
                else if (unsorted.get(i) > unsorted.get(highestIndex)) highestIndex = i;
            }

            // größten/kleinsten wert der entsprechenden menge anfügen
            lowest.add(unsorted.get(lowestIndex));
            highest.add(0, unsorted.get(highestIndex));

            // größten/kleinsten wert aus der unsortierten menge entfernen
            // FIXME(?): wenn indexe gleich..?
            if (lowestIndex < highestIndex) {
                unsorted.remove(highestIndex);
                unsorted.remove(lowestIndex);
            }
            else {
                unsorted.remove(lowestIndex);
                unsorted.remove(highestIndex);
            }
        }

        // sortierte listen zusammenführen
        lowest.addAll(highest);

        // sortierte liste zu array konvertieren und returnen
        for (int i = 0; i < lowest.size(); i++) {
            sorted[i] = lowest.get(i);
        }
        return sorted;

    }

    public static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) return false;
        }
        return true;
    }

}
