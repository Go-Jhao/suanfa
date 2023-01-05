package test;

/**
 * @BelongsProject: suanfa
 * @BelongsPackage: test6
 * @Author: GuoJHao
 * @CreateTime: 2022-11-15  10:37
 * @Description: TODO
 * @Version: 1.0
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class XiangQinShu {

    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\11935\\Desktop\\a1.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;

        st = br.readLine();

        String[] strs = st.split(" ");

        int m= Integer.parseInt(strs[0]);
        int n= Integer.parseInt(strs[1]);

        int summ=xiangqin(m);
//        System.out.println("1="+String.valueOf(summ));
        int sumn=xiangqin(n);
//        System.out.println("1="+String.valueOf(sumn));
        if(sumn==m&&summ==n){
            System.out.print(1+" ");
        }else{
            System.out.print(0+" ");
        }
        System.out.print(shu(m)+shu(n));
    }
    public static int xiangqin(int t){
        int num = 1;
        int sum=1;
//        System.out.print(String.valueOf(t)+",");
        for(int i=t/2;i>1;i--){
            if(t%i==0){
//                System.out.print(String.valueOf(i)+"+");
                sum+=i;
                num++;
            }
        }
        return sum;
    }

    public static int shu(int t){
        int num = 1;
        int sum=1;
//        System.out.print(String.valueOf(t)+",");
        for(int i=t/2;i>1;i--){
            if(t%i==0){
//                System.out.print(String.valueOf(i)+"+");
                sum+=i;
                num++;
            }
        }
        return num+1;
    }
}
