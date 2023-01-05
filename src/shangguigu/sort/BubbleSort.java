package shangguigu.sort;

import java.util.Arrays;

/**
 * @BelongsProject: suanfa
 * @BelongsPackage: shangguigu.sort
 * @Author: GuoJHao
 * @CreateTime: 2022-12-29  21:50
 * @Description: TODO
 * @Version: 1.0
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
//            Math.random()随机生成0-1的随机数
            arr[i] = (int) (Math.random() * 8000000);
        }
        System.out.println(Arrays.toString(arr));
        long time1 = System.currentTimeMillis();
        bubbleSort(arr);
        long time2 = System.currentTimeMillis();
        System.out.println(Arrays.toString(arr));
        System.out.println(time2 - time1);//10939ms
    }

    public static void bubbleSort(int[] arr) {
        int temp = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag) {
                break;
            } else {
                flag = false;
            }
//            System.out.println("第" + (i + 1) + "次排序后的数组是");
//            System.out.println(Arrays.toString(arr));
        }
    }
}
