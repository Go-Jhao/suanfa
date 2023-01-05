package shangguigu.recursion;

/**
 * @BelongsProject: suanfa
 * @BelongsPackage: shangguigu.recursion
 * @Author: GuoJHao
 * @CreateTime: 2022-12-21  19:25
 * @Description: TODO
 * @Version: 1.0
 */
public class RecursionTest {
    public static void main(String[] args) {
        test(40);
    }
    public static void test(int n){
        if (n > 2){
            test(n-1);
        }
        System.out.println("n = " + n);
    }
}
