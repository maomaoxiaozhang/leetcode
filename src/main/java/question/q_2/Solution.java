package question.q_2;

import java.util.Scanner;

/**
 * Created by lenovo on 2017/10/2.
 * 分析多种情况，立flag记录是否进位
 * notice：可在链表头部建立头指针
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            ListNode l1 = new ListNode(0);
            ListNode temp = l1;
            for (int i = 1; i < n; i++){
                ListNode node = new ListNode(scanner.nextInt());
                temp.next = node;
                temp = node;
            }
            n = scanner.nextInt();
            ListNode l2 = new ListNode(0);
            temp = l2;
            for (int i = 1; i < n; i++){
                ListNode node = new ListNode(scanner.nextInt());
                temp.next = node;
                temp = node;
            }
            ListNode result = addTwoNumbers(l1.next, l2.next);
            while (result != null){
                System.out.print(result.val + "\t");
                result = result.next;
            }
        }
    }

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val = x;}
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode result = new ListNode(0);
        ListNode temp = result;
        int flag = 0;
        while (l1 != null && l2 != null){
            int val = (l1.val + l2.val + flag)%10;
            ListNode node = new ListNode(val);
            temp.next = node;
            temp = node;
            flag = (l1.val + l2.val + flag)/10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null){
            int val = (l1.val + flag)%10;
            ListNode node = new ListNode(val);
            temp.next = node;
            temp = node;
            flag = (l1.val+flag)/10;
            l1 = l1.next;
        }
        while (l2 != null){
            int val = (l2.val + flag)%10;
            ListNode node = new ListNode(val);
            temp.next = node;
            temp = node;
            flag = (l2.val + flag)/10;
            l2 = l2.next;
        }
        if (flag == 1){
            ListNode node = new ListNode(1);
            temp.next = node;
        }
        return result;
    }
}
