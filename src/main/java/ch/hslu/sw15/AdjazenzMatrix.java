package ch.hslu.sw15;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// TODO: Add and remove Stations

public class AdjazenzMatrix {
    private static final Logger LOG = LogManager.getLogger(AdjazenzMatrix.class);
    private ArrayList<String> stations;
    private int[][] matrix;

    AdjazenzMatrix(final ArrayList<String> nodes) {
        this.stations = nodes;
        int n = stations.size();
        matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.MAX_VALUE;
            }
        }
    }

//    public boolean addStation(final String station) {
//        LOG.debug("Old:");
//        printMatrix();
//        matrix[] = matrix[Arrays.copyOf(matrix,matrix.length + 1]));
//        LOG.debug("Lenght: " + matrix.length);
//        LOG.debug("New:");
//        printMatrix();
//        return stations.add(station);
//
//        for (int i = 0; i < matrix.length; i++) {
//
//            for (int j = 0; j < matrix.length; j++) {
//
//            }
//        }
//    }

//    public boolean removeStation(final String station) {
//        return nodes.remove(station);
//    }

    public int countStations() {
        return stations.size();
    }

    public int countConnections() {
        int counter = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] != Integer.MAX_VALUE) {
                    counter++;
                }
            }
        }
        return counter / 2;
    }

    public boolean addRoute(final String _a, final String _b, final int duration) {
        if (stations.contains(_a) && stations.contains(_b)) {
            int a = stations.indexOf(_a);
            int b = stations.indexOf(_b);
            if (matrix[a][b] == Integer.MAX_VALUE && matrix[b][a] == Integer.MAX_VALUE) {
                this.matrix[a][b] = duration;
                this.matrix[b][a] = duration;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean removeRoute(final String _a, final String _b) {
        if (stations.contains(_a) && stations.contains(_b)) {
            int a = stations.indexOf(_a);
            int b = stations.indexOf(_b);
            if (matrix[a][b] != Integer.MAX_VALUE && matrix[b][a] != Integer.MAX_VALUE) {
                this.matrix[a][b] = Integer.MAX_VALUE;
                this.matrix[b][a] = Integer.MAX_VALUE;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean hasRoute(final String _a, final String _b) {
        if (stations.contains(_a) && stations.contains(_b)) {
            int a = stations.indexOf(_a);
            int b = stations.indexOf(_b);
            if (matrix[a][b] != Integer.MAX_VALUE || matrix[b][a] != Integer.MAX_VALUE) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public int getDuration(final String _a, final String _b) {
        if (hasRoute(_a, _b)) {
            int a = stations.indexOf(_a);
            int b = stations.indexOf(_b);
            return matrix[a][b];
        } else {
            return -1;
        }
    }

    public List<String> getConnections(final String _a) throws Exception {
        if (stations.contains(_a)) {
            List<String> connectedStations = new ArrayList<>();
            for (String station : stations) {
                if (hasRoute(_a, station)) {
                    connectedStations.add(station);
                }
            }
            return connectedStations;
        } else {
            throw new Exception("No such station");
        }
    }

    public void printStations() {
        stations.forEach(station -> LOG.debug(station));
    }

    public void printMatrix() {
        LOG.debug(Arrays.deepToString(matrix).replace("], ", "]\n \t\t\t\t\t\t\t\t"));
    }
}
