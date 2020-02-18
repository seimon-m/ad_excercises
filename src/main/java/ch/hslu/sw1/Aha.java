package ch.hslu.sw1;

public class Aha {

    public static void main(String[] args) {
        task(5);
    }

    public static void task(final int n) {
        task1();
        task1();
        task1();
        task1();    // T ~ 4

        for (int i = 0; i < n; i++) {   // äussere Schleife: n-mal

            task2();
            task2();
            task2();    // T ~ n · 3

            for (int j = 0; j < n; j++) {   // innere Schleife: n-mal

                task3();    // T ~ n · n· 2
                task3();
            }

        }

    }

    public static void task1() {

    }

    public static void task2() {

    }

    public static void task3() {

    }
}
