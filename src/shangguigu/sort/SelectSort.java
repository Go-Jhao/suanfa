package shangguigu.sort;

import java.util.Arrays;

/**
 * @BelongsProject: suanfa
 * @BelongsPackage: shangguigu.sort
 * @Author: GuoJHao
 * @CreateTime: 2022-12-30  21:46
 * @Description: TODO
 * @Version: 1.0
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];
//        int[] arr = new int[]{5,7,1,9,3};
        for (int i = 0; i < 80000; i++) {
//            Math.random()随机生成0-1的随机数
            arr[i] = (int) (Math.random() * 8000000);
        }
        System.out.println(Arrays.toString(arr));
        long time1 = System.currentTimeMillis();
        selectSort(arr);
        long time2 = System.currentTimeMillis();
        System.out.println(Arrays.toString(arr));
        System.out.println(time2 - time1);//2228ms
    }

    public static void selectSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i+1; j < arr.length; j++) {
                if (min > arr[j]){
                    minIndex = j;
                    min = arr[j];
                }
            }
            //交换
            if (minIndex != i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }

//            System.out.println("第"+(i+1)+"轮后");
//            System.out.println(Arrays.toString(arr));
        }
    }
}
