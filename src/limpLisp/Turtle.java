package limpLisp;
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.WritableRaster;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;

public class Turtle extends JFrame implements ActionListener {
    private int delay;
    private int lastX;
    private int lastY;
    private int colorValue;
    private double x;
    private double startX;
    private double y;
    private double startY;
    private double direction;
    private boolean down;
    private boolean isVisible;
    private boolean activ;
    private Color tColor;
    final int maxWidth;
    final int maxHeight;
    static int tNumber;
    static int barHeight = 20;
    static int currentWidth = 1500;
    static int currentHeight = 670;
    static boolean firstCall = true;
    static final Vector<Turtle> tList = new Vector();
    static JFrame jFrame;
    static Container container;
    public static Color[] colors;
    public static final int black = 0;
    public static final int green = 1;
    public static final int blue = 2;
    public static final int yellow = 3;
    public static final int red = 4;
    public static final int gray = 5;
    public static final int lightGray = 6;
    public static final int orange = 7;
    public static final int white = 8;
    public static int[] rgbColor;
    static Graphics g;
    static Graphics gWithTurtle;
    static Graphics gWithoutTurtle;
    static BufferedImage iWithTurtle;
    static BufferedImage iWithoutTurtle;
    static JMenuBar menueBar;
    static JButton eraseButton;
    static JButton restoreButton;
    static JButton closeButton;
    private static boolean isFilled;
    public static final int schwarz = 0;
    public static final int grün = 1;
    public static final int gruen = 1;
    public static final int blau = 2;
    public static final int gelb = 3;
    public static final int rot = 4;
    public static final int grau = 5;
    public static final int hellgrau = 6;
    public static final int weiß = 8;
    public static final int weiss = 8;

    public static void setFilled(boolean filled) {
        isFilled = filled;
    }

    public Turtle() {
        this(currentWidth, currentHeight);
    }

    public Turtle(int b, int h) {
        this.delay = 1;
        this.lastX = 0;
        this.lastY = 0;
        this.colorValue = 0;
        this.x = 0.0D;
        this.startX = 0.0D;
        this.y = 0.0D;
        this.startY = 0.0D;
        this.direction = 0.0D;
        this.down = true;
        this.tColor = Color.black;
        this.maxWidth = 1280;
        this.maxHeight = 1024;
        if (firstCall) {
            firstCall = false;
            jFrame = null;
            g = null;
            container = null;
            this.initComponents(b + 12, h + barHeight + 36);
            this.initGraphics();
        }

        if (jFrame == null || !jFrame.isVisible()) {
            jFrame = null;
            g = null;
            container = null;
            this.removeTurtles();
            if (h == currentHeight) {
                this.initComponents(b, h);
            } else {
                this.initComponents(currentWidth, currentHeight);
            }

            this.initGraphics();
        }

        double xx = (double)(currentWidth / 2);
        double yy = (double)((currentHeight - barHeight) / 2);
        this.x = xx;
        this.y = yy;
        this.startX = this.x;
        this.startY = this.y;
        this.lastX = (int)this.x;
        this.lastY = (int)this.y;
        this.direction = 0.0D;
        this.tColor = Color.black;
        this.isVisible = false;
        this.activ = true;
        tList.add(this);
    }

    private void initGraphics() {
        if (g == null) {
            try {
                g = container.getGraphics();
                iWithTurtle = new BufferedImage(1280, 1024, 1);
                iWithoutTurtle = new BufferedImage(1280, 1024, 1);
                gWithTurtle = iWithTurtle.getGraphics();
                gWithoutTurtle = iWithoutTurtle.getGraphics();
                g.setColor(Color.white);
                g.fillRect(0, 0, 1280, 1024);
                g.setColor(Color.black);
                gWithoutTurtle.setColor(Color.white);
                gWithoutTurtle.fillRect(0, 0, 1280, 1024);
                gWithoutTurtle.setColor(Color.black);
                gWithTurtle.setColor(Color.white);
                gWithTurtle.fillRect(0, 0, 1280, 1024);
                gWithTurtle.setColor(Color.black);
            } catch (Exception var2) {
                System.out.println("Error in initGraphics()");
                this.initComponents(currentWidth, currentHeight);
                g = container.getGraphics();
            }
        }

    }

    private void removeTurtles() {
        if (tList != null) {
            tList.removeAllElements();
        }

    }

