package LeetCode.基础;

public class 随机和 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,1,1,1};
        for (int i = 0; i < runningSum(nums).length; i++) {
            System.out.println(runningSum(nums)[i]);
        }
    }
    public static int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = nums[0];
        for (int i = 0; i < nums.length-1; i++) {
            result[i+1] = result[i] + nums[i+1];
        }
        return result;

    }
}
