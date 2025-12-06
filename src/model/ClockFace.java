package model;

import java.awt.*;

public class ClockFace {
    private Color backgroundColor;
    private Color borderColor;
    private Color numberColor;

    public ClockFace() {
        this.backgroundColor = Color.WHITE;
        this.borderColor = Color.BLACK;
        this.numberColor = Color.BLACK;
    }

    public void draw(Graphics2D g2d, int centerX, int centerY, int radius) {
        // Draw clock background
        g2d.setColor(backgroundColor);
        g2d.fillOval(centerX - radius, centerY - radius, radius * 2, radius * 2);

        // Draw clock border
        g2d.setColor(borderColor);
        g2d.setStroke(new BasicStroke(3));
        g2d.drawOval(centerX - radius, centerY - radius, radius * 2, radius * 2);

        // Draw hour markings and numbers
        drawHourMarkings(g2d, centerX, centerY, radius);
    }

    private void drawHourMarkings(Graphics2D g2d, int centerX,
                                  int centerY, int radius) {
        g2d.setColor(numberColor);

        // Draw 12 hour marks
        for (int i = 1; i <= 12; i++) {
            double angle = Math.toRadians((i * 30) - 90);

            // Calculate position for hour numbers
            int numX = (int) (centerX + (radius - 25) * Math.cos(angle));
            int numY = (int) (centerY + (radius - 25) * Math.sin(angle));

            // Draw hour number
            g2d.setFont(new Font("Arial", Font.BOLD, 18));
            String hourText = String.valueOf(i);
            FontMetrics fm = g2d.getFontMetrics();
            int textWidth = fm.stringWidth(hourText);
            int textHeight = fm.getAscent();
            g2d.drawString(hourText, numX - textWidth / 2, numY + textHeight / 3);

            // Draw hour tick marks
            int tickStartX = (int) (centerX + (radius - 10) * Math.cos(angle));
            int tickStartY = (int) (centerY + (radius - 10) * Math.sin(angle));
            int tickEndX = (int) (centerX + radius * Math.cos(angle));
            int tickEndY = (int) (centerY + radius * Math.sin(angle));

            g2d.setStroke(new BasicStroke(3));
            g2d.drawLine(tickStartX, tickStartY, tickEndX, tickEndY);
        }

        // Draw minute marks
        g2d.setStroke(new BasicStroke(1));
        for (int i = 0; i < 60; i++) {
            if (i % 5 != 0) { // Skip hour positions
                double angle = Math.toRadians((i * 6) - 90);
                int tickStartX = (int) (centerX + (radius - 5) * Math.cos(angle));
                int tickStartY = (int) (centerY + (radius - 5) * Math.sin(angle));
                int tickEndX = (int) (centerX + radius * Math.cos(angle));
                int tickEndY = (int) (centerY + radius * Math.sin(angle));
                g2d.drawLine(tickStartX, tickStartY, tickEndX, tickEndY);
            }
        }
    }
}
