package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class shiyanzifu {
    public static void main(String[] args) throws Exception {
        int charNum = 0;
        int wordsNum = 0;
        InputStreamReader isr = new InputStreamReader(new FileInputStream("C:\\Users\\11935\\Desktop\\in.txt"));
        BufferedReader br = new BufferedReader(isr);
        String s;
        while ((s = br.readLine()) != null){
//            String s = br.readLine();
            System.out.println(s);
            System.out.println(s.length());
            System.out.println(s.split(" ").length+s.split("\\(").length+s.split(",").length-2);
            charNum += s.length();
            wordsNum += s.split(" ").length+s.split("\\(").length+s.split(",").length-2;
        }
        isr.close();//关闭
        System.out.println(wordsNum +" "+ charNum);
    }
}