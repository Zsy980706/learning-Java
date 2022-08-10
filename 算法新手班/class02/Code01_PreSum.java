package class02;

public class Code01_PreSum {

	//前缀和

	/**
	 * 给定一个数组，[3.4.2.1.6.7.8]
	 * 要对这个数组的L,R之间求和，sum（arr,L,R）
	 * 假如数组100长，但是要对这个求和操作做十亿次，那么这个优化就很有必要了
	 * 第一种方法：写出一个正方形矩阵表，
	 *  0 1 2 3 4 5 6
	 *0 3 7 9 10 16 23 31
	 *1 X 4 6  7 13 20 28
	 *2 X X 2 3  9  16 24
	 *3 X X X
	 *4 X X
	 *5 X X
	 *6 X X
	 * 以此类推
	 *
	 * 第二种方法：前缀和
	 * arr[3,2,-1,6,7,2,-2]
	 * 建一个help数组
	 * help[3,5,4,10,17,19,17]
	 * H[I] = arr[0,,,,,i]累加和
	 * sum(arr,3,7) = H[7] - H[3-1]
	 * 伪代码：
	 * L=0时   H[R]
	 * L!=0时  H[R] - H[L-1]
	 *
	 * 相比来说，在大量使用的情况下，还是启用正方形矩阵表，效率更高
	 */
	public static class RangeSum1 {

		private int[] arr;

		public RangeSum1(int[] array) {
			arr = array;
		}

		public int rangeSum(int L, int R) {
			int sum = 0;
			for (int i = L; i <= R; i++) {
				sum += arr[i];
			}
			return sum;
		}

	}

	public static class RangeSum2 {

		private int[] preSum;

		public RangeSum2(int[] array) {
			int N = array.length;
			preSum = new int[N];
			preSum[0] = array[0];
			for (int i = 1; i < N; i++) {
				preSum[i] = preSum[i - 1] + array[i];
			}
		}

		public int rangeSum(int L, int R) {
			return L == 0 ? preSum[R] : preSum[R] - preSum[L - 1];
		}

	}

}
