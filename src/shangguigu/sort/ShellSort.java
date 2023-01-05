package shangguigu.sort;

import java.util.Arrays;

/**
 * @BelongsProject: suanfa
 * @BelongsPackage: shangguigu.sort
 * @Author: GuoJHao
 * @CreateTime: 2022-12-31  21:23
 * @Description: TODO
 * @Version: 1.0
 */
public class ShellSort {
    public static void main(String[] args) {
//        int[] arr = new int[]{8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
//            Math.random()随机生成0-1的随机数
            arr[i] = (int) (Math.random() * 8000000);
        }
        System.out.println(Arrays.toString(arr));
        long time1 = System.currentTimeMillis();
        shellSort2(arr);
        long time2 = System.currentTimeMillis();
        System.out.println(Arrays.toString(arr));
        System.out.println(time2 - time1);//21ms
    }
    /**
     * @description:交换法
     * @author: GuoJHao
     * @date: 2022/12/31 22:41
     * @param: [arr]
     * @return: void
     **/
    public static void shellSort(int[] arr) {
        int temp = 0;
        int count = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
//            System.out.println("希尔排序第"+(++count)+"轮后="+ Arrays.toString(arr));
        }
    }


    /**
     * @description:位移法
     * @author: GuoJHao
     * @date: 2022/12/31 22:41
     * @param: [arr]
     * @return: void
     **/
    public static void shellSort2(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
//            System.out.println("希尔排序第"+(++count)+"轮后="+ Arrays.toString(arr));
        }
    }
}
