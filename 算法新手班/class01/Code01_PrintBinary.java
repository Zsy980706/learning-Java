package class01;

public class Code01_PrintBinary {

	public static void print(int num) {
		for (int i = 31; i >= 0; i--) {
			System.out.print((num & (1 << i)) == 0 ? "0" : "1");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// 32位
//		int num = 4;
//
//		print(num);
//		
//		左移一位=num*2
//		int test = 1123123;
//		print(test);
//		print(test<<1);
//		print(test<<2);
//		print(test<<8);
//		
//		java中整型最大值
//		int a = Integer.MAX_VALUE;
//		System.out.println(a);
		//负数=取反+1
//		print(-1);
//		int a = Integer.MIN_VALUE;
//		print(a);
//		取反
//		int b = 123823138;
//		int c = ~b;
//		print(b);
//		print(c);

//		print(-5);

//		System.out.println(Integer.MIN_VALUE);
//		System.out.println(Integer.MAX_VALUE);

//		int a = 12319283;
//		int b = 3819283;
//		print(a);
//		print(b);
//		System.out.println("=============");
//		print(a | b);
//		print(a & b);
//		print(a ^ b);//异或

//		int a = Integer.MIN_VALUE;
//		print(a);
//		print(a >> 1);//右移一位，左侧符号位补
//		print(a >>> 1);//不带符号右移
//		相反数,但是负数最小值取反还是本身，因为取反+1又变成自己了
//		int c = Integer.MIN_VALUE;
//		int d = -c ;
//		int e = (~c +1);
//		print(c);
//		print(d);
//		print(e);

	}

}
