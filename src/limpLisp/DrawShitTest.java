package limpLisp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class DrawShitTest {

    Turtle t = DrawShit.turtle;

    public DrawShitTest() {

    }

    @Test
    public void a1() {
        DrawShit.drawSquare(100, 100, 100);
    }

    @Test
    public void a2() {
        DrawShit.a2();
    }

    @Test
    public void a3() {
        DrawShit.drawDasHausVomNikolaus(100, 100, 100);
    }

    @Test
    public void b1() {
        DrawShit.drawNGon(3, 50);
        DrawShit.drawNGon(4, 50);
        DrawShit.drawNGon(5, 50);
        DrawShit.drawNGon(10, 50);
    }

    @Test
    public void b2() {
        DrawShit.drawStar(9, 100);
    }

    @Test
    public void b3() {
        DrawShit.drawFlower(12, 24);
    }

    @Test
    public void b4() {
        DrawShit.goTo(0, 150);
        for (int i = 0; i < 5; i++) {
            DrawShit.drawSinglePattern();
        }
    }

    @Test
    public void c1() {
        DrawShit.drawHypnosisSpiral();
    }

    @Test
    public void c2() {
        DrawShit.explodeColor();
    }

    @Test
    public void d1() {
        DrawShit.drawSquareTheSnail(3);
    }

    @Test
    public void d2() {
        DrawShit.drawThePentagonButCooler();
    }

    @Test
    public void d3() {

    }

    @Test
    public void kochCurve() {
        DrawShit.turtle.toStartingPoint(0, 670);
        DrawShit.turtle.setVisible(true);
        DrawShit.turtle.penDown();
        DrawShit.drawKochCurve(1500, 7);
    }

    @Test
    public void lul() {
        DrawShit.turtle.toStartingPoint(300, 500);
        DrawShit.turtle.setVisible(true);
        DrawShit.turtle.penDown();
        DrawShit.lul(150, 3);
    }

    @Test
    public void squareCook() {
        DrawShit.turtle.toStartingPoint(300, 500);
        DrawShit.turtle.setVisible(true);
        DrawShit.turtle.penDown();
        DrawShit.drawSquareCook(500, 5);
    }

    @Test
    public void triangleCook() {
        DrawShit.turtle.toStartingPoint(100, 150);
        DrawShit.turtle.setVisible(true);
        DrawShit.turtle.penDown();
        DrawShit.drawTriangleCook(500, 5); // 400/5 -> skew
    }

    @Test
    public void drawPythagoreanTree() {
        DrawShit.turtle.toStartingPoint(500, 800);
        DrawShit.turtle.setVisible(true);
        DrawShit.turtle.penDown();
        DrawShit.turtle.turn(-90);
        DrawShit.explodeColor();
        DrawShit.drawPythagoreanTree(100, 14);
    }

    @AfterEach
    public void waitForExit() {
        while (true) {}
    }

    public void move(double distance) {
        DrawShit.turtle.move(distance);
    }

    public void turn(double angle) {
        DrawShit.turtle.turn(angle);
    }
}
