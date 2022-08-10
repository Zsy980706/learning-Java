package class01;

public class Code05_Test {
    /**
     * 冒泡排序
     * {1，5，2，4，7，6}
     * (0,1)比较，大的在后面
     * (1,2)比较，大的在后面
     * 前比后大，交换，最后就是(0,N-1),(0,N-2),(0,N-3)
     */
    public static void bubbleSort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        for(int end = arr.length-1;end>0;end--){
            for(int i=0;i<end;i++){
                if(arr[i]>arr[i+1]){
                    swap(arr,i,i+1);
                }
            }
        }
    }



    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

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
        int[] arr = { 7, 1, 3, 5, 1, 6, 8, 1, 3, 5, 7, 5, 6 };
        printArray(arr);
        bubbleSort(arr);
        printArray(arr);
    }
}
