package b_recursion.maths;

public class Mathsss {





    public static double facultyRecursive(double num) {
        /* return 1 if num is 0 or 1;
         * not catching 0 will cause StackOverflowError
         * 1! is (obviously) 1
         */
        if (num == 1 || num == 0) return 1;


        return num * facultyRecursive(num - 1);
    }

    public static double facultyIterative(double num) {
        // return 1 if num is 0; 0! is 1 but uncomputable
        if (num == 0) return 1;

        // compute via for-loop
        double ogNum = num;
        for (int i = 1; i < ogNum; i++) {
            num *= i;
        }

        return num;
    }

}
