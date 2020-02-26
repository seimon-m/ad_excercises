package ch.hslu.sw02;

public class Node<Allocation> {

    private Allocation value;
    private Node nextNode;

    public Node() {
        this.value = null;
    }

    public Node(Allocation alloc) {
        this.value = alloc;
    }

    public Allocation getValue() {
        return this.value;
    }

    public boolean hasNextNode() {
        if (this.nextNode != null) {
            return true;
        } else {
            return false;
        }
    }

    public Node getNextNode() {
        return this.nextNode;
    }

    public void nextNode(final Allocation alloc) {
        this.nextNode = new Node(alloc);
    }
}