    private synchronized void restoreView() {
        if (!jFrame.isVisible()) {
            jFrame.setVisible(true);
        }

        if (g == null) {
            this.initGraphics();
        }

        this.activ = true;
        int x0;
        if (!jFrame.isVisible()) {
            this.initComponents(currentWidth, currentHeight);
            jFrame.setSize(currentWidth, currentHeight);
            jFrame.setVisible(true);
            container = this.getContentPane();
            g = container.getGraphics();
            g.setClip(0, 0, currentWidth, currentHeight);
            g.drawImage(iWithoutTurtle, 0, 0, container);
            menueBar.setVisible(true);

            for(x0 = 0; x0 < tList.size(); ++x0) {
                Turtle turtle = (Turtle)tList.elementAt(x0);
                if (turtle.isVisible && turtle.activ) {
                    this.paintTurtle(g, turtle);
                }
            }
        }

        if (this.isVisible) {
            if (this.delay < 2) {
                this.delay = 2;
            }

            x0 = Math.min(this.lastX, (int)this.x);
            int y0 = Math.min(this.lastY, (int)this.y);
            int b0 = Math.abs((int)(this.x - (double)this.lastX));
            int h0 = Math.abs((int)(this.y - (double)this.lastY));
            gWithTurtle.setClip(x0 - 21, y0 - 21, b0 + 42, h0 + 42);
            gWithTurtle.drawImage(iWithoutTurtle, 0, 0, container);
            tNumber = tList.size();

            for(int k = 0; k < tNumber; ++k) {
                Turtle tu = (Turtle)tList.elementAt(k);
                if (tu.isVisible && tu.activ) {
                    this.paintTurtle(gWithTurtle, tu);
                }
            }

            g.setClip(gWithTurtle.getClip());
            g.drawImage(iWithTurtle, 0, 0, container);
            g.setClip(0, 0, currentWidth, currentHeight);
        }

        if (this.delay > 0) {
            try {
                Thread.sleep((long)this.delay);
            } catch (Exception var7) {
            }
        }

    }

    private void paintTurtle(Graphics grafics, Turtle turtle) {
        int[] fx = new int[3];
        int[] fy = new int[3];
        double td = turtle.direction;
        double x = turtle.x;
        double y = turtle.y;
        Color tColor = turtle.tColor;
        fx[0] = (int)(x + Math.cos(arc(td)) * 20.0D);
        fy[0] = (int)(y + Math.sin(arc(td)) * 20.0D);
        td += 90.0D;
        fx[1] = (int)(x + Math.cos(arc(td)) * 5.0D);
        fy[1] = (int)(y + Math.sin(arc(td)) * 5.0D);
        td += 180.0D;
        fx[2] = (int)(x + Math.cos(arc(td)) * 5.0D);
        fy[2] = (int)(y + Math.sin(arc(td)) * 5.0D);
        grafics.setColor(tColor);
        if (isFilled) {
            grafics.fillPolygon(fx, fy, 3);
        } else {
            grafics.drawPolygon(fx, fy, 3);
        }

    }

    private void testVisibility() {
        try {
            if (!jFrame.isVisible()) {
                jFrame.setVisible(true);
            }

            if (g == null || gWithoutTurtle == null) {
                g = null;
                this.initGraphics();
            }
        } catch (Exception var2) {
            System.out.println("Error showing window!");
        }

    }

    public void actionPerformed(ActionEvent evt) {
        Object obj = evt.getSource();
        if (obj == eraseButton) {
            this.clearScreen();
        } else if (obj == restoreButton) {
            this.restoreWindow();
        } else if (obj == closeButton) {
            this.hideFrame();
        }

    }

    public void clearScreen() {
        try {
            if (!jFrame.isVisible()) {
                jFrame.setVisible(true);
            }

            g.setColor(Color.white);
            g.fillRect(0, 0, currentWidth, currentHeight);
            g.setColor(Color.black);
            gWithoutTurtle.setClip(0, 0, 1280, 1024);
            gWithoutTurtle.setColor(Color.white);
            gWithoutTurtle.fillRect(0, 0, 1280, 1024);
            gWithoutTurtle.setColor(Color.black);
            gWithTurtle.setClip(0, 0, 1280, 1024);
            gWithTurtle.setColor(Color.white);
            gWithTurtle.fillRect(0, 0, 1280, 1024);
            gWithTurtle.setColor(Color.black);

            for(int k = 0; k < tList.size(); ++k) {
                Turtle tu = (Turtle)tList.elementAt(k);
                if (tu.isVisible) {
                    tu.activ = false;
                }
            }
        } catch (Exception var3) {
        }

    }

    protected void hideFrame() {
        jFrame.setVisible(false);
        jFrame.dispose();
    }

