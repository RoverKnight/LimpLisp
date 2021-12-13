package b_recursion.towersOfHanoi;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Beschreibung
 *
 * @author
 * @version 1.0 vom 15.09.2010
 */

public class towersOfHanoi extends JFrame {
    // Anfang Attribute
    private final JTextField jTextField1 = new JTextField();
    private final JButton jButton1 = new JButton();
    int count = 0;
    // Ende Attribute

    public towersOfHanoi(String title) {

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
        jTextField1.setBounds(32, 24, 121, 24);
        jTextField1.setText("");
        cp.add(jTextField1);
        jButton1.setBounds(32, 56, 123, 25);
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

    // Anfang Methoden
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
     * @param t3 index of final tower
     */
    public void hanoi(int numOfPlates, int t1, int t2, int t3) {



    }

    // Ende Methoden

    public static void main(String[] args) {
        new towersOfHanoi("towersOfHanoi");
    }
}
