package DataStructures;

public class LinkedList {

    private class Node {

        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

    }

    private Node first;
    private Node last;
    private int size = 0;

    public void addFirst(int value) {
        Node currentNode = first;
        first = new Node(value);
        first.next = currentNode;

        if (last == null) {
            last = first;
        }

        size++;
    }

    public void addLast(int value) {
        if (first == null) {
            last = new Node(value);
            first = last;
        } else {
            last.next = new Node(value);

            last = last.next;
        }

        size++;

    }

    public int indexOf(int value) {
        return indexOf(first, value);
    }

    int index = 0;

    public int indexOf(Node node, int value) {
        if (node.value == value) {
            return index;
        } else if (node.next == null) {
            return -1;
        }

        index++;
        return indexOf(node.next, value);
    }

    public boolean contains(int value) {
        if (indexOf(value) > -1) {
            return true;
        }
        return false;
    }

    public void deleteFirst() {
        first = first.next;
    }

    public void deleteLast() {
        deleteLast(first);
        size--;
    }

    public Node deleteLast(Node node) {
        if (node.next.next == null) {
            return node;
        }

        last = deleteLast(node.next);
        last.next = null;
        return last;
    }

    public int size() {
        return size;
    }

    public int[] toArray() {
        int[] array = new int[size];
        int index = 0;
        return toArray(first, array, index);
    }

    public int[] toArray(Node node, int[] array, int index) {

        if (node == null) {
            return array; // 0 -1, 1 - 2, 2 - 3, 3 - 4
        }

        array[index++] = node.value;
        toArray(node.next, array, index);

        return array;

    }

    public void reverse() {
        // Node previous = first;
        Node newFirst = reverse(first.next, first);
        last = first;
        last.next = null;

        first = newFirst;
    }

    public Node reverse(Node node, Node previous) {

        if (node == null) {
            return previous;
        }

        Node current = node.next;
        node.next = previous;
        previous = node;
        return reverse(current, previous);

    }

    public int getKthFromEnd(int k) {
        Node slow = first;
        Node fast = first;

        for (int i = 1; i < k; i++) {
            fast = fast.next;
        }

        while (fast != last) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow.value;
    }

}
