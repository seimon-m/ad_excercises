package ch.hslu.sw02;

public class Node<T> {

    private T value;
    private Node nextNode;

    public Node() {
        this.value = null;
    }

    public Node(T obj) {
        this.value = obj;
    }

    public T getValue() {
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
        if(hasNextNode()) {
            return this.nextNode;
        } else {
            return null;
        }
    }

    public void setNextNode(final Node n) {
        this.nextNode = new Node(n);
    }
}
