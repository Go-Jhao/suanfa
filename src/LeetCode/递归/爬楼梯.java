package LeetCode.递归;

import java.util.HashMap;
import java.util.Map;
/**
 * @author GuoJHao
 * @date 2022/6/21 17:53
 */
public class 爬楼梯 {
     /**
      * 方法1
      * 纯粹递归(省略)
      */

    private Map<Integer,Integer> storeMap = new HashMap<>();
     /**
      * @思想  dp思想
      * @param int 总的楼梯数量
      * @return 多少种不同的方法可以爬到楼顶
      * @author GuoJHao
      * @date 2022/6/21 17:52
      * @description:假设你正在爬楼梯。需要 n 阶你才能到达楼顶
      * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
      */

//    public int climbStairs(int n){
//        if (n == 1) return 1;
//        if (n == 2) return 2;
//        if (null != storeMap.get(n)){
//            return storeMap.get(n);
//        }
//        else {
//            int result = climbStairs(n-1)+climbStairs(n-2);
//            storeMap.put(n,result);
//            return result;
//        }
//    }
      /**
       * 方法三:循环
       * @param
       * @return
       * @author GuoJHao
       * @date 2022/6/21 18:15
       * @description:
       */

    public int climbStairs(int n){
        if (n == 1) return 1;
        if (n == 2) return 2;
        int result = 0;
        int pre = 2;
        int prePre = 1;
        for (int i = 3; i <= n; i++) {
            result = pre + prePre;
            prePre = pre;
            pre = result;
        }
        return result;
    }


}
