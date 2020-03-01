package ch.hslu.sw02;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainStack {

    private static final Logger LOG = LogManager.getLogger(MainStack.class);

    public static void main(String[] args) {
        Stack stack = new Stack(3);
        stack.push("toll");
        stack.push("sind");
        stack.push("Datenstrukturen");

        LOG.info(stack.pop());
        LOG.info(stack.pop());
        LOG.info(stack.pop());
    }
}
