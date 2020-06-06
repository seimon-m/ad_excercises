package ch.hslu.sw04;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MainStack {
    int size = 10000000;
    String[] array = new String[size];
    static List<Long> timeList = new ArrayList<>();

    private static final Logger LOG = LogManager.getLogger(MainStack.class);

    public static void main(String[] args) {

        int measurements = 10;
        MainStack main = new MainStack();
        LOG.info("JCF Stack measurements:");
        for (int i = 0; i < measurements; i++) {
            LOG.info(main.javaStack());
        }
        int sum = 0;
        for (int i = 1; i < timeList.size(); i++) {
            sum += timeList.get(i);
        }
        LOG.info("JCF Stack average time: " + sum / (measurements - 1) + "ms");
        timeList.clear();

        LOG.info("MyStack measurements:");
        for (int i = 0; i < measurements; i++) {
            LOG.info(main.myStack());
        }
        sum = 0;
        for (int i = 1; i < timeList.size(); i++) {
            sum += timeList.get(i);
        }
        LOG.info("MyStack average time: " + sum / (measurements - 1) + "ms");
    }

    public long javaStack() {
        for (int i = 0; i < array.length; i++) {
            array[i] = "Stack" + i;
        }

        Stack<String> javaStack = new Stack<>();

        long time1 = System.currentTimeMillis();
        for (String s : array) {
            javaStack.push(s);
        }
        long time2 = System.currentTimeMillis();
        timeList.add(time2 - time1);
        return time2 - time1;
    }

    public long myStack() {
        for (int i = 0; i < array.length; i++) {
            array[i] = "Stack" + i;
        }

        ch.hslu.sw02.Stack myStack = new ch.hslu.sw02.Stack(size);

        long time1 = System.currentTimeMillis();
        for (String s : array) {
            myStack.push(s);
        }
        long time2 = System.currentTimeMillis();
        timeList.add(time2 - time1);
        return time2 - time1;
    }
}
