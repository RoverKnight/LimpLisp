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
        // return -1 if invalid index given to indicate error
        if (index < 0) {
            System.out.println(":|");
            return -1;
        }

        // 0-case handled separately since num can't be initialized with 0
        else if (index == 0) return 0;

        // actual calculation
        double num = 1;
        double oldNum = 0;
        for (int i = 1; i < index; i++) {
            num += oldNum;          // new num is always current + old num
            oldNum = num - oldNum;  // assigns previous num value to oldNum
        }

        return num;
    }

    public static double fibonacciR(int index) {
        // return -1 if invalid index given to indicate error
        if (index < 0) {
            System.out.println(":|");
            return -1;
        }

        // 0-/1-cases handled separately since recursive method call would push index below 0
        else if (index == 0 || index == 1) return index;

        // friendly warning message cuz it gets slow af
        else if (index > 45) System.out.println("This may take a while...");

        return fibonacciR(index - 1) + fibonacciR(index - 2);
    }

}
