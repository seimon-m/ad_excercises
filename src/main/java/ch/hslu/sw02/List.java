package ch.hslu.sw02;

import ch.hslu.sw00.Allocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class List {

    private static final Logger LOG = LogManager.getLogger(List.class);
    private Node head;
    private Node current;
    private int size = 0;

    public List() {
        this.head = null;
    }

    public boolean add(final Allocation alloc) {
        if (this.head == null) {
            this.head = new Node(alloc);
        } else {
            this.head = new Node(alloc, this.head);
        }
        this.size++;
        return true;
    }

    public int size() {
        return this.size;
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

    public Allocation getFirstElement() {
        Node oldHead = head;
        this.remove(head.getValue());
        if (oldHead.hasNextNode()) {
            this.head = head.getNextNode();
        }
        return oldHead.getValue();
    }


    public void remove(final Allocation alloc) {
        Node currentNode = head;
        Node previousNode = null;

        while(currentNode instanceof Node) {
            if (currentNode.getValue().equals(alloc)) {
                if (previousNode == null) {
                    this.head = currentNode.getNextNode();
                    //currentNode = this.head;
                } else {
                    previousNode.setNextNode(currentNode.getNextNode());
                    //currentNode = previousNode;
                }
                this.size--;
                return;
            }
            previousNode = currentNode;
            currentNode = currentNode.getNextNode();
        }
    }
}
