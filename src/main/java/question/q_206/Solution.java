package question.q_206;

/**
 * Created by lenovo on 2017/10/7.
 * 初始化条件时要断干净
 */
public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node = new ListNode(2);
        head.next = node;
        System.out.println(reverseList(head));
    }

    public static ListNode reverseList(ListNode head) {
        if(head == null)
            return null;
        ListNode current = head;
        ListNode next = head.next;
        current.next = null;
        while(next != null){
            ListNode temp = next.next;
            next.next = current;
            current = next;
            next = temp;
        }
        return current;
    }

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val = x;}
    }
}
