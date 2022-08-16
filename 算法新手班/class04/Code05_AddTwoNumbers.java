package class04;

/**
 * 两个链表相加
 * 	3-->	4-->	6-->	1-->
 * 	7-->	9-->	7-->
 * 	1643+797=2440
 * 	第一步，先找长短链表
 * 	L：3-->	4-->	6-->	1-->
 * 	S：7-->	9-->	7-->
 * 	三个阶段：初始化进位=0
 * 	①L有S有：3+7=0+进位1
 * 			 4+9+进位1=4+进位1
 * 			 6+9+进位1=6+进位1
 * 	②L有S无：1+进位1=2
 * 	③L无S无：返回2440
 * 	last是最后一个不为空的节点，为了放L比S长时，进1时没地方存的值
 */
// 测试链接：https://leetcode.com/problems/add-two-numbers/
public class Code05_AddTwoNumbers {

	// 不要提交这个类
	public static class ListNode {
		public int val;
		public ListNode next;

		public ListNode(int val) {
			this.val = val;
		}

		public ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static ListNode addTwoNumbers(ListNode head1, ListNode head2) {
		int len1 = listLength(head1);
		int len2 = listLength(head2);
		ListNode l = len1 >= len2 ? head1 : head2;
		ListNode s = l == head1 ? head2 : head1;
		ListNode curL = l;
		ListNode curS = s;
		ListNode last = curL;
		int carry = 0;
		int curNum = 0;
		while (curS != null) {
			curNum = curL.val + curS.val + carry;
			curL.val = (curNum % 10);
			carry = curNum / 10;
			last = curL;
			curL = curL.next;
			curS = curS.next;
		}
		while (curL != null) {
			curNum = curL.val + carry;
			curL.val = (curNum % 10);
			carry = curNum / 10;
			last = curL;
			curL = curL.next;
		}
		if (carry != 0) {
			last.next = new ListNode(1);
		}
		return l;
	}

	// 求链表长度
	public static int listLength(ListNode head) {
		int len = 0;
		while (head != null) {
			len++;
			head = head.next;
		}
		return len;
	}

}
