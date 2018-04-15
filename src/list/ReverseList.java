package list;

/**
 * 翻转链表，递归与非递归实现
 */
public class ReverseList {

    /**
     * 非递归实现
     */
    public static ListNode reverseNonRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }

    /**
     * 递归实现
     */
    public static ListNode reverseRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }


    public static void main(String[] args) {
        ListNode head = ListUtil.buildList(10);
        ListUtil.printList(head);
        ListUtil.printList(reverseNonRecursion(head));

        ListNode head1 = ListUtil.buildList(10);
        ListUtil.printList(head1);
        ListUtil.printList(reverseRecursion(head1));

    }
}
