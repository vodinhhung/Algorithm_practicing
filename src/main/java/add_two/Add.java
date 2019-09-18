package add_two;

public class Add {

    public ListNode insertNewNode(ListNode ln) {
        ListNode newNode = new ListNode(0);
        ln.next = newNode;
        return newNode;
    }

    public int lengthLinkedList(ListNode head){
        int length = 0;
        if (head == null)
            length = 0;
        else
            length = 1;

        while(head.next != null){
            length++;
            head = head.next;
        }
        return length;
    }

    public void addExtraNodes(ListNode head, int n){
        while(head.next != null){
            head = head.next;
        }

        int length = lengthLinkedList(head);
        int delta = n - length;

        while(delta>0){
            head = insertNewNode(head);
            delta--;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode l3 = head;
        int rem = 0;

        int length1 = lengthLinkedList(l1);
        int length2 = lengthLinkedList(l2);

        if(length1 > length2){
            addExtraNodes(l2, length1);
        } else {
            addExtraNodes(l1, length2);
        }

        while(l1.next != null && l2.next != null){

            if(l1.val+l2.val+rem < 10) {
                l3.val = l1.val+l2.val+rem;
                rem = 0;
                l1 = l1.next;
                l2 = l2.next;
                l3 = insertNewNode(l3);
            } else {
                l3.val = l1.val+l2.val+rem-10;
                rem = 1;
                l1 = l1.next;
                l2 = l2.next;
                l3 = insertNewNode(l3);
            }
        }

        if(l1.val+l2.val+rem < 10) {
            l3.val = l1.val+l2.val+rem;
        } else {
            l3.val = l1.val+l2.val+rem-10;
            l3 = insertNewNode(l3);
            l3.val = 1;
        }

        return head;
    }
}
