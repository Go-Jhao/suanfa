package test;

import java.util.*;

public class Activities {
    static int[] opt = new int[1000010];
    public static void main(String[] args) {
        //从控制台获取输入的数据
        System.out.print("请输入节目数量:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.print("请输入开始时间，结束时间以及权重");
        int f = 0;
        List<Node> list = new ArrayList<>();
        Node node;
        for (int i = 0; i < n; i++) {
            int st = scanner.nextInt();
            int en = scanner.nextInt();
            int w = scanner.nextInt();
            node = new Node(st, en, w);
            list.add(node);
        }
        //排序，按照活动结束时间由小到大排序
        Collections.sort(list, new NodeComparator());

        //根据动态规划原理，利用状态转移方程，计算最优解
        for (int i = 0; i < n; i++) {
            int l = 0, r = i;
            while (l <= r) {
                //求解中间值，类似于二分法查找当前活动之前能容纳的活动
                int mid = (l + r) >> 1;
                if (list.get(mid).en <= list.get(i).st)
                    //如果mid活动的结束时间<=当前活动的开始时间，说明mid活动和当前活动相容，那么继续往后找mid+1，看时候能够和第i个活动相容，直至找到mid最大的活动
                    l = mid + 1;
                else
                    //如果mid活动的结束时间>=当前活动的开始时间，说明这两个活动不相容，所以找mid-1是否满足条件....依此类推
                    r = mid - 1;
            }
            //计算加上当前活动 和 不加当前活动 哪个权值最大
            if((i-1)<0 && (l-1)<0){
                opt[i] = max(0,list.get(i).w);
            }
            else if((i-1)<0){
                opt[i] = max(0,opt[l-1]+list.get(i).w);
            }
            else if((l-1)<0){
                opt[i] = max(opt[i-1],list.get(i).w);
            }
            else
                opt[i] = max(opt[i-1],opt[l-1]+list.get(i).w);
        }
        System.out.print("最高权重为：");
        System.out.println(opt[n-1]);

    }
    // 取较大值
    public static int max(int dp1,int dp2){
        if(dp1>=dp2){
            return dp1;
        }else
            return dp2;
    }
}

/**
 * todo: 比较两个对象的大小
 * 根据其结束时间比较
 */
class NodeComparator implements Comparator<Node> {

    @Override
    public int compare(Node o1, Node o2) {
        return o1.en > o2.en ? 1 : -1;
    }
}

/**
 * 定义活动节点
 */
class Node {
    public Integer st;
    public Integer en;
    public Integer w;

    public Node() {
    }

    public Node(Integer st, Integer en, Integer w) {
        this.st = st;
        this.en = en;
        this.w = w;
    }

    @Override
    public String toString() {
        return st + " " + en + " " + w;
    }
}