    public void restoreWindow() {
        try {
            gWithTurtle.setClip(0, 0, currentWidth, currentHeight);
            gWithoutTurtle.setClip(0, 0, currentWidth, currentHeight);
            g.setClip(0, 0, currentWidth, currentHeight);
            g.drawImage(iWithoutTurtle, 0, 0, container);
            tNumber = tList.size();

            for(int k = 0; k < tNumber; ++k) {
                Turtle turtle = (Turtle)tList.elementAt(k);
                if (turtle.isVisible && turtle.activ) {
                    this.paintTurtle(g, turtle);
                }
            }
        } catch (Exception var3) {
        }

    }

    private void initComponents(int b, int h) {
        if (container == null) {
            container = this.getContentPane();
        }

        container.setBackground(Color.white);
        currentWidth = b;
        currentHeight = h;
        jFrame = this;
        jFrame.setTitle("Turtle version 6a (c) Alfred Hermes");
        menueBar = new JMenuBar();
        jFrame.setJMenuBar(menueBar);
        eraseButton = new JButton("Fenster leeren");
        menueBar.add(eraseButton);
        eraseButton.addActionListener(this);
        restoreButton = new JButton("Fenster herstellen");
        menueBar.add(restoreButton);
        restoreButton.addActionListener(this);
        closeButton = new JButton("Fenster schließen");
        menueBar.add(closeButton);
        closeButton.addActionListener(this);
        jFrame.setSize(currentWidth, currentHeight);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(0);
    }

    public void paint(Graphics gr) {
        try {
            currentWidth = this.getWidth();
            currentHeight = this.getHeight();
            container = this.getContentPane();
            g = container.getGraphics();
            this.paintComponents(gr);
            this.restoreWindow();
            if (iWithoutTurtle == null) {
                iWithTurtle = new BufferedImage(1280, 1024, 1);
                iWithoutTurtle = new BufferedImage(1280, 1024, 1);
                gWithTurtle = iWithTurtle.getGraphics();
                gWithoutTurtle = iWithoutTurtle.getGraphics();
                gWithoutTurtle.setColor(Color.white);
                gWithoutTurtle.fillRect(0, 0, 1280, 1024);
                gWithoutTurtle.setColor(Color.black);
                gWithTurtle.setColor(Color.white);
                gWithTurtle.fillRect(0, 0, 1280, 1024);
                gWithTurtle.setColor(Color.black);
            }
        } catch (Exception var3) {
            System.out.println("Error in restoring the window");
            System.out.println("iOhne = null: " + (iWithoutTurtle == null));
            this.paintComponents(gr);
        }

    }

    private static double arc(double winkel) {
        return winkel * 3.141592653589793D / 180.0D;
    }

    private static double degree(double arc) {
        return arc * 180.0D / 3.141592653589793D;
    }

    private int convertColor(int rgb) {
        for(int k = 0; k < 9; ++k) {
            if (rgbColor[k] == rgb) {
                return k;
            }
        }

        return -1;
    }

    public synchronized void move(double steps) {
        this.testVisibility();

        try {
            double nextX = (double)Math.round(this.x + Math.cos(arc(this.direction)) * steps);
            double nextY = (double)Math.round(this.y + Math.sin(arc(this.direction)) * steps);
            g.setColor(this.tColor);
            gWithoutTurtle.setColor(this.tColor);
            if (this.down) {
                g.drawLine((int)this.x, (int)this.y, (int)nextX, (int)nextY);
                gWithoutTurtle.drawLine((int)this.x, (int)this.y, (int)nextX, (int)nextY);
            }

            this.lastX = (int)this.x;
            this.lastY = (int)this.y;
            this.x = nextX;
            this.y = nextY;
            this.restoreView();
        } catch (Exception var7) {
            System.out.println("error in moving!");
            System.out.println("gWithoutTurtle == null: " + (gWithoutTurtle == null));
            System.out.println("Frame is Visible: " + jFrame.isVisible());
            System.exit(0);
        }

    }

    public void penUp() {
        this.down = false;
    }

    public void penDown() {
        this.down = true;
    }

    public void setDirection(double angle) {
        this.direction = angle;
        this.restoreView();
    }

    public double getDirection() {
        return this.direction;
    }

    public double getXPos() {
        return this.x;
    }

    public double getYPos() {
        return this.y;
    }

    public double getMaxX() {
        return (double)container.getBounds().width;
    }

    public double getMaxY() {
        return (double)container.getBounds().height;
    }

    public synchronized void turn(double angle) {
        this.direction += angle;
        this.restoreView();
    }

    public synchronized void setColor(int c) {
        this.tColor = colors[c];
        this.colorValue = c;
        this.restoreView();
    }

