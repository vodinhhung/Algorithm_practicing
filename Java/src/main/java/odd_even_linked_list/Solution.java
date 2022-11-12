package odd_even_linked_list;

public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode head2 = head.next;
        ListNode prev = head;
        ListNode cur = head2;
        ListNode next = head2.next;
        int length = 0;

        while(next != null){
            length++;
            prev.next = next;
            prev = cur;
            cur = next;
            next = next.next;
        }

        if(length%2 == 0)
            prev.next = head2;
        else {
            cur.next = head2;
            prev.next = null;
        }
        return head;
    }
}
