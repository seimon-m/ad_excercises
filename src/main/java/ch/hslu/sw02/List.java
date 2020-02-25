package ch.hslu.sw02;

public class List {

    private Node head;

    public List() {
        this.head = new Node();
    }

    public void add(final Node obj) {
        if (this.head == null) {
            this.head = new Node(obj);
        } else {
            head.setNextNode(obj);
        }
    }

    public int size() {
        int nodeCount = 0;
        Node lastFoundNode = this.head;
        while (lastFoundNode instanceof Node) {
            nodeCount++;
            lastFoundNode = lastFoundNode.getNextNode();
        }
        return nodeCount;
    }

    public void remove() {

    }
}
