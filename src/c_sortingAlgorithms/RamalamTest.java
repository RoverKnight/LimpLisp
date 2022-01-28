package c_sortingAlgorithms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import x_randomShit.FuckYouException;

public class RamalamTest {

    int[] unsortedArray;
    int[] sortedArray;

    @BeforeEach
    public void randomizeInput() {
        unsortedArray = new int[(int) (Math.random() * 25)];
        sortedArray = new int[unsortedArray.length];
        for (int i = 0; i < unsortedArray.length; i++) {
            unsortedArray[i] = (int) (Math.random() * 100);
            //if (Math.random() < 0.3) unsortedArray[i] *= -1;
        }
    }

    @Test
    public void searchMeTest() {
        int[] nums = new int[100];
        for (int i = 0; i < 100; i++) {
            nums[i] = i;
        }

        for (int i = 0; i < 100; i++) {
            try {
                System.out.println(Ramalam.searchMe(nums, i));
            } catch (FuckYouException ignored) {
                System.out.println("Shit");
            }
        }

        try {
            System.out.println(Ramalam.searchMe(nums, -1));
        } catch (FuckYouException ignored) {
            System.out.println("Shit");
        }

        try {
            System.out.println(Ramalam.searchMe(nums, 100));
        } catch (FuckYouException ignored) {
            System.out.println("Shit");
        }
    }

    @Test
    public void selectionSortButCoolerTest() {
        Ramalam.printArray(unsortedArray, "Unsorted:");
        sortedArray = Ramalam.selectionSortButCooler(unsortedArray);
        Ramalam.printArray(sortedArray, "Sorted: ");
        assert Ramalam.isSorted(sortedArray);
    }

    @Test
    public void bubbleSortTest() {
        Ramalam.printArray(unsortedArray, "Unsorted:");
        sortedArray = Ramalam.bubbleSort(unsortedArray);
        Ramalam.printArray(sortedArray, "Sorted: ");
        assert Ramalam.isSorted(sortedArray);
    }

    @Test
    public void insertionSortTest() {
        Ramalam.printArray(unsortedArray, "Unsorted:");
        sortedArray = Ramalam.insertionSort(unsortedArray);
        Ramalam.printArray(sortedArray, "Sorted: ");
        assert Ramalam.isSorted(sortedArray);
    }

    @Test
    public void selectionSortTest() {
        Ramalam.printArray(unsortedArray, "Unsorted:");
        sortedArray = Ramalam.selectionSort(unsortedArray);
        Ramalam.printArray(sortedArray, "Sorted: ");
        assert Ramalam.isSorted(sortedArray);
    }
}
