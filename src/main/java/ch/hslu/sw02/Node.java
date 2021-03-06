package ch.hslu.sw02;
import ch.hslu.sw00.Allocation;

import java.util.Objects;

public class Node {

    private Allocation value;
    private Node nextNode;

    public Node(Allocation alloc) {
        this.value = alloc;
    }

    public Node(Allocation alloc, Node nextNode) {
        this.value = alloc;
        this.nextNode = nextNode;
    }

    public Allocation getValue() {
        return this.value;
    }

    public boolean hasNextNode() {
        return this.nextNode != null;
    }

    public Node getNextNode() {
        return this.nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public final boolean equals(Object obj){
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Node)) {
            return false;
        }
        final Node other = (Node) obj;
        return this.value == other.value && this.nextNode == other.nextNode;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(this.value, this.nextNode);
    }
}
