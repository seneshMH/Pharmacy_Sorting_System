public class InsertionSort {

    public Node Sort(Node head) {
        Node start = new Node();
        start.next = head;

        Node curr = head, prev = start;

        while (curr != null) {
            if (curr.next != null && (curr.next.order.distance < curr.order.distance)) {
                while (prev.next != null && (prev.next.order.distance < curr.next.order.distance)) {
                    prev = prev.next;
                }
                Node temp = prev.next;
                prev.next = curr.next;
                curr.next = curr.next.next;
                prev.next.next = temp;
                prev = start;

            } else {
                curr = curr.next;
            }
        }

        return start.next;
    }

}
