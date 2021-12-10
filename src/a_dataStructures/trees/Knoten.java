package a_dataStructures.trees;

public class Knoten {

    private int inhalt;
    private Knoten left;
    private Knoten right;


    public Knoten(int inhalt) {
        this.inhalt = inhalt;
    }

    public int getNumOfChildren() {
        int count = 0;
        if (left != null) count++;
        if (right != null) count++;
        return count;
    }

    public int getInhalt() {
        return inhalt;
    }

    public void setInhalt(int inhalt) {
        this.inhalt = inhalt;
    }

    public Knoten getLeft() {
        return left;
    }

    public void setLeft(Knoten left) {
        this.left = left;
    }

    public Knoten getRight() {
        return right;
    }

    public void setRight(Knoten right) {
        this.right = right;
    }



}
