package service;

import java.time.LocalTime;

public class TimeService {

    public int getCurrentHour() {
        return LocalTime.now().getHour();
    }

    public int getCurrentMinute() {
        return LocalTime.now().getMinute();
    }

    public int getCurrentSecond() {
        return LocalTime.now().getSecond();
    }

    public LocalTime getCurrentTime() {
        return LocalTime.now();
    }
}