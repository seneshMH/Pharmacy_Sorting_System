public class BubbleSort {

    public Node Sort(Node head) {
        Node header = head;
        boolean isChanged = true;

        if (head != null && head.next != null) {

        
            while (isChanged) {
                Node prevNode = null;
                Node current = header;
                Node nextNode = current.next;
                isChanged = false;
                while (current.next != null) {
                    if (current.order.distance > nextNode.order.distance) {
                        if (header == current) {
                            header = nextNode;
                        } else {
                            prevNode.next =  nextNode;
                        }
                        current.next = nextNode.next;
                        nextNode.next = current;
                        isChanged = true;
                        current = nextNode;
                    }
                    prevNode = current;
                    current = prevNode.next;
                    nextNode = current.next;
                }
            }

        }
        return header;
    }

}
