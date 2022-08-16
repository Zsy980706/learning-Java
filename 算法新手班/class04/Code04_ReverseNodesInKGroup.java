

package class04;

/**
 * K个节点组内逆序调整
 * 1 2 3 4 5 6 7 8 ,int k = 3>0,head指向1
 * 3 2 1 6 5 4 7 8 ,head指向3
 * =====
 * a...b c...d e...f
 * 		||
 * 	    ||逆序调整之后
 * 	    ||
 * b...a d...c f...e
 * 变成a的next指针指向d，c的next指针指向f
 *
 */
// 测试链接：https://leetcode.com/problems/reverse-nodes-in-k-group/
public class Code04_ReverseNodesInKGroup {

	// 不要提交这个类
	public static class ListNode {
		public int val;
		public ListNode next;
	}

	public static ListNode reverseKGroup(ListNode head, int k) {
		ListNode start = head;
		ListNode end = getKGroupEnd(start, k);
		if (end == null) {
			return head;
		}
		// 第一组凑齐了！
		head = end;
		reverse(start, end);
		// 上一组的结尾节点
		ListNode lastEnd = start;
		while (lastEnd.next != null) {
			start = lastEnd.next;
			end = getKGroupEnd(start, k);
			if (end == null) {
				return head;
			}
			reverse(start, end);
			lastEnd.next = end;
			lastEnd = start;
		}
		return head;
	}

	/**
	 * 得到一组k个的最后一个
	 * f(x,k)=d,k=5
	 * k4	3	2	1	0
	 * 	x	a	b	c	d
	 * 	1	2	3	4	5
	 * @param start
	 * @param k
	 * @return
	 */
	public static ListNode getKGroupEnd(ListNode start, int k) {
		while (--k != 0 && start != null) {
			start = start.next;
		}
		return start;
	}

	/**
	 *
	 * 	s-->	a-->	b-->	c-->	e-->
	 * 	换序，变成	c-->	b-->	a-->	s-->	e-->
	 * 	end=e,cur=s,
	 * 	cur不为空
	 * 	①next=a，s的next指针指向pre(null)，pre挪到s(cur)，cur挪到a(next)
	 *
	 * 一顿循环之后，s的next指针指向e，完事！！！
	 * @param start
	 * @param end
	 */
	public static void reverse(ListNode start, ListNode end) {
		end = end.next;
		ListNode pre = null;
		ListNode cur = start;
		ListNode next = null;
		while (cur != end) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		start.next = end;
	}

}