package class03;

/**
 * 局部最小值问题，返回一个局部最小值点就行
 * 假定有一个数组，无序且任意两个相邻的数不相等
 *
 * 局部最小：
 * 1.arr[0]<arr[1] [0]局部最小
 * 2.arr[n-2]>arr[n-1] [n-1]局部最小
 * 3.左>arr[i]<右 [i]局部最小
 * 问能不能用二分法实现求出一个局部最小值
 * [.............] ↘0~mid~n-1↗
 * 如果mid-1<mid  ↗ 则必有局部最小，右边砍掉
 *
 * 越界问题：[3,2,3,2,3]
 * mid-1 越过了L左边界
 *
 * 结论：二分法不一定需要有序，只要确认某一刻有序就可以
 *
 */
public class Code04_BSAwesome {

	// arr 相邻的数不相等！
	public static int oneMinIndex(int[] arr) {
		if (arr == null || arr.length == 0) {
			return -1;
		}
		int N = arr.length;
		if (N == 1) {
			return 0;
		}
		if (arr[0] < arr[1]) {
			return 0;
		}
		if (arr[N - 1] < arr[N - 2]) {
			return N - 1;
		}
		int L = 0;
		int R = N - 1;
		// L...R 肯定有局部最小
		while (L < R - 1) {
			int mid = (L + R) / 2;
			if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
				return mid;
			} else {
				if (arr[mid] > arr[mid - 1]) {
					R = mid - 1;
				} else {
					L = mid + 1;
				}
			}
		}
		return arr[L] < arr[R] ? L : R;
	}

	// 生成随机数组，且相邻数不相等
	public static int[] randomArray(int maxLen, int maxValue) {
		int len = (int) (Math.random() * maxLen);
		int[] arr = new int[len];
		if (len > 0) {
			arr[0] = (int) (Math.random() * maxValue);
			for (int i = 1; i < len; i++) {
				do {
					arr[i] = (int) (Math.random() * maxValue);
				} while (arr[i] == arr[i - 1]);
			}
		}
		return arr;
	}

	// 也用于测试
	public static boolean check(int[] arr, int minIndex) {
		if (arr.length == 0) {
			return minIndex == -1;
		}
		int left = minIndex - 1;
		int right = minIndex + 1;
		boolean leftBigger = left >= 0 ? arr[left] > arr[minIndex] : true;
		boolean rightBigger = right < arr.length ? arr[right] > arr[minIndex] : true;
		return leftBigger && rightBigger;
	}

	public static void printArray(int[] arr) {
		for (int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int maxLen = 100;
		int maxValue = 200;
		int testTime = 1000000;
		System.out.println("测试开始");
		for (int i = 0; i < testTime; i++) {
			int[] arr = randomArray(maxLen, maxValue);
			int ans = oneMinIndex(arr);
			if (!check(arr, ans)) {
				printArray(arr);
				System.out.println(ans);
				break;
			}
		}
		System.out.println("测试结束");

	}

}
