package utilities;

import model.*;
import service.TimeService;
import javax.swing.*;
import java.awt.*;

public class ClockPanel extends JPanel {
    private ClockFace clockFace;
    private HourHand hourHand;
    private MinuteHand minuteHand;
    private SecondHand secondHand;
    private TimeService timeService;

    public ClockPanel() {
        setBackground(Color.WHITE);

        // Initialize services
        timeService = new TimeService();

        // Initialize clock components
        clockFace = new ClockFace();
        hourHand = new HourHand();
        minuteHand = new MinuteHand();
        secondHand = new SecondHand();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int hour = timeService.getCurrentHour();
        int minute = timeService.getCurrentMinute();
        int second = timeService.getCurrentSecond();

        // Calculate center of panel
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int radius = Math.min(centerX, centerY) - 40;

        // Draw clock face
        clockFace.draw(g2d, centerX, centerY, radius);

        // Update and draw hands
        hourHand.updateAngle(hour, minute);
        minuteHand.updateAngle(minute);
        secondHand.updateAngle(second);

        hourHand.draw(g2d, centerX, centerY, radius);
        minuteHand.draw(g2d, centerX, centerY, radius);
        secondHand.draw(g2d, centerX, centerY, radius);

        // Draw center dot
        g2d.setColor(Color.BLACK);
        g2d.fillOval(centerX - 5, centerY - 5, 10, 10);
    }
}