package question.q_21;

import java.util.Scanner;

/**
 * Created by lenovo on 2017/10/3.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            ListNode l1 = new ListNode(0);
            ListNode temp = l1;
            while (n > 0){
                ListNode node = new ListNode(scanner.nextInt());
                temp.next = node;
                temp = node;
                n--;
            }
            n = scanner.nextInt();
            ListNode l2 = new ListNode(0);
            temp = l2;
            while (n > 0){
                ListNode node = new ListNode(scanner.nextInt());
                temp.next = node;
                temp = node;
                n--;
            }
            ListNode root = mergeTwoLists(l1.next, l2.next);
            while (root != null){
                System.out.print(root.val + "\t");
                root = root.next;
            }
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode root = new ListNode(0);
        ListNode temp = root;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                temp.next = l1;
                temp = l1;
                l1 = l1.next;
            }else {
                temp.next = l2;
                temp = l2;
                l2 = l2.next;
            }
        }
        if (l1 != null)
            temp.next = l1;
        else
            temp.next = l2;
        return root.next;
    }

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){ val = x;}
    }
}
