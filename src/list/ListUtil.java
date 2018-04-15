package list;


/**
 * 链表相关工具类
 */
public class ListUtil {

    /**
     * 构建链表
     *
     * @param n 链表尾节点，1-n
     * @return 链表
     */
    public static ListNode buildList(int n) {
        ListNode head = new ListNode(0);
        ListNode curNode = head;
        for (int i = 1; i <= n; i++) {
            curNode.next = new ListNode(i);
            curNode = curNode.next;
        }
        return head.next;
    }

    /**
     * 输出链表的值
     *
     * @param head 链表头结点
     */
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        printList(buildList(10));
    }
}
