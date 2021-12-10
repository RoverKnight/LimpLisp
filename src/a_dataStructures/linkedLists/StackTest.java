package a_dataStructures.linkedLists;

import org.junit.jupiter.api.Test;


public class StackTest {

    public StackTest() {}

    @Test
    public void test() {
        Element[] elements = {
                new Element("e0"),
                new Element("e1"),
                new Element("e2"),
                new Element("e3"),
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
            Element e = stack.pop();
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
