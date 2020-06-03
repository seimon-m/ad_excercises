package ch.hslu.sw15;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdjazenzListenTest {

    @Test
    void addStation() {
        AdjazenzListen g = new AdjazenzListen();
        g.addStation(new Node("Rotkreuz"));
        assertEquals(true, g.addStation(new Node("Luzern")));
    }

}