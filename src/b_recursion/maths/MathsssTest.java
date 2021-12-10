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
        for (int i = 0; i < timeStamps.length; i++) {
            System.out.println("index = " + timeStamps[i] + ":");
            long startTime = System.currentTimeMillis();
            Mathsss.fibonacciI(timeStamps[i]);
            long endTime = System.currentTimeMillis();
            long timeTaken = endTime - startTime;
            System.out.println("  I - " + timeTaken + "ms");

            startTime = System.currentTimeMillis();
            Mathsss.fibonacciR(timeStamps[i]);
            endTime = System.currentTimeMillis();
            timeTaken = endTime - startTime;
            System.out.println("  R - " + timeTaken + "ms");
        }
    }

}
