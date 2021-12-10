package b_recursion.maths;

public class Mathsss {





    public static int facultyRecursive(int num) {
        if (num == 1 || num == 0) {
            return 1;
        }
        return num * facultyRecursive(num - 1);
    }

    public static int facultyIterative(int num) {
        if (num == 0) return 1;

        int ogNum = num;
        for (int i = 1; i < ogNum; i++) {
            num *= i;
        }
        return num;
    }

}
