package question.q_142;

/**
 * Created by lenovo on 2017/10/10.
 * 链表环问题：
 *      快慢指针，快指针每次2步，慢指针每次1步，相遇停止
 * 衍生：求相遇点问题
 *      相遇后，快指针指头，和慢指针一起一步一步直至相遇
 */
public class Solution {
    public static void main(String[] args) {
        ListNode node_1 = new ListNode();
        ListNode node_2 = new ListNode();
        node_1.next = node_2;
        detectCycle(node_1);
    }

    public static ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        while(slow != fast){
            if(fast.next == null || fast.next.next == null)
                return null;
            else{
                if(fast == slow)
                    break;
                fast = fast.next.next;
                slow = slow.next;
            }
        }
        fast = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;

    }

    static class ListNode{
        ListNode next;
    }
}
