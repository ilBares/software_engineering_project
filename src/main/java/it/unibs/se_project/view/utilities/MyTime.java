package it.unibs.se_project.view.utilities;

public class MyTime {
    public static final int REALLY_LOW_MILLIS_PAUSE = 250;
    public static final int LOW_MILLIS_PAUSE = 500;
    public static final int MEDIUM_MILLIS_PAUSE = 750;
    public static final int HIGH_MILLIS_PAUSE = 1000;

    public static void pause(int millisPause) {
        try {
            Thread.sleep(millisPause);
        } catch (InterruptedException ignored) {
        }
    }
}