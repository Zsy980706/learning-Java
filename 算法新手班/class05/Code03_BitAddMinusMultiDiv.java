package class05;

/**
 * 怎么用位运算实现加减乘除？（就是不用这些符号，实现这些功能）
 * 手写实现位运算加减乘除，不会比直接用Java加减乘除运算快
 */
// 测试链接：https://leetcode.com/problems/divide-two-integers
public class Code03_BitAddMinusMultiDiv {

	/**
	 * int a=46,int b=20
	 * 46=32+14(8+4+2)=0101110
	 * 20=16+4=0010100
	 * 中心思想是a+b=无进位+进位
	 *
	 * 异或是无进位相加
	 * 	a 0101110
	 * ^b 0010100
	 * ---------------
	 * 	  0111010  这是无进位相加的结果
	 *
	 * &
	 *  a 0101110
	 * &b 0010100
	 * ------------
	 *    0000100 <<1  --> 0001000 左移1位，是进位信息
	 * a+b = 无进位（a'）+进位（b'）
	 * 然后再计算a'+b' 以此类推到进位就是b'没了
	 * 剩下的a就是结果
	 * 这就是Java 加法的 底部实现（逻辑门）
	 *
	 * @param a
	 * @param b
	 * @return
	 */
	public static int add(int a, int b) {
		int sum = a;
		while (b != 0) {
			sum = a ^ b;
			b = (a & b) << 1;
			a = sum;
		}
		return sum;
	}

	/**
	 * a-b = a+b的相反数
	 * b的相反数 = ~b + 1 就是 b取反加一
	 * add(a,add(~b,1))
	 * @param n
	 * @return
	 */
	public static int negNum(int n) {
		return add(~n, 1);
	}

	public static int minus(int a, int b) {
		return add(a, negNum(b));
	}

	/**
	 * a*b
	 * 				a	0	1	1	0
	 * 			   *b	0	1	1	1
	 * 			   -------------------
	 * 			   		0	1	1	0
	 * 			   	0	1	1	0
	 * 			0	1	1	0
	 * 		0	0	0	0
	 * 	-------------------------------------
	 * 		0	1	0	1	0	1	0
	 * 	6*7=42
	 * 	ans = 0110 + 01100 + 011000 + 0 = 0101010
	 * @param a
	 * @param b
	 * @return
	 */
	public static int multi(int a, int b) {
		int res = 0;
		while (b != 0) {
			if ((b & 1) != 0) {
				res = add(res, a);
			}
			a <<= 1;
			b >>>= 1;
		}
		return res;
	}

	/**
	 * 除法 a/b
	 * 正数/正数   a/b = c ,c也是二进制组成，就是如果C=0110，
	 *           那么c = 0*2^0 + 1*2^1 + 1*2^2 + 0*2^3
	 *           那么可以推出 a = b*c = b*2^1 + b*2^2
	 *           那么如果是去推断商？，可以用 c - b*2^? - b*2^?.....
	 *           一直到全减完，b*2^? + b*2^?.....就是商
	 * 假设商是a
	 * a >= b*2^? if ?=7
	 * a-b*2^7 = a'
	 * a'>=b*2^5
	 * a'-b*2^5 = a''
	 * a=a'+a''+.....
	 * 代码层面来说
	 * a 01101100
	 * b 00000011
	 * b<<5=01100000
	 * 满足条件 a >=b
	 * 所以 a'=a - b*2^5 = 00001100
	 * b<<2 = 00001100 a>=b
	 * 此时 a' - b*2^2 =0
	 * 所以 a= 100000+100=100100
	 * 总的来说就是  108/3 = 36
	 * =================================
	 * 如果X很大，接近符号位了
	 * X 正 0（符号位）1100000
	 * Y 正 00000011 但是上面的做法是Y左移找X，在X这么大的情况下，Y可能会左移到符号位，
	 * 				那么就改变了Y的正负，出现BUG
	 * 所以让X找Y，避险，右移不涉及符号位
	 * -18/3 --> 18/3=6-->加负号-->-6
	 * -18/-3 --> 18/3=6-->走人
	 * 举例：22/7
	 * a 010110
	 * b 000111
	 * 从a>>30位开始比较。。。。。。。。
	 * a>>2=000101,a<b,所以ans[2]=0
	 * a>>1=001011,a>+b,所以ans[1]=1
	 * 所以 a' = a-b左移一位=010110-001110=001000
	 * a' 001000
	 * b  000111 a>>0 a-b=1 余数
	 * a>>0 a>b 所以ans[0]=1
	 * 所以ans=011=3余1
	 * =======================================
	 * a/b --> |a|/|b|=?
	 * 怎么解决系统最小值转绝对值？加工
	 * 分情况讨论：
	 * 1.a系统最小值，b系统最小值 反1
	 * 2.a不是系统最小值，b系统最小值，反0
	 * 3.a系统最小值，b不是系统最小值，怎么办？重点讨论
	 * 4.a不是系统最小值，b不是系统最小值，已实现
	 *
	 * 开始讨论：
	 * 假设系统最小值：-10~9
	 * -10/2=-10+1/2=-9/2=-4
	 * 假设系统最小值：-15~14
	 * -15/3=-14/3=-4，
	 * -4*3=-12，->-3,-3/3==1
	 * -1+-4=-5
	 * =====================
	 * if a min ,but b=-1
	 * return max,正常应该是max+1,但是leetcode与欸的那个的是max
	 * else
	 * a/b
	 * a+1/b=c
	 * a-(b*c)=d
	 * d/b=e
	 * c+e
	 * @param n
	 * @return
	 */
	public static boolean isNeg(int n) {
		return n < 0;
	}

	public static int div(int a, int b) {
		int x = isNeg(a) ? negNum(a) : a;
		int y = isNeg(b) ? negNum(b) : b;
		int res = 0;
		for (int i = 30; i >= 0; i = minus(i, 1)) {
			if ((x >> i) >= y) {
				res |= (1 << i);
				x = minus(x, y << i);
			}
		}
		return isNeg(a) ^ isNeg(b) ? negNum(res) : res;
	}

	public static int divide(int a, int b) {
		if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
			return 1;
		} else if (b == Integer.MIN_VALUE) {
			return 0;
		} else if (a == Integer.MIN_VALUE) {
			if (b == negNum(1)) {
				return Integer.MAX_VALUE;
			} else {
				int c = div(add(a, 1), b);
				return add(c, div(minus(a, multi(c, b)), b));
			}
		} else {
			return div(a, b);
		}
	}

}
