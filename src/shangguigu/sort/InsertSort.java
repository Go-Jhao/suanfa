package shangguigu.sort;

import java.util.Arrays;

/**
 * @BelongsProject: suanfa
 * @BelongsPackage: shangguigu.sort
 * @Author: GuoJHao
 * @CreateTime: 2022-12-30  22:15
 * @Description: TODO
 * @Version: 1.0
 */
public class InsertSort {
    public static void main(String[] args) {
//        int[] arr = new int[]{5,7,1,9,3};
//        insertSort(arr);

        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
//            Math.random()随机生成0-1的随机数
            arr[i] = (int) (Math.random() * 8000000);
        }
        System.out.println(Arrays.toString(arr));
        long time1 = System.currentTimeMillis();
        insertSort(arr);
        long time2 = System.currentTimeMillis();
        System.out.println(Arrays.toString(arr));
        System.out.println(time2 - time1);//565ms
    }

    public static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];
            int compareIndex = i-1;
            while (compareIndex >= 0 && insertVal < arr[compareIndex]){
                arr[compareIndex + 1] = arr[compareIndex];
                compareIndex--;
            }
            arr[compareIndex + 1] = insertVal;
//            System.out.println("第"+(i)+"轮后");
//            System.out.println(Arrays.toString(arr));
        }
    }
}
