package shangguigu.recursion;

/**
 * @BelongsProject: suanfa
 * @BelongsPackage: shangguigu.recursion
 * @Author: GuoJHao
 * @CreateTime: 2022-12-28  19:25
 * @Description: TODO
 * @Version: 1.0
 */
public class Queue8 {
    static int count;
    //定义一个max表示共有多少个皇后
    int max = 8;
    //定义一个数组，保存皇后防治的结果
    int[] array = new int[max];

    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);


        System.out.println(count);
    }
    /**
     * @description:插入第n行的皇后
     * @author: GuoJHao
     * @date: 2022/12/28 20:08
     * @param: [n]
     * @return: void
     **/
    private void check(int n){
        if (n == max){
            print();
            return;
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
            if (judge(n)){
                check(n+1);
            }
        }
    }

    //查看当我们放置第n个皇后，就去检查该皇后是否与前面的已经摆好的发生冲突
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[i] - array[n])) {
                return false;
            }
        }
        return true;
    }

    //打印皇后摆放的位置
    private void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
