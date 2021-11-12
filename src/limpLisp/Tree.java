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

        }
    }

    public boolean addElement(Element element, int[] directions) {
        if (directions.length == 0) root = element;
        else {
            try {
                Element anchor = root;
                for (int i = 0; i < directions.length; i++) {
                    anchor = anchor.getChild(directions[i]);
                }
                //anchor.setChild(element);
            } catch (NullPointerException ignored) {
                System.out.println("");
            }
        }


        return true;
    }

}