    public int getColor() {
        return this.colorValue;
    }

    public synchronized void turnTo(double x, double y) {
        this.setDirection(x - this.getXPos(), y - this.getYPos());
        this.restoreView();
    }

    public synchronized void write(String s) {
        this.testVisibility();
        gWithoutTurtle.setColor(this.tColor);
        gWithoutTurtle.setFont(new Font("Helvetica", 1, 14));
        gWithoutTurtle.drawString(s, (int)this.x, (int)this.y);
        g.setColor(this.tColor);
        g.setFont(new Font("Helvetica", 1, 14));
        g.drawString(s, (int)this.x, (int)this.y);
        this.restoreView();
    }

    public void setSpeed(int s) {
        if (s > 10) {
            s = 10;
        }

        if (s < 0) {
            s = 0;
        }

        this.delay = 10 - s;
    }

    public void hideTurtle() {
        this.isVisible = false;
        if (g == null) {
            this.initGraphics();
        }

    }

    public void showTurtle() {
        this.isVisible = true;
        this.activ = true;
        if (g == null) {
            this.initGraphics();
        }

    }

    public synchronized void toStartingPoint(double sx, double sy) {
        if (!jFrame.isVisible()) {
            jFrame.setVisible(true);
        }

        this.x = sx;
        this.y = sy;
        this.startX = this.x;
        this.startY = this.y;
        this.lastX = (int)this.x;
        this.lastY = (int)this.y;
        this.initGraphics();
        this.restoreView();
    }

    public synchronized void moveTo(double nextX, double nextY) {
        this.testVisibility();

        try {
            g.setColor(this.tColor);
            gWithoutTurtle.setColor(this.tColor);
            if (this.down) {
                g.drawLine((int)this.x, (int)this.y, (int)nextX, (int)nextY);
                gWithoutTurtle.drawLine((int)this.x, (int)this.y, (int)nextX, (int)nextY);
            }

            this.lastX = (int)this.x;
            this.lastY = (int)this.y;
            this.x = nextX;
            this.y = nextY;
            this.restoreView();
        } catch (Exception var6) {
            System.out.println("Error moving to!");
        }

    }

    public void moveArc(double arcAngle, double radius) {
        double preDirection = this.direction;
        double step = 3.141592653589793D * radius / 180.0D;
        double alpha = arcAngle / Math.abs(arcAngle);
        double rotation = alpha;

        while(Math.abs(rotation) <= Math.abs(arcAngle)) {
            this.turn(alpha);
            rotation += alpha;
            double nextX = this.x + Math.cos(arc(this.direction)) * step;
            double nextY = this.y + Math.sin(arc(this.direction)) * step;
            g.setColor(this.tColor);
            gWithoutTurtle.setColor(this.tColor);
            if (this.down) {
                g.drawLine((int)this.x, (int)this.y, (int)nextX, (int)nextY);
                gWithoutTurtle.drawLine((int)this.x, (int)this.y, (int)nextX, (int)nextY);
            }

            this.lastX = (int)this.x;
            this.lastY = (int)this.y;
            this.x = nextX;
            this.y = nextY;
            this.restoreView();
        }

        this.direction = preDirection + arcAngle;
    }

    public synchronized void setDirection(double deltaX, double deltaY) {
        if (deltaX == 0.0D && deltaY == 0.0D) {
            this.direction = 0.0D;
        } else if (deltaX == 0.0D && deltaY < 0.0D) {
            this.direction = -90.0D;
        } else if (deltaX == 0.0D && deltaY > 0.0D) {
            this.direction = 90.0D;
        } else if (deltaX > 0.0D && deltaY == 0.0D) {
            this.direction = 0.0D;
        } else if (deltaX < 0.0D && deltaY == 0.0D) {
            this.direction = 180.0D;
        } else {
            double w = degree(Math.atan(deltaY / deltaX));
            if (deltaX > 0.0D) {
                this.direction = w;
            } else {
                this.direction = 180.0D + w;
            }
        }

        this.restoreView();
    }

    public void drawCircle(double radius) {
        this.testVisibility();
        if (!jFrame.isVisible()) {
            jFrame.setVisible(true);
        }

        gWithoutTurtle.setColor(this.tColor);
        gWithoutTurtle.drawOval((int)(this.x - radius), (int)(this.y - radius), (int)(radius * 2.0D), (int)(radius * 2.0D));
        g.setColor(this.tColor);
        g.drawOval((int)(this.x - radius), (int)(this.y - radius), (int)(radius * 2.0D), (int)(radius * 2.0D));
        this.activ = true;
    }

