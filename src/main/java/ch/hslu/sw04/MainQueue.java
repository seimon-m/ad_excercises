package ch.hslu.sw04;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;


public class MainQueue {
    int size = 10000000;
    String[] array = new String[size];
    static List<Long> timeList = new ArrayList<>();

    private static final Logger LOG = LogManager.getLogger(MainQueue.class);

    public static void main(String[] args) {

        int measurements = 10;
        MainQueue main = new MainQueue();
        LOG.info("JCF ConcurrentLinkedDeque measurements:");
        for (int i = 0; i < measurements; i++) {
            LOG.info(main.jcfConcurrentLinkedDeque());
        }
        int sum = 0;
        for (int i = 1; i < timeList.size(); i++) {
            sum += timeList.get(i);
        }
        LOG.info("JCF ConcurrentLinkedDeque average time: " + sum / (measurements - 1) + "ms");
        timeList.clear();

        LOG.info("MyQueue measurements:");
        for (int i = 0; i < measurements; i++) {
            LOG.info(main.myQueue());
        }
        sum = 0;
        for (int i = 1; i < timeList.size(); i++) {
            sum += timeList.get(i);
        }
        LOG.info("MyQueue average time: " + sum / (measurements - 1) + "ms");
    }

    public long jcfConcurrentLinkedDeque() {
        for (int i = 0; i < array.length; i++) {
            array[i] = "Stack" + i;
        }

        ConcurrentLinkedDeque<String> jcfQueue = new ConcurrentLinkedDeque<>();

        long time1 = System.currentTimeMillis();
        for (String s : array) {
            jcfQueue.add(s);
        }
        long time2 = System.currentTimeMillis();
        timeList.add(time2 - time1);
        return time2 - time1;
    }

    public long myQueue() {
        for (int i = 0; i < array.length; i++) {
            array[i] = "Stack" + i;
        }

        MyQueue myQueue = new MyQueue(size);

        long time1 = System.currentTimeMillis();
        for (String s : array) {
            myQueue.add(s);
        }
        long time2 = System.currentTimeMillis();
        timeList.add(time2 - time1);
        return time2 - time1;
    }
}
