package b_recursion.maths;

public class Mathsss {



    public static double facultyI(double num) {
        // 0! is 1 but uncomputable, must be handled separately
        if (num == 0) return 1;

        // compute via for-loop
        double ogNum = num;
        for (int i = 1; i < ogNum; i++) {
            num *= i;
        }

        return num;
    }

    public static double facultyR(double num) {
        // not catching 0 will cause StackOverflowError and 1! is 1
        if (num == 1 || num == 0) return 1;

        // a^x == a * a^(x-1)
        return num * facultyR(num - 1);
    }

    public static double fibonacciI(int index) {
        if (index < 0) {
            System.out.println(":|");
            return -1;
        }
        else if (index == 0) return 0;

        double num = 1;
        double oldNum = 0;
        for (int i = 1; i < index; i++) {
            num += oldNum;
            oldNum = num - oldNum;
        }

        return num;
    }

    public static double fibonacciR(int index) {
        if (index < 0) {
            System.out.println(":|");
            return -1;
        }
        else if (index == 0) return 0;
        else if (index == 1) return 1;

        return fibonacciR(index - 1) + fibonacciR(index - 2);
    }

}