    public void fillCircle(double radius) {
        this.testVisibility();
        gWithoutTurtle.setColor(this.tColor);
        int x1 = (int)(this.x - radius);
        int y1 = (int)(this.y - radius);
        int d = (int)(radius * 2.0D);
        gWithoutTurtle.fillOval(x1, y1, d, d);
        gWithoutTurtle.setClip(x1, y1, d, d);
        g.setClip(gWithoutTurtle.getClip());
        g.drawImage(iWithoutTurtle, 0, 0, container);
        gWithoutTurtle.setClip(0, 0, currentWidth, currentHeight);
        g.setClip(gWithoutTurtle.getClip());
        this.activ = true;
    }

    public void plotPixel() {
        int x1 = (int)this.x;
        int y1 = (int)this.y;
        gWithoutTurtle.setColor(this.tColor);
        gWithoutTurtle.fillRect(x1, y1, 1, 1);
        g.setColor(this.tColor);
        g.fillRect(x1, y1, 1, 1);
        this.activ = true;
    }

    public void sleep(int time) {
        try {
            Thread.sleep((long)time);
        } catch (InterruptedException var3) {
        }

    }

    public void copyPixel(int x, int y, int xTarget, int yTarget) {
        boolean status = this.down;
        this.down = false;
        if (this.isVisible) {
            this.moveTo((double)x, (double)y);
        }

        gWithoutTurtle.copyArea(x, y, 1, 1, xTarget - x, yTarget - y);
        gWithoutTurtle.setClip(xTarget, yTarget, 1, 1);
        g.setClip(gWithoutTurtle.getClip());
        g.drawImage(iWithoutTurtle, 0, 0, container);
        g.setClip(0, 0, currentWidth, currentHeight);
        gWithoutTurtle.setClip(0, 0, currentWidth, currentHeight);
        if (this.isVisible) {
            this.moveTo((double)xTarget, (double)yTarget);
        }

        this.down = status;
    }

    public int getPixelColor() {
        WritableRaster raster = iWithoutTurtle.getRaster();
        DataBufferInt buffer = (DataBufferInt)raster.getDataBuffer();
        int[] values = buffer.getData();
        int c = values[(int)(this.y * (double)iWithoutTurtle.getWidth() + this.x)];
        int pixelColor = this.convertColor(c);
        return pixelColor;
    }

    public synchronized void vor(double l) {
        this.move(l);
    }

    public void hebeStift() {
        this.penUp();
    }

    public void senkeStift() {
        this.penDown();
    }

    public void setzeRichtung(double degree) {
        this.setDirection(degree);
    }

    public synchronized void setzeRichtung(double deltaX, double deltaY) {
        this.setDirection(deltaX, deltaY);
    }

    public double liesRichtung() {
        return this.getDirection();
    }

    public double liesX() {
        return this.getXPos();
    }

    public double liesY() {
        return this.getYPos();
    }

    public double liesMaxX() {
        return this.getMaxX();
    }

    public double liesMaxY() {
        return this.getMaxY();
    }

    public synchronized void drehe(double degree) {
        this.turn(degree);
    }

    public synchronized void setzeFarbe(int c) {
        this.setColor(c);
    }

    public int liesFarbe() {
        return this.getColor();
    }

    public synchronized void schaueNach(double x, double y) {
        this.turnTo(x, y);
    }

    public synchronized void schreibe(String s) {
        this.write(s);
    }

    public void setzeTempo(int s) {
        this.setSpeed(s);
    }

    public void verstecke() {
        this.hideTurtle();
    }

    public void zeige() {
        this.showTurtle();
    }

    public synchronized void zumStart(double sx, double sy) {
        this.toStartingPoint(sx, sy);
    }

    public synchronized void geheNach(double newX, double newY) {
        this.moveTo(newX, newY);
    }

    public void geheImBogen(double arc, double r) {
        this.moveArc(arc, r);
    }

    public void zeichneKreis(double r) {
        this.drawCircle(r);
    }

    public void fuelleKreis(double r) {
        this.fillCircle(r);
    }

    public void ruhe(int time) {
        this.sleep(time);
    }

    public int liesPixelFarbe() {
        return this.getPixelColor();
    }

    static {
        colors = new Color[]{Color.black, Color.green, Color.blue, Color.yellow, Color.red, Color.gray, Color.lightGray, Color.orange, Color.white};
        rgbColor = new int[]{-16777216, -16711936, -16776961, -256, -65536, -8355712, -4144960, -14336, -1};
        isFilled = true;
    }
}
