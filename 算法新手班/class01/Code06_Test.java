package class01;

public class Code06_Test {
    /**
     * 插入排序
     * {4.3.1.2.5.2.1.6.4}
     * (0,0)有序4
     * (0,1)有序34
     * (0,2)有序341->314->134
     * (0,3)有序1342->1324->1234->前不比后大，停
     * (0,4)有序12345->前不比后大，停
     * (0,5)有序123452->前不比后大，停->122345
     */
    public static void insertionSort(int[]arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        for(int end =1;end<arr.length;end++){
            int endIndex = end;
            while(endIndex-1>=0 && arr[endIndex -1] > arr[endIndex]){
                swap(arr,endIndex-1,endIndex);
                endIndex--;
            }
        }
    }

    public static void insertionSort2(int[]arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        for(int end =1;end<arr.length;end++){
            for(int pre =end-1;pre>=0 && arr[pre]>arr[pre+1];pre--){
                swap(arr,pre,pre+1);
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
        //insertionSort(arr);
        insertionSort2(arr);
        printArray(arr);
    }
}
