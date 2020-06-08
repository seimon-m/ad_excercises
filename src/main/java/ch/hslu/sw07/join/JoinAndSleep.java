package ch.hslu.sw07.join;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JoinAndSleep implements Runnable {

    private static final Logger LOG = LogManager.getLogger(JoinAndSleep.class);

    private int sleepTime;
    private Thread thread;
    private Thread prev;

    @Override
    public void run() {
        this.thread = Thread.currentThread();

        try {
            if (this.prev != null) {
                LOG.info(this.thread.getName() + " wartet auf " + this.prev.getName());
                this.prev.join();
                LOG.info(this.thread.getName() + " schläft für " + this.sleepTime + "ms");
                Thread.sleep(this.sleepTime);

            } else {
                LOG.info(this.thread.getName() + " schläft für " + this.sleepTime + "ms");
                Thread.sleep(this.sleepTime);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (this.thread != null) {
                LOG.info(this.thread.getName() + " beendet.");
                this.thread.interrupt();
            }
        }


    }

    public static void main(String[] args) {

        JoinAndSleep join3 = new JoinAndSleep(4000, null);
        Thread t3 = new Thread(join3, "Thread 3");

        JoinAndSleep join2 = new JoinAndSleep(3000, t3);
        Thread t2 = new Thread(join2, "Thread 2");

        JoinAndSleep join1 = new JoinAndSleep(2000, t2);
        Thread t1 = new Thread(join1, "Thread 1");

        t1.start();
        t2.start();
        t3.start();

    }

    public JoinAndSleep(final int sleepTime, final Thread prev) {
        this.sleepTime = sleepTime;
        this.prev = prev;
    }
}
