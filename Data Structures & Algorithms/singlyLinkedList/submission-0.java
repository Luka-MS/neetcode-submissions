class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }
}

class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int get(int i) {
        if (i < 0 || i >= size) return -1;

        Node curr = head;
        for (int k = 0; k < i; k++) {
            curr = curr.next;
        }
        return curr.val;
    }

    public void insertHead(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;

        if (size == 0) tail = node;
        size++;
    }

    public void insertTail(int val) {
        Node node = new Node(val);

        if (size == 0) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }

        size++;
    }

    public boolean remove(int i) {
        if (i < 0 || i >= size) return false;

        if (i == 0) {
            head = head.next;
            if (size == 1) tail = null;
            size--;
            return true;
        }

        Node prev = head;
        for (int k = 0; k < i - 1; k++) {
            prev = prev.next;
        }

        Node target = prev.next;
        prev.next = target.next;

        if (target == tail) tail = prev;

        size--;
        return true;
    }

    public List<Integer> getValues() {
        List<Integer> res = new ArrayList<>();
        Node curr = head;

        while (curr != null) {
            res.add(curr.val);
            curr = curr.next;
        }

        return res;
    }
}