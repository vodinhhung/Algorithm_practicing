package palindrome_linked_list;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        List<Integer> list = new ArrayList<>();
        while(head.next != null){
            list.add(head.val);
            head = head.next;
        }
        list.add(head.val);
        int[] arr = new int[list.size()];
        for(int i=0; i<arr.length; i++){
            arr[i] = list.get(i);
        }
        for(int i=0; i<arr.length/2; i++){
            if(arr[i] != arr[arr.length-1-i])
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        boolean isPalindrome = isPalindrome(head);
        System.out.println(isPalindrome);
    }
}
