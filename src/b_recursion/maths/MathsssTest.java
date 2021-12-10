package b_recursion.maths;

import org.junit.jupiter.api.Test;

public class MathsssTest {



    @Test
    public void facultyTest() {
        int num = 55;
        System.out.println(num + "! = " + Mathsss.facultyR(num));

        System.out.println(num + "! = " + Mathsss.facultyI(num));
    }

    @Test
    public void killMyBatteryPlease() {
        while (true) {
            fibonacciFunctionalityTest();
        }
    }

    @Test
    public void fibonacciFunctionalityTest() {
        System.out.println("I:");
        for (int i = 0; i < 45; i++) {
            System.out.println("  #" + i + " - " + Mathsss.fibonacciI(i));
        }

        System.out.println("R:");
        for (int i = 0; i < 45; i++) {
            System.out.println("  #" + i + " - " + Mathsss.fibonacciR(i));
        }
    }

    @Test
    public void fibonacciTimedTest() {
        int[] timeStamps = { 5, 25, 30, 31, 33, 35, 40, 45 };
        long startTime;
        long endTime;
        long timeTaken;

        // test each timestamp
        for (int timeStamp : timeStamps) {
            System.out.println("index = " + timeStamp + ":");

            // iterative
            startTime = System.nanoTime();
            Mathsss.fibonacciI(timeStamp);
            endTime = System.nanoTime();
            timeTaken = (endTime - startTime) / 1000000;
            System.out.println("  I - " + timeTaken + "ms");

            // recursive
            startTime = System.nanoTime();
            Mathsss.fibonacciR(timeStamp);
            endTime = System.nanoTime();
            timeTaken = (endTime - startTime) / 1000000;
            System.out.println("  R - " + timeTaken + "ms");
        }
    }

}
