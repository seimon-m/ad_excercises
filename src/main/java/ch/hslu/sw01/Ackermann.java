package ch.hslu.sw01;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class Ackermann {

    private static final Logger LOG = LogManager.getLogger(Ackermann.class);
    private static  int i = 0;
    public static void main(final String[] args) {
        LOG.info(ack(2, 2));
        LOG.info("Anzahl Aufrufe von ack(): " + i);
    }

    public static long ack(final long n, final long m){
        i += 1;
        if(n == 0) {
            return m + 1;
        } else if (m == 0) {
            return ack(n - 1, 1);
        } else {
            return ack(n - 1, ack(n, m - 1));
        }
    }
}
