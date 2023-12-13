public class LinkList {
    Node head;

    public void insert(Order order) {
        Node node = new Node();
        node.order = order;
        node.next = null;

        if (head == null) {
            head = node;
        } else {
            Node n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = node;
        }
    }

    public void deleteAt(int index) {
        if (index == 0) {
            head = head.next;
        } else {
            Node n = head;
            Node temp = null;

            for (int i = 0; i < index - 1; i++) {
                n = n.next;
            }

            temp = n.next;
            n.next = temp.next;
            temp = null;
        }
    }

    public Order Traverse(int index) {
        Node node = head;

        for (int i = 0; i < index; i++) {
            if(node!=null){
                node = node.next;
            }  
        }

        if(node != null){
            return node.order;
        }

        return null;
    }

}
