package ch.hslu.sw04;

import ch.hslu.sw02.Queue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ConcurrentLinkedDeque;


public class MainQueue {
    int size = 1000000;
    String[] array = new String[size];

    private static final Logger LOG = LogManager.getLogger(MainQueue.class);

    public static void main(String[] args) {

        int measurements = 20;
        MainQueue main = new MainQueue();
        LOG.info("JCF ConcurrentLinkedDeque measurements:");
        for (int i = 0; i < measurements; i++) {
            LOG.info(main.jcfConcurrentLinkedDeque());
        }

        LOG.info("MyQueue measurements:");
        for (int i = 0; i < measurements; i++) {
            LOG.info(main.myQueue());
        }
    }

    public long jcfConcurrentLinkedDeque() {
        for (int i = 0; i < array.length; i++) {
            array[i] = "Stack" + i;
        }

        ConcurrentLinkedDeque<String> jcfQueue = new ConcurrentLinkedDeque<>();

        long time1 = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            jcfQueue.add(array[i]);
        }
        long time2 = System.currentTimeMillis();
        return time2 - time1;
    }

    public long myQueue() {
        for (int i = 0; i < array.length; i++) {
            array[i] = "Stack" + i;
        }

        MyQueue myQueue = new MyQueue(size);

        long time1 = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            myQueue.add(array[i]);
        }
        long time2 = System.currentTimeMillis();
        return time2 - time1;
    }
}
