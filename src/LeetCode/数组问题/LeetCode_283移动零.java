package LeetCode.数组问题;

public class LeetCode_283移动零 {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0;i < nums.length;i++){
            if (nums[i]!=0){
                nums[j++] = nums[i];
            }
        }
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums= new int[]{1};
        LeetCode_283移动零 mi = new LeetCode_283移动零();
        mi.moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }
}
