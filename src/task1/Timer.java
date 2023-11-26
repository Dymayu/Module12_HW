package task1;

public class Timer {

    private static long secondPassed = 0;

    public static void timer() {
        Thread oneSecTimer = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                secondPassed++;
                System.out.println(secondPassed + " sec passed from the start");
            }

        });

        Thread fiveSecTimer = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("5 sec passed");
            }

        });

        fiveSecTimer.start();
        oneSecTimer.start();

    }

    public static void main(String[] args) {
        timer();
    }
}
