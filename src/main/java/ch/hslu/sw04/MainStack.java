package ch.hslu.sw04;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Stack;

public class MainStack {
    int size = 1000000;
    String[] array = new String[size];

    private static final Logger LOG = LogManager.getLogger(MainStack.class);

    public static void main(String[] args) {

        int measurements = 20;
        MainStack main = new MainStack();
        LOG.info("JavaStack measurements:");
        for (int i = 0; i < measurements; i++) {
            LOG.info(main.javaStack());
        }

        LOG.info("MyStack measurements:");
        for (int i = 0; i < measurements; i++) {
            LOG.info(main.myStack());
        }
    }

    public long javaStack() {
        for (int i = 0; i < array.length; i++) {
            array[i] = "Stack" + i;
        }

        Stack<String> javaStack = new Stack<>();

        long time1 = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            javaStack.push(array[i]);
        }
        long time2 = System.currentTimeMillis();
        return time2 - time1;
    }

    public long myStack() {
        for (int i = 0; i < array.length; i++) {
            array[i] = "Stack" + i;
        }

        ch.hslu.sw02.Stack myStack = new ch.hslu.sw02.Stack(size);

        long time1 = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            myStack.push(array[i]);
        }
        long time2 = System.currentTimeMillis();
        return time2 - time1;
    }
}
