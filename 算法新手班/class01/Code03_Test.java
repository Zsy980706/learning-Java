package class01;

public class Code03_Test {
    /**
     * 选择排序
     * {x,5,7,3}
     * 先选出最小的，(0,N-1)最小的放在0，(1,N-1)最小的放在1，
     * 你比我小，咱俩换
     */

    public static void selectionSort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        for(int i=0;i<arr.length-1;i++){//循环到倒数第二个
            int minIndex = i;
            for(int j =i+1;j<arr.length;j++){//循环到倒数第一个
                if(arr[j]<arr[minIndex]){
                    minIndex = j;
                }
            }
            swap(arr,i,minIndex);
        }
    }

    public static void swap(int[] arr,int i,int j ){
        int tep=arr[i];
        arr[i] = arr[j];
        arr[j] = tep;
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
        selectionSort(arr);
        printArray(arr);
    }

}
