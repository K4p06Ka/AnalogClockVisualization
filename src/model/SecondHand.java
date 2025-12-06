package model;

import java.awt.*;

public class SecondHand extends ClockHand {
    public SecondHand() {
        super(80, 2, Color.RED); // 80% of radius, width 2
    }

    public void updateAngle(int... timeValues) {
        int second = timeValues[0];

        // Calculate angle: each second is 6 degrees (360/60 = 6)
        this.angle = second * 6;
    }
}
