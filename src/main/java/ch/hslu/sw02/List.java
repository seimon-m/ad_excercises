package ch.hslu.sw02;

public class List<Allocation> {

    private Node head;
    private Node current;

    public List() {
        this.head = null;
    }

    public boolean add(final Allocation alloc) {
        if (this.head == null) {
            this.head = new Node(alloc);
        } else {
            Node newHead = new Node(alloc);
            newHead.nextNode(head);
            this.head = newHead;
            return true;
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

    public boolean contains(final Allocation alloc) {
        this.current = head;
        while(current instanceof Node) {
            if (current.getValue().equals(alloc)) {
                return true;
            }
            current = current.getNextNode();
        }
        return false;
    }

    public Node getFirstElement() {
        Node oldHead = head;
        this.head = head.getNextNode();
        //remove(head.getValue());
        return oldHead;
    }


    public void remove(final Allocation alloc) {
        Node currentNode = head;
        Node previousNode = null;

        while(currentNode instanceof Node) {
            if (currentNode.getValue().equals(alloc)) {
                if (previousNode == null) {
                    this.head = currentNode.getNextNode();
                    currentNode = this.head;
                } else {
                    previousNode.nextNode(currentNode.getNextNode());
                    currentNode = previousNode;
                }
            }
            previousNode = currentNode;
            currentNode = currentNode.getNextNode();
        }
    }
}
