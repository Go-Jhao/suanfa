package test;
import java.util.Scanner;
//我爱尹红丽
public class Test2 {
    public static void main(String[] args) {
        Scanner sin = new Scanner(System.in);
        double date1=sin.nextDouble();
        double date2=sin.nextDouble();
        String op=sin.next();
        if(op.equals("+"))
        {
            System.out.printf("%.2f",date1+date2);
        }
        else if (op.equals("-"))
        {
            System.out.printf("%.2f",date1-date2);
        }
        else if (op.equals("*"))
        {
            System.out.printf("%.2f",date1*date2);
        }
        else if (op.equals("/"))
        {
            System.out.printf("%.2f",date1/date2);
        }
    }
}
