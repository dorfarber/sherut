public class WarmestList {
    private Node head;
    private Node tail;

    public void addToTail(Node node) {
        if (tail == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    public void remove(Node node) {
        if (node.prev != null) node.prev.next = node.next;
        else head = node.next;

        if (node.next != null) node.next.prev = node.prev;
        else tail = node.prev;

        node.prev = node.next = null;
    }

    public void moveToTail(Node node) {
        if (tail == node) return; // already warmest
        remove(node);
        addToTail(node);
    }

    public boolean isEmpty() {
        return head == null;
    }

    public Node getTail() {
        return tail;
    }

}
