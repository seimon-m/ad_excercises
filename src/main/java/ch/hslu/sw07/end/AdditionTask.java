package ch.hslu.sw07.end;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AdditionTask implements Runnable {

    private static final Logger LOG = LogManager.getLogger(AdditionTask.class);

    private volatile Thread runThread;
    private volatile boolean isStopped = false;
    private int rangeBegin;
    private int rangeEnd;

    public AdditionTask(final int rangeBegin, final int rangeEnd) {
        this.rangeBegin = rangeBegin;
        this.rangeEnd = rangeEnd;
    }

    public void stopRequest() {
        isStopped = true;
        if (runThread != null) {
            runThread.interrupt();
        }
    }

    public boolean isStopped() {
        return isStopped;
    }

    @Override
    public void run() {
        this.runThread = Thread.currentThread();
        // Initialisierungsphase
        long sum = 0;
        // Arbeitsphase
        for (int i = this.rangeBegin; i <= this.rangeEnd && !isStopped; i++) {
            sum += i;
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                LOG.error(e);
                stopRequest();
            }
        }
        // Aufräumphase
        if (!isStopped()) {
            LOG.info(runThread.getName() + ": SUM" + " -> " + sum);
        } else {
            LOG.info(runThread.getName() + ": interrupted.");
        }

    }
}
