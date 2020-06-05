public class flatten_a_double_linked_multilevel_list {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {
        }

        public Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

    class Solution {
        public Node flatten(Node head) {
            if (head == null) {
                return head;
            }
            Node curr = head;
            while (curr != null) {
                if (curr.child == null) {
                    curr = curr.next;
                    continue;
                }
                Node childtail = curr.child;
                while (childtail.next != null) {
                    childtail = childtail.next;
                }
                Node next = curr.next;
                childtail.next = next;
                if (next != null) {
                    next.prev = childtail;
                }
                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;
                curr = curr.next;


            }
            return head;
        }
    }


}
