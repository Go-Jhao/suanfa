package shangguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;

/**
 * @BelongsProject: suanfa
 * @BelongsPackage: shangguigu.sort
 * @Author: GuoJHao
 * @CreateTime: 2023-01-04  22:38
 * @Description: TODO
 * @Version: 1.0
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000); // 生成一个[0, 8000000) 数
        }
        int temp[] = new int[arr.length]; //归并排序需要一个额外空间
        long time1 = System.currentTimeMillis();
        mergeSort(arr, 0, arr.length - 1, temp);
        long time2 = System.currentTimeMillis();
        System.out.println(Arrays.toString(arr));
        System.out.println(time2 - time1);//15ms
    }

    public static void mergeSort(int[] arr,int left,int right,int[] temp){
        if (left < right){
            int mid = (left + right) /2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid+1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    /**
     * @description:合并
     * @author: GuoJHao
     * @date: 2023/1/4 22:40
     * @param: [arr, left, mid, right]
     * @return: void
     **/
    public static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i = left;//左边的有序序列初始索引
        int j = mid + 1;//左边的有序序列初始索引
        int t = 0;//指向temp的索引
        //(一)
        //先把左右两边(有序)的数据按照规则填充到temp数组
        //直到左右两边的有序序列，有一边处理完毕为止
        while (i <= mid && j <= right){
            if (arr[i] < arr[j]){
                temp[t] = arr[i];
                i++;
                t++;
            }else {
                temp[t] = arr[j];
                j++;
                t++;
            }
        }

        //(二)
        //把有剩余数据的一边的数据依次全部填充到temp
        while( i <= mid) { //左边的有序序列还有剩余的元素，就全部填充到temp
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }

        while( j <= right) { //右边的有序序列还有剩余的元素，就全部填充到temp
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }
        //(三)
        //将temp数组的元素拷贝到arr
        //注意，并不是每次都拷贝所有
        t = 0;
        int tempLeft = left; //
        //第一次合并 tempLeft = 0 , right = 1 //  tempLeft = 2  right = 3 // tL=0 ri=3
        //最后一次 tempLeft = 0  right = 7
        while(tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }

    }
}
