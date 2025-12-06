package model;

import java.awt.*;

public abstract class ClockHand {
    protected double angle;
    protected int length;
    protected int width;
    protected Color color;

    public ClockHand(int length, int width, Color color) {
        this.length = length;
        this.width = width;
        this.color = color;
        this.angle = 0;
    }

    public abstract void updateAngle(int... timeValues);

    public void draw(Graphics2D g2d, int centerX, int centerY, int radius) {
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(width));

        // Calculate hand length relative to clock radius
        int handLength = (radius * length) / 100;

        // Calculate end point of hand
        double radians = Math.toRadians(angle - 90);
        int endX = (int) (centerX + handLength * Math.cos(radians));
        int endY = (int) (centerY + handLength * Math.sin(radians));

        // Draw the hand
        g2d.drawLine(centerX, centerY, endX, endY);
    }
}
