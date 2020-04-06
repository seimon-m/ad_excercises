package ch.hslu.sw07.end;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        List<AdditionTask> tasks = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            AdditionTask task = new AdditionTask(i * 5, i * 10);
            tasks.add(task);
            Thread thread = new Thread(task, "task " + i);
            threads.add(thread);
        }

        for (final Thread thread : threads) {
            thread.start();
            Thread.sleep(500);
            thread.interrupt();
        }
    }
}
