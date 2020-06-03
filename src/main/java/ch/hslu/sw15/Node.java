package ch.hslu.sw15;

public class Node {
    private String name;

    public Node(final String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(final Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Node)) {
            return false;
        }
        final Node other = (Node) object;
        return this.name.equals(object);
    }
}
