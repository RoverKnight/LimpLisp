package c_sortingAlgorithms;

import java.util.Random;

public class Quicksort {

    public static int groesse;
    public static int[] feld;
    public static int zwischenspeicher;

    public static void main(String[] args) {
        Random zufall = new Random();
        groesse = 10; // Größe des Feldes
        feld = new int[groesse];
        for (int i = 0; i < groesse; i++) {
            feld[i] = zufall.nextInt(1000);
        }
        feldAusgeben();
        quicksort(0, groesse - 1);
        feldAusgeben();
    }

    public static void quicksort(int links, int rechts) {
        if (links < rechts) {
            int pivot = feld[links];
            int vor = links + 1;
            int zurueck = rechts;
            while (vor < zurueck) {
                while (feld[vor] < pivot && vor < zurueck) {
                    vor++;
                }
                // Ü:Weiterschalten des rechten Zeigers. 
                if (vor < zurueck) {
                    zwischenspeicher = feld[vor];
                    feld[vor] = feld[zurueck];
                    feld[zurueck] = zwischenspeicher;
                    vor++;
                    zurueck--;
                }
            }
            if (pivot > feld[vor]) {
                // Ü:Positionierung des Pivotelementes an die richtige Stelle
            }
            quicksort(links, vor - 1);
            // Ü:zweiter rekursiver Aufruf
        }
    }

    public static void feldAusgeben() {
        for (int i = 0; i < groesse - 1; i++) {
            System.out.print(feld[i] + ", ");
        }
        System.out.println(feld[groesse - 1]);
    }

}
