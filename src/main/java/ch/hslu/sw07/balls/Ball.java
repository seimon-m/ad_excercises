package ch.hslu.sw07.balls;

import java.util.concurrent.ThreadLocalRandom;

public class Ball implements Runnable {

    String[] colors = {"red", "black", "blue", "yellow", "green", "magenta"};
    private int diameter;

    public static void main(String[] args) {

        final Ball ball = new Ball();
        for (int i = 0; i < 10; i++) {
            final Thread thread = new Thread(ball, "Ballthread " + i);
            thread.start();
        }
    }

    private synchronized Circle createBall() {
        diameter = ThreadLocalRandom.current().nextInt(20, 50 + 1);
        int xPosition = ThreadLocalRandom.current().nextInt(20, 580 + 1);
        int yPosition = ThreadLocalRandom.current().nextInt(0, 200 + 1);
        String color = colors[ThreadLocalRandom.current().nextInt(0, 5 + 1)];
        int speed = ThreadLocalRandom.current().nextInt(1, 6 + 1);
        Circle circle = new Circle(diameter, xPosition, yPosition, color, speed);
        circle.makeVisible();
        return circle;
    }

    @Override
    public void run() {
        Circle circle = createBall();
        try {
            while (!Thread.currentThread().isInterrupted()) {
                circle.moveDown();
                if (circle.getY() >= 400 - this.diameter) {
                    circle.makeInvisible();
                    Thread.currentThread().interrupt();
                }

            }
        } catch (Exception e) {
            System.out.println(e + " / Message: " + e.getMessage());
        }
    }
}
