package test;

import java.util.Scanner;

public class FenTest {

    private  static Scanner sin;
    public  static  void  main(String[]  args)  {
        sin=new  Scanner(System.in);
        Fen  f1=new  Fen(sin.nextInt(),  sin.nextInt());
        Fen  f2=new  Fen(sin.nextInt(),  sin.nextInt());
        System.out.println(divide(f1,  f2).toString());
    }
    public  static  Fen  divide(Fen  f1,Fen  f2)
    {
        int a = f1.getFenZi() * f2.getFenMu();
        int b = f1.getFenMu() * f2.getFenZi();
        int gcd = 0,c;
        //辗转相除法求最大公因数
        if(a > b)
        {
            while(b != 0)
            {
                a = a % b;
                if(a < b) {c = a;a = b;b = c;}
                gcd = a;
            }
        }
        if(a == b)
            gcd = a;
        else
        {
            c = a;a = b;b = c;
            while(b != 0)
            {
                a = a % b;
                if(a < b){c = a;a = b;b = c;}
                gcd = a;
            }
        }
        Fen result = new Fen(f1.getFenZi() * f2.getFenMu()/gcd,f1.getFenMu() * f2.getFenZi()/gcd);
        return result;
    }
}
