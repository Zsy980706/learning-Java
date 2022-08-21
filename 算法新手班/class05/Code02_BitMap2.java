package class05;

import java.util.HashSet;

/**
 * 位图（位图比hash表至少节省32位空间）
 * int a = 0 ;
 * int 4字节（byte） = 32 位（bits）
 * 所以，a可以表示0~31 32个数
 * 在hashset中，表示32个数需要 32*4 个字节，而用位图只需要4字节
 *
 * 想表示0~1023
 * int[32] 因为32*32 = 1024
 *
 * 好处：极大压缩空间
 * long[] 64bits 可以表示64个数
 */
public class Code02_BitMap2 {

	/**
	 * 向位图增加、删除，查找某个值
	 */
	// 这个类的实现是正确的
	public static class BitMap {

		private long[] bits;

		/**
		 * max+64/64 准备几个边界
		 * @param max
		 */
		public BitMap(int max) {
			bits = new long[(max + 64) >> 6];
		}

		/**
		 * 170/64=第几个64
		 * 170%64=64里面的第几个
		 * num%64 = num & 63
		 * Java加减乘除取余运算比位运算（左移右移异或^）慢了10倍往上
		 *
		 * num>>6 = num/64 哪个整数
		 * 170/64 = 2  arr[0] arr[1] arr[3]第三个64
		 * 170%64=42  arr[2].42  把这个位置置1
		 * 这个1是怎么进去的？ 或进去的  （1<<42）把1或进arr[2]
		 * '|=' 这个符号是或等于
		 *
		 */
		public void add(int num) {
			bits[num >> 6] |= (1L << (num & 63));
		}

		/**
		 * 举例，要删除170，
		 * arr[2].42=0,置0，
		 * 怎么置0？ &
		 * 1	0	1	1	0	1	1	0	1	1
		 * 1	1	1	1	1	1	0	1	1	1 &上
		 * 1111110111怎么来的？0000001000取反来的
		 * @param num
		 */
		public void delete(int num) {
			bits[num >> 6] &= ~(1L << (num & 63));
		}

		/**
		 * 查询位置
		 * 查42位置1存在0不存在，&只有42位是1的数，结果不等于0，是1存在
		 * 									   结果等于0，是0不存在
		 * @param num
		 * @return
		 */
		public boolean contains(int num) {
			return (bits[num >> 6] & (1L << (num & 63))) != 0;
		}

	}

	public static void main(String[] args) {
		System.out.println("测试开始！");
		int max = 10000;
		BitMap bitMap = new BitMap(max);
		HashSet<Integer> set = new HashSet<>();
		int testTime = 10000000;
		for (int i = 0; i < testTime; i++) {
			int num = (int) (Math.random() * (max + 1));
			double decide = Math.random();
			if (decide < 0.333) {
				bitMap.add(num);
				set.add(num);
			} else if (decide < 0.666) {
				bitMap.delete(num);
				set.remove(num);
			} else {
				if (bitMap.contains(num) != set.contains(num)) {
					System.out.println("Oops!");
					break;
				}
			}
		}
		for (int num = 0; num <= max; num++) {
			if (bitMap.contains(num) != set.contains(num)) {
				System.out.println("Oops!");
			}
		}
		System.out.println("测试结束！");
	}

}
