package b_recursion.towersOfHanoi;

import a_dataStructures.linkedLists.Stack;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Beschreibung
 *
 * @author
 * @version 1.0 vom 15.09.2010
 */

public class TowersOfHanoi extends JFrame {
    // Anfang Attribute
    private final JTextField jTextField1 = new JTextField();
    private final JButton jButton1 = new JButton();
    int count = 0;
    // Ende Attribute

    public TowersOfHanoi(String title) {

        // Frame-Initialisierung - GUI Fenster
        super(title);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        int frameWidth = 300;
        int frameHeight = 300;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;
        setLocation(x, y);
        Container cp = getContentPane();
        cp.setLayout(null);

        // Anfang Komponenten
        jTextField1.setBounds(32, 24, 120, 24);
        jTextField1.setText("");
        cp.add(jTextField1);
        jButton1.setBounds(32, 56, 120, 25);
        jButton1.setText("Hanoi!");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1_ActionPerformed(evt);
            }
        });
        cp.add(jButton1);
        // Ende Komponenten

        setResizable(false);
        setVisible(true);
    }

    public void jButton1_ActionPerformed(ActionEvent evt) {
        int n = Integer.parseInt(jTextField1.getText());
        count = 0;
        hanoi(n, 1, 2, 3);
        // tip: ausgabe soll sein "bewege von 1 nach 3" etc
    }

    /**
     * Eine Methode zum Lösen des Hanoiproblems
     *
     * @param numOfPlates The number of plates
     * @param t1 index of starting tower
     * @param t2 index of transition tower
     * @param t3 index of destination tower
     */
    public void hanoi(int numOfPlates, int t1, int t2, int t3) {
        // set transition tower as destination tower
        if (numOfPlates > 1) hanoi(numOfPlates - 1, t1, t3, t2);

        System.out.println(t1 + " -> " + t3);

        // set transition tower as starting tower
        if (numOfPlates > 1) hanoi(numOfPlates - 1, t2, t1, t3);
    }

    public void hanoiI(int numOfPlates) {

        Stack[] towers = {
                new Stack(),
                new Stack(),
                new Stack()
        };

        int i = 0;
        while (!towers[0].empty() && !towers[1].empty()) {

            if (i % 2 == 1) {



            }





            i++;
        }

    }




    public static void main(String[] args) {
        new TowersOfHanoi("TowersOfHanoi");
    }
}
