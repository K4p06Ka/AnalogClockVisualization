package model;

import java.awt.*;

public class MinuteHand extends ClockHand {
    public MinuteHand() {
        super(70, 4, Color.DARK_GRAY); // 70% of radius, width 4
    }

    public void updateAngle(int... timeValues) {
        int minute = timeValues[0];

        // Calculate angle: each minute is 6 degrees (360/ 60 = 6)
        this.angle = minute * 6;
    }
}
