package shangguigu.sort;

import java.util.Arrays;

/**
 * @BelongsProject: suanfa
 * @BelongsPackage: shangguigu.sort
 * @Author: GuoJHao
 * @CreateTime: 2023-01-01  22:30
 * @Description: TODO
 * @Version: 1.0
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];
//        int[] arr = new int[]{5,7,1,9,3};
        for (int i = 0; i < 80000; i++) {
//            Math.random()随机生成0-1的随机数
            arr[i] = (int) (Math.random() * 8000000);
        }
        System.out.println(Arrays.toString(arr));
        long time1 = System.currentTimeMillis();
        quickSort(arr, 0, arr.length - 1);
        long time2 = System.currentTimeMillis();
        System.out.println(Arrays.toString(arr));
        System.out.println(time2 - time1);//22ms
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            //把数组第0个数字作为标准数
            int stard = arr[start];
            //记录需要排序的下标
            int low = start;
            int high = end;

            while (low < high) {
                while (low < high && arr[high] >= stard) {
                    high--;
                }
                arr[low] = arr[high];
                while (low < high && arr[low] <= stard) {
                    low++;
                }
                arr[high] = arr[low];
            }
            arr[low] = stard;
            quickSort(arr, start, low);
            quickSort(arr, low + 1, end);
        }
    }
}
