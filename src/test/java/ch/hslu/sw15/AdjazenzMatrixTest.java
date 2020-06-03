package ch.hslu.sw15;

import ch.hslu.sw14.Quicksearch;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AdjazenzMatrixTest {
    private static final Logger LOG = LogManager.getLogger(AdjazenzMatrixTest.class);

    @Test
    void initialTest() {
        ArrayList<String> stations = new ArrayList<>();
        stations.add("Luzern");
        stations.add("Rotkreuz");
        stations.add("Zürich");
        AdjazenzMatrix graph = new AdjazenzMatrix(stations);
        graph.printStations();
        assertEquals(3, graph.countStations());
    }

    @Test
    void addRoute() {
        ArrayList<String> stations = new ArrayList<>();
        stations.add("Luzern");
        stations.add("Rotkreuz");
        stations.add("Zürich");
        AdjazenzMatrix graph = new AdjazenzMatrix(stations);
        graph.addRoute("Rotkreuz", "Zürich", 30);
        graph.addRoute("Rotkreuz", "Luzern", 10);
        graph.addRoute("Zürich", "Luzern", 35);
        assertEquals(3, graph.countConnections());
    }

    @Test
    void addRoute2() {
        ArrayList<String> stations = new ArrayList<>();
        stations.add("Luzern");
        stations.add("Rotkreuz");
        stations.add("Zürich");
        AdjazenzMatrix graph = new AdjazenzMatrix(stations);
        graph.addRoute("Rotkreuz", "Zürich", 30);
        graph.addRoute("Rotkreuz", "Luzern", 10);
        graph.addRoute("Zürich", "Luzern", 35);
        assertEquals(false, graph.addRoute("Rotkreuz", "Zürich", 2));
    }

    @Test
    void hasRoute() {
        ArrayList<String> stations = new ArrayList<>();
        stations.add("Luzern");
        stations.add("Rotkreuz");
        stations.add("Zürich");
        AdjazenzMatrix graph = new AdjazenzMatrix(stations);
        graph.addRoute("Rotkreuz", "Zürich", 30);
        graph.addRoute("Rotkreuz", "Luzern", 10);
        assertEquals(true, graph.hasRoute("Rotkreuz", "Zürich"));
    }

    @Test
    void hasRoute2() {
        ArrayList<String> stations = new ArrayList<>();
        stations.add("Luzern");
        stations.add("Rotkreuz");
        stations.add("Zürich");
        AdjazenzMatrix graph = new AdjazenzMatrix(stations);
        graph.addRoute("Rotkreuz", "Zürich", 30);
        graph.addRoute("Rotkreuz", "Luzern", 10);
        assertEquals(true, graph.hasRoute("Zürich", "Rotkreuz"));
    }

    @Test
    void hasRoute3() {
        ArrayList<String> stations = new ArrayList<>();
        stations.add("Luzern");
        stations.add("Rotkreuz");
        stations.add("Zürich");
        AdjazenzMatrix graph = new AdjazenzMatrix(stations);
        graph.addRoute("Rotkreuz", "Zürich", 30);
        graph.addRoute("Rotkreuz", "Luzern", 10);
        assertEquals(false, graph.hasRoute("Luzern", "Zürich"));
    }

    @Test
    void getConnections() throws Exception {
        ArrayList<String> stations = new ArrayList<>();
        stations.add("Luzern");
        stations.add("Rotkreuz");
        stations.add("Zürich");
        AdjazenzMatrix graph = new AdjazenzMatrix(stations);
        graph.addRoute("Rotkreuz", "Zürich", 30);
        graph.addRoute("Rotkreuz", "Luzern", 10);
        List<String> expected = new ArrayList<>();
        expected.add("Luzern");
        expected.add("Zürich");
        assertEquals(expected, graph.getConnections("Rotkreuz"));
        LOG.debug(graph.getConnections("Rotkreuz"));
    }

    @Test
    void getDuration() {
        ArrayList<String> stations = new ArrayList<>();
        stations.add("Luzern");
        stations.add("Rotkreuz");
        stations.add("Zürich");
        AdjazenzMatrix graph = new AdjazenzMatrix(stations);
        graph.addRoute("Rotkreuz", "Zürich", 30);
        graph.addRoute("Rotkreuz", "Luzern", 10);
        assertEquals(-1, graph.getDuration("Luzern", "Zürich"));
    }

    @Test
    void getDuration2() {
        ArrayList<String> stations = new ArrayList<>();
        stations.add("Luzern");
        stations.add("Rotkreuz");
        stations.add("Zürich");
        AdjazenzMatrix graph = new AdjazenzMatrix(stations);
        graph.addRoute("Rotkreuz", "Zürich", 30);
        graph.addRoute("Rotkreuz", "Luzern", 10);
        assertEquals(30, graph.getDuration("Zürich", "Rotkreuz"));
    }

    @Test
    void removeRoute() {
        ArrayList<String> stations = new ArrayList<>();
        stations.add("Luzern");
        stations.add("Rotkreuz");
        stations.add("Zürich");
        AdjazenzMatrix graph = new AdjazenzMatrix(stations);
        graph.addRoute("Rotkreuz", "Zürich", 30);
        graph.addRoute("Rotkreuz", "Luzern", 10);
        graph.removeRoute("Zürich", "Rotkreuz");
        assertEquals(false, graph.hasRoute("Rotkreuz", "Zürich"));
    }

//    @Test
//    void addStation() {
//        ArrayList<String> stations = new ArrayList<>();
//        stations.add("Luzern");
//        stations.add("Rotkreuz");
//        stations.add("Zürich");
//        AdjazenzMatrix graph = new AdjazenzMatrix(stations);
//        graph.addRoute("Rotkreuz", "Zürich", 30);
//        graph.addRoute("Rotkreuz", "Luzern", 10);
//        graph.addStation("Hergiswil");
//        graph.printStations();
//        assertEquals(4, graph.countStations());
//    }
//
//    @Test
//    void addStation2() {
//        ArrayList<String> stations = new ArrayList<>();
//        stations.add("Luzern");
//        stations.add("Rotkreuz");
//        stations.add("Zürich");
//        AdjazenzMatrix graph = new AdjazenzMatrix(stations);
//        graph.addRoute("Rotkreuz", "Zürich", 30);
//        graph.addRoute("Rotkreuz", "Luzern", 10);
//        graph.addStation("Hergiswil");
//        graph.printStations();
//        assertEquals(true, graph.addRoute("Hergiswil", "Luzern", 9));
//    }
}
