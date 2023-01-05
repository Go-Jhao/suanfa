package test;


import java.io.*;
import java.math.BigInteger;

public class BigInt {
    BigInteger m1;
    BigInteger m2;
    BigInteger m3;

    BigInt(String s1, String s2) {
        m1 = new BigInteger(s1);
        m2 = new BigInteger(s2);
    }

    public void add() {
        m3 = m1.add(m2);
        System.out.println(m3);
        writeUsingOutputStream(String.valueOf(m3));
    }



    public void multiply() {
        m3 = m1.multiply(m2);
        System.out.println(m3);
        writeUsingOutputStream(String.valueOf(m3));
    }


    private static void writeUsingOutputStream(String data) {
        OutputStream os = null;
        try {
            os = new FileOutputStream(new File("plus.out"));
            os.write(data.getBytes(), 0, data.length());
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("plus.in");//我的txt文本存放目录，根据自己的路径修改即可
        String[] nums = new String[0];
        try {
            nums = new String[3];
            int i = 0;
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while ((s = br.readLine()) != null && i < 3) {//使用readLine方法，一次读一行
                nums[i] = s;
                i++;
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        BigInt bigInt = new BigInt(nums[0], nums[2]);
        if ("*".equals(nums[1])){
            bigInt.multiply();
        }else if ("+".equals(nums[1])){
            bigInt.add();
        }
    }
}
