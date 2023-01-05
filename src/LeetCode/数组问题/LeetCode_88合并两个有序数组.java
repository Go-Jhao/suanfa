package LeetCode.数组问题;

import java.util.Arrays;

public class LeetCode_88合并两个有序数组 {
     /**
      *
      * @param
      * @return
      * @author GuoJHao
      * @date 2022/6/22 17:41
      * @description:快速排序 O（nlogn）
      */

//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        for (int i = 0; i < n; i++) {
//            nums1[m + i] = nums2[i];
//        }
//        Arrays.sort(nums1);
//    }



//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        int k = m+n;
//        int []temp = new int [k];
//        for (int index = 0,nums1Index = 0,nums2Index = 0; index < k ;index++){
//            if (nums1Index>=m){
//                temp[index] = nums2[nums2Index++];
//            }else if (nums2Index>=n){
//                temp[index] = nums1[nums1Index++];
//            }else if(nums1[nums1Index] < nums2[nums2Index]){
//                temp[index] = nums1[nums1Index++];
//            }else{
//                temp[index] = nums2[nums2Index++];
//            }
//        }
//        for (int i = 0; i < k; i++) {
//            nums1[i] = temp[i];
//        }
//
//    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m+n;
        for (int index = k-1,nums1Index = m-1,nums2Index = n-1; index >= 0 ;index--){
            if (nums1Index<0){
                nums1[index] = nums2[nums2Index--];
            }else if (nums2Index<0){
                nums1[index] = nums1[nums1Index--];
            }else if(nums1[nums1Index] > nums2[nums2Index]){
                nums1[index] = nums1[nums1Index--];
            }else{
                nums1[index] = nums2[nums2Index--];
            }
        }
    }
}
