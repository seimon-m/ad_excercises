package ch.hslu.sw02;

public class List<Allocation> {

    private Node head;

    public List() {
        this.head = null;
    }

    public boolean add(final Allocation alloc) {
        if (this.head == null) {
            this.head = new Node(alloc);
        } else {
            head.nextNode(alloc);
        }
        return true;
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
