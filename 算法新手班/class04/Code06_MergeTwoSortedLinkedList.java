package class04;

/**
 * 两个有序链表合并
 * 13357
 * 22337
 * 122333357
 *
 * 例子：
 * 	1-->	5-->	7-->
 * 	2-->	6-->	9-->
 * 	①确认head节点（谁头节点值小就是谁）
 * 	（head）1-->	5-->	7-->
 * 		   2-->	6-->	9-->
 * 	②cur1设定为head的下一个节点，cur2就是另一边的第一个节点呗
 * 	（head）1-->	（cur1）5-->	7-->
 * 	(cur2)2-->	6-->	9-->
 * 	pre指向头节点就是最小的那个节点
 * 	③cur1 cur2谁小，pre往下动到谁身上，同时pre动之前节点的next 指针也指向下个节点
 *
 */
// 测试链接：https://leetcode.com/problems/merge-two-sorted-lists
public class Code06_MergeTwoSortedLinkedList {

	// 不要提交这个类
	public static class ListNode {
		public int val;
		public ListNode next;
	}

	public static ListNode mergeTwoLists(ListNode head1, ListNode head2) {
		if (head1 == null || head2 == null) {
			return head1 == null ? head2 : head1;
		}
		ListNode head = head1.val <= head2.val ? head1 : head2;
		ListNode cur1 = head.next;
		ListNode cur2 = head == head1 ? head2 : head1;
		ListNode pre = head;
		while (cur1 != null && cur2 != null) {
			if (cur1.val <= cur2.val) {
				pre.next = cur1;
				cur1 = cur1.next;
			} else {
				pre.next = cur2;
				cur2 = cur2.next;
			}
			pre = pre.next;
		}
		pre.next = cur1 != null ? cur1 : cur2;
		return head;
	}

}
