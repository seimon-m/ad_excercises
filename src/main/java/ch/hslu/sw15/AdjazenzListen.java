package ch.hslu.sw15;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AdjazenzListen {
    private final Map<Node, Set<Node>> map;

    public AdjazenzListen() {
        map = new HashMap<>();
    }

    public boolean addStation(final Node node) {
        if (!isNodeInGraph(node)) {
            map.put(node, new HashSet<>());
            return true;
        } else {
            return false;
        }
    }

    public boolean isNodeInGraph(final Node node) {
        return map.containsKey(node);
    }
}
