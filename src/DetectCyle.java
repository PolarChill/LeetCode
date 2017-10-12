import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Polar on 2017/7/18.
 */
public class DetectCyle {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if(slow == fast){
                while (head != slow) {
                    head = head.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;

    }
    @Test
    public void f1() {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
//        listNode.next.next = new ListNode(3);
//        listNode.next.next.next = new ListNode(4);
//        listNode.next.next.next.next = new ListNode(5);
//        listNode.next.next.next.next.next = new ListNode(6);
//        listNode.next.next.next.next.next.next = new ListNode(7);
//        listNode.next.next.next.next.next.next.next = new ListNode(8);
//        listNode.next.next.next.next.next.next.next.next = listNode.next.next;

        DetectCyle cyle = new DetectCyle();
        ListNode node = cyle.detectCycle(listNode);
        if(node != null) {
            System.out.println(node.val);
        }
        System.out.println(node);

       /* Set<ListNode> set = new HashSet<>();
        while(listNode != null) {
            if(set.contains(listNode)) {
                System.out.print(listNode.val);
                break;
            }
            set.add(listNode);
            listNode = listNode.next;

        }*/
    }


}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
