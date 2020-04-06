package ch.hslu.sw07.bank;

public class Playground {

    public static void main(String[] args) {

        final Thread[] threads = new Thread[5 * 2];

        final String[] strings = new String[5 * 2];

        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }

        for (int i = 0; i < threads.length; i++) {
            System.out.println(threads[i]);
        }
    }
}
