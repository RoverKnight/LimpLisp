package c_sortingAlgorithms;

import org.junit.jupiter.api.Test;
import x_randomShit.FuckYouException;

public class RamalamTest {

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
}
