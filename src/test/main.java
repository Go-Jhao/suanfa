package test;

/**
 * @BelongsProject: suanfa
 * @BelongsPackage: test6
 * @Author: GuoJHao
 * @CreateTime: 2022-11-15  11:07
 * @Description: TODO
 * @Version: 1.0
 */
import java.util.Scanner;
import java.util.Vector;

public class main {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        Vector<Integer> arrayA = new Vector<Integer>();
        Vector<Integer> arrayB = new Vector<Integer>();
        Vector<Integer> vectorSUB = new Vector<Integer>();
        arrayA = exceptZero(A);
        arrayB = exceptZero(B);
//        printf(arrayA);
//        System.out.println();
//        printf(arrayB);
//        System.out.println();

        if(compare(arrayA,arrayB)==0){
            System.out.println(0);
        } else if (compare(arrayA,arrayB)==1) {
            vectorSUB = SUB(arrayA,arrayB);
            printf(vectorSUB);
        }
        else if(compare(arrayA,arrayB)==-1){
            vectorSUB = SUB(arrayB,arrayA);
            System.out.print('-');
            printf(vectorSUB);
        }

    } public static Vector exceptZero(String a){
        Vector<Integer> number= new Vector<Integer>();
        boolean IsFirstZero = true;
        for(int i=0;i<a.length();i++){
            char ch = a.charAt(i);
            if(ch == '0' && IsFirstZero){
                continue;
            }
            else{
                IsFirstZero = false;
                number.add(0,ch - '0');
            }
        }
        return number;
    }
    //输出Vector的值
    public static void printf(Vector vector){
        boolean firstZero = true;
        for(int i=0;i<vector.size();i++){
            if((Integer)vector.get(i)==0 && firstZero){
                continue;
            }
            else{
                firstZero=false;
                System.out.print((Integer) vector.get(i));
            }

        }
    }public static int compare(Vector arrayA,Vector arrayB){
        if(arrayA.size()>arrayB.size()){
            return 1;
        }
        else if(arrayA.size()<arrayB.size()){
            return -1;
        }
        else{
            for (int i=arrayA.size() - 1;i >= 0;i--){
//                System.out.println(arrayA.get(i));
                if((Integer)arrayA.get(i) > (Integer) arrayB.get(i)){
                    return 1;
                }
                else if((Integer)arrayA.get(i) < (Integer) arrayB.get(i)){
                    return -1;
                }
                else{
                    continue;
                }
            }

            return 0;
        }
    }public static Vector SUB(Vector arrayFirst,Vector arraySecond){
        Vector<Integer> vectorSUB = new Vector<Integer>();
        for(int i=0;i<arrayFirst.size();i++){
            int number;
            if(i<arraySecond.size()){
                number =(Integer)arrayFirst.get(i)-(Integer) arraySecond.get(i);
            }
            else {
                number = (Integer)arrayFirst.get(i);
            }
            if (number>=0){
                vectorSUB.add(0,number);
            }
            else{
                arrayFirst.set(i+1,(Integer)arrayFirst.get(i+1)-1);
                if((Integer)arrayFirst.get(i)==0){
                    vectorSUB.add(0,10-Math.abs(number));
                }
                else{
                    vectorSUB.add(0,number+10);
                }
            }
        }
        return vectorSUB;
    }
}