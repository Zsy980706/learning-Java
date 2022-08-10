package class02;

public class Code01_PreSum {

	//ǰ׺��

	/**
	 * ����һ�����飬[3.4.2.1.6.7.8]
	 * Ҫ����������L,R֮����ͣ�sum��arr,L,R��
	 * ��������100��������Ҫ�������Ͳ�����ʮ�ڴΣ���ô����Ż��ͺ��б�Ҫ��
	 * ��һ�ַ�����д��һ�������ξ����
	 *  0 1 2 3 4 5 6
	 *0 3 7 9 10 16 23 31
	 *1 X 4 6  7 13 20 28
	 *2 X X 2 3  9  16 24
	 *3 X X X
	 *4 X X
	 *5 X X
	 *6 X X
	 * �Դ�����
	 *
	 * �ڶ��ַ�����ǰ׺��
	 * arr[3,2,-1,6,7,2,-2]
	 * ��һ��help����
	 * help[3,5,4,10,17,19,17]
	 * H[I] = arr[0,,,,,i]�ۼӺ�
	 * sum(arr,3,7) = H[7] - H[3-1]
	 * α���룺
	 * L=0ʱ   H[R]
	 * L!=0ʱ  H[R] - H[L-1]
	 *
	 * �����˵���ڴ���ʹ�õ�����£��������������ξ����Ч�ʸ���
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
