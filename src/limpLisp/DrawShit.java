package limpLisp;

public class DrawShit {

    static Turtle turtle = new Turtle();

    public static void goTo(int x, int y) {
        turtle.penUp();
        turtle.toStartingPoint(x, y);
        turtle.penDown();
        turtle.showTurtle();
    }

    public static void drawSquare(int length, int x, int y) {
        goTo(x, y);
        for (int i = 0; i < 4; i++) {
            turtle.move(length);
            turtle.turn(90);
        }
    }

    public static void a2() {
        drawSquare(100, 50, 50);
        drawSquare(100, 200, 50);
    }

    public static void drawDasHausVomNikolaus(int pGroesse, int x, int y) {
        drawSquare(pGroesse, x, y);

        turtle.turn(45);
        turtle.move(pGroesse * 1.41);

        turtle.turn(180);
        turtle.move(pGroesse * 1.41);
        turtle.turn(135);
        turtle.move(pGroesse);
        turtle.turn(135);

        turtle.move(pGroesse * 1.41);

        turtle.turn(-45);
        turtle.move(pGroesse * 1,41);
        goTo(x, y);
        turtle.turn(-1 * turtle.getDirection());
        turtle.turn(-60);
        turtle.move(pGroesse);
        turtle.turn(120);
        turtle.move(pGroesse);
    }

    public static void drawNGon(int numOfSides, int length) {
        for (int i = 0; i < numOfSides; i++) {
            turtle.move(length);
            turtle.turn(360 / numOfSides);
        }
    }

    public static void drawStar(int numOfSpikes, int diameter) {
        for (int i = 0; i < numOfSpikes; i++) {
            turtle.move(diameter);
            turtle.turn(180 - (180 / numOfSpikes));
        }
    }

    public static void drawFlower(int numOfShapeSides, int length) {

        for (int i = 0; i < numOfShapeSides; i++) {
            drawNGon(numOfShapeSides, length);
            turtle.turn(360 / numOfShapeSides);
        }

    }

    public static void drawSinglePattern() {

        turtle.turn(-90);
        for (int i = 0; i < 2; i++) {
            turtle.move(100);
            turtle.turn(90);
        }
        for (int i = 0; i < 2; i++) {
            turtle.move(50);
            turtle.turn(90);
        }
        turtle.turn(-180);
        turtle.move(50);
        turtle.turn(-90);
        turtle.move(100);

    }

    public static void drawHypnosisSpiral() {

        for (int i = 0; i < 200; i++) {
            if (i == 140) turtle.setColor(2);
            turtle.move(i*2);
            turtle.turn(90);

        }

    }

    public static void explodeColor() {
        turtle.hideTurtle();
        for (int i = 0; i < 120; i++) {
            if (i % 3 == 0) turtle.setColor(4);
            else if (i % 3 == 1) turtle.setColor(1);
            else if (i % 3 == 2) turtle.setColor(2);
            turtle.move(150);
            turtle.move(-150);
            turtle.turn(-3);
        }
    }

    public static void drawSquareTheSnail(int nGon) {

        double a = 180;
        while (a > 5) {
            DrawShit.drawNGon(nGon, (int)a);
            turtle.turn(-10);
            a *= 0.9;
        }

    }

    public static void drawThePentagonButCooler() {
        double a = 5;
        while (a < 200) {
            turtle.move(a);
            turtle.turn(70);
            a++;
        }
    }

    //public static void incept

}
