package LeetCode.数组问题;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_01两数之和 {
    //暴力解法省略

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> storeNums = new HashMap<>(nums.length,1);
        int [] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int another = target - nums[i];
            Integer anotherIdex = storeNums.get(another);
            if(null!=anotherIdex){
                result[0] = anotherIdex;
                result[1] = i;
                break;
            }else{
                storeNums.put(nums[i],i);
            }
        }
        return result;
    }
}
