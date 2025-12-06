package model;

import java.awt.*;

public class HourHand extends ClockHand {
    public HourHand() {
        super(50, 6, Color.BLACK); // 50% of radius, width 6
    }

    public void updateAngle(int... timeValues) {
        int hour = timeValues[0];
        int minute = timeValues[1];

        // Convert to 12-hour format
        hour = hour % 12;

        // Calculate angle: each hour is 30 degrees (360/12 = 30)
        // Add minute contribution: each minute is 0.5 degrees
        this.angle = (hour * 30) + (minute * 0.5);
    }
}

