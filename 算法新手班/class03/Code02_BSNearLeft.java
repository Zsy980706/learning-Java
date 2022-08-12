package class03;

import java.util.Arrays;

/**
 * 找>=num的最左位置
 * [1,2,2,2,3,4,5,6,7,8]
 * num=2,返回arr[1]
 * arr[1,1,1,2,2,2,3,4,4,5,5,6] 0~11
 * 取t=5，arr[5]=2,取0~4中间arr[2]=1<2,t不更新
 * 取3~4，arr[3]=2>=2,t=3
 * 总的来说就是二分到死，往左砍
 */
public class Code02_BSNearLeft {

	// arr有序的，>=num 最左
	public static int mostLeftNoLessNumIndex(int[] arr, int num) {
		//判断边界条件
		if (arr == null || arr.length == 0) {
			return -1;
		}
		int L = 0;
		int R = arr.length - 1;
		int ans = -1;
		while (L <= R) {
			int mid = (L + R) / 2;
			//如果中间数大于num
			if (arr[mid] >= num) {
				//t赋值
				ans = mid;
				//右边界往左砍
				R = mid - 1;
			} else {
				//中间数小于num
				//左边界往右砍
				L = mid + 1;
			}
		}
		return ans;
	}

	// for test
	public static int test(int[] arr, int value) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= value) {
				return i;
			}
		}
		return -1;
	}

	// for test
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}

	// for test
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int testTime = 500000;
		int maxSize = 10;
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr = generateRandomArray(maxSize, maxValue);
			Arrays.sort(arr);
			int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
			if (test(arr, value) != mostLeftNoLessNumIndex(arr, value)) {
				printArray(arr);
				System.out.println(value);
				System.out.println(test(arr, value));
				System.out.println(mostLeftNoLessNumIndex(arr, value));
				succeed = false;
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");
	}

}
