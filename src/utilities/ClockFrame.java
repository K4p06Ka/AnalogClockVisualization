package utilities;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;

public class ClockFrame extends JFrame {
    private ClockPanel clockPanel;

    public ClockFrame() {

        setTitle("Analog Clock Simulation");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        clockPanel = new ClockPanel();
        add(clockPanel);
        startClock();
    }

    private void startClock() {
        // Create a thread to update the clock continuously
        int delay = 1000;

        // Timer takes the delay and an ActionListener (or lambda in newer Java)
        //As I know we also can do it with threads ,but I think it's too hard
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                // This code runs every 'delay' milliseconds on the EDT.
                repaint();
            }
        };

        // Create and start the Timer
        Timer clockTimer = new Timer(delay, taskPerformer);
        clockTimer.start();
    }
}