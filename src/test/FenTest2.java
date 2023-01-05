package test;

/**
 * @BelongsProject: suanfa
 * @BelongsPackage: test6
 * @Author: GuoJHao
 * @CreateTime: 2022-11-02  21:53
 * @Description: TODO
 * @Version: 1.0
 */

import java.util.Scanner;


public class FenTest2 {
    private static Scanner sin;

    public static void main(String[] args) {
        sin=new Scanner(System.in);
        Fen f1=new Fen(sin.nextInt(), sin.nextInt());
        Fen f2=new Fen(sin.nextInt(), sin.nextInt());
        System.out.println(add(f1, f2));

    }
    public static Fen add(Fen f1,Fen f2)
    {
        int a = f1.getFenZi() *f2.getFenMu()+f2.getFenZi()*f1.getFenMu();
        int b = f1.getFenMu() *f2.getFenMu();
        int num1=a;
        int num2=b;
        int gcd;

        if(a%b == 0){
            return new Fen(a/b,1);
        }
        while (num1 % num2 != 0) {
            int mod = num1 % num2;
            num1 = num2;
            num2 = mod;
        }
        gcd = num2;


        Fen result = new Fen(a/gcd,b/gcd);
        return result;
    }

    // 辗转相除法求两个数的最大公约数
    private static int getGcd(int num1, int num2) {
        while (num1 % num2 != 0) {
            int mod = num1 % num2;
            num1 = num2;
            num2 = mod;
        }
        return num2;
    }

}
