package ch.hslu.sw00;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MemoryDemo {

    private static final Logger LOG = LogManager.getLogger(MemoryDemo.class);

    public static void main(final String[] args) {
        final Memory memory = new MemorySimple(1024);
        LOG.info(memory);
        final Allocation block1 = memory.malloc(16);
        LOG.info(block1);
        LOG.info(memory);
        final Allocation block2 = memory.malloc(8);
        LOG.info(block2); LOG.info(memory);
        memory.free(block1);

    }
}
