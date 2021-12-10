package b_recursion.maths;

import org.junit.jupiter.api.Test;

public class MathsssTest {







    @Test
    public void facultyTest() {
        int num = 20;
        System.out.println(num + "! = " + Mathsss.facultyRecursive(num));

        System.out.println(num + "! = " + Mathsss.facultyIterative(num));
    }

}
