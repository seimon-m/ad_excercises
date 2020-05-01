package ch.hslu.sw10_sw11;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyApp {

    private static final Logger LOG = LogManager.getLogger(MyApp.class);

    public static void main(String[] args) {
        FixedSizeHeap heap = new FixedSizeHeap(5);
        heap.insert(10);
        heap.insert(5);
        heap.insert(2);
        heap.insert(10);
        heap.insert(20);
    }
}
