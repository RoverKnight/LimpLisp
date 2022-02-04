package c_sortingAlgorithms;

public class Heapsorter {


    int[] array;


    public Heapsorter(int[] array) {
        this.array = array;
    }


    /**
     * @function Sortiert dass an das Heapsorter-Objekt gegebene Feld.
     * @return Eine sortierte Version des gegebenen Feldes.
     */
    public int[] sort() {
        for (int i = 0; i < array.length; i++) {
            heapify(i, i);
        }
        return array;
    }

    /**
     * @function Bildet einen heap; das groeszte Element wird an die Stelle [offset] im Feld getauscht. Das restliche
     *           Feld bleibt unsortiert. Alle Elemente dessen Index kleiner als offset ist, werden nicht betrachtet.
     * @param subRootIndex Start- bzw. Parent-Element, dass mit seinen Kindern heapified werden soll.
     * @param offset Bestimmt, wieviele Zahlen bereits sortiert im Array vorliegen, sodass diese nicht beachtet werden.
     *               Sollte mit jedem Aufruf auf dasselbe Feld um 1 inkrementiert werden.
     */
    private void heapify(int subRootIndex, int offset) {

        // kinder-indexe berechnen
        int c1 = (subRootIndex - offset) * 2 + offset + 1;
        int c2 = c1 + 1;

        // abbrechen wenn element keine kinder hat (da keine tauschmoeglichkeiten bestehen)
        if (c1 >= array.length) return;

        // rekursives aufrufen fuer kinderelemente
        heapify(c1, offset);
        heapify(c2, offset);

        // mit erstem kind tauschen falls dieses groeszer ist
        if (array[c1] > array[subRootIndex]) {
            int temp = array[c1];
            array[c1] = array[subRootIndex];
            array[subRootIndex] = temp;
        }

        // mit zweitem kind tauschen falls dieses groeszer (und vorhanden) ist
        try {
            if (array[c2] > array[subRootIndex]) {
                int temp = array[c2];
                array[c2] = array[subRootIndex];
                array[subRootIndex] = temp;
            }
        }

        // abbruch falls kein zweites kind vorhanden
        catch (ArrayIndexOutOfBoundsException ignored) {}
    }
}
