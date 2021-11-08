package limpLisp;

import org.junit.jupiter.api.Test;


public class StackTest {

    public StackTest() {}

    @Test
    public void test() {
        FlatElement[] elements = {
                new FlatElement("e0"),
                new FlatElement("e1"),
                new FlatElement("e2"),
                new FlatElement("e3"),
        };
        Stack stack = new Stack();

        // fill stack
        for (int i = 0; i < 4; i++) {
            stack.push(elements[i]);
            assert stack.top() == elements[i];
            System.out.println("added " + elements[i].getDaten() + ";     currently on top: " + stack.top().getDaten());
        }
        assert !stack.empty();
        System.out.println("there's stuff in the stack");
        // empty stack
        int n = 3;
        for (int i = 0; i < 4; i++) {
            FlatElement e = stack.pop();
            assert e == elements[n];
            n--;
            if (stack.top() != null) {
                System.out.println("removed " + elements[i].getDaten() + ";   currently on top: " + stack.top().getDaten());
            }
        }
        assert stack.empty();
        System.out.println("there ain't shit in the stack");



    }




}
