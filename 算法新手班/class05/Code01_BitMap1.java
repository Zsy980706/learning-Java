package class05;

import java.util.HashSet;

// 这个类的实现是错误的
// 请问为什么？

/**
 * 因为 1 和 1L 的区别
 * 在左移的时候，
 * 1<<42 是错误的，因为认为1是int，只有32位
 * 1L<<42
 */
public class Code01_BitMap1 {

	public static class BitMap {

		private long[] bits;

		public BitMap(int max) {
			bits = new long[(max + 64) >> 6];
		}

		public void add(int num) {
			bits[num >> 6] |= (1 << (num & 63));
		}

		public void delete(int num) {
			bits[num >> 6] &= ~(1 << (num & 63));
		}

		public boolean contains(int num) {
			return (bits[num >> 6] & (1 << (num & 63))) != 0;
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
