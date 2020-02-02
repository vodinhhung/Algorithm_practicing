package odd_even_linked_list;

public class Main {
    public static void main(String[] args){
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4=  new ListNode(5);
        ListNode node5 = new ListNode(6);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        head = solution.oddEvenList(head);
        while(head != null){
            System.out.print(head.val);
            head = head.next;
        }
    }
}
