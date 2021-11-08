package limpLisp;

public class Tree {

    private Element root;


    public Tree() {

    }

    public Tree(Element root) {
        this.root = root;
    }


    public void addElement(Element element) {
        if (root == null) root = element;
        else {
            /*
            1. search for optimal placement
            2. insert
            3. reorganize tree to optimized searches (depends on usage)
             */
        }
    }

    public boolean addElement(Element element, int[] directions) {
        if (directions.length == 0) {
            root = element;
            return true;
        }
        else {
            try {
                Element anchor = root;
                for (int i = 0; i < directions.length; i++) {
                    anchor = anchor.getChild(directions[i]);
                }
                anchor.addChild(element);
                return true;
            } catch (NullPointerException ignored) {
                System.out.println("Could not add element; faulty directions");
                return false;
            }
        }
    }

}
