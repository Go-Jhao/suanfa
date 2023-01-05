package test;

import java.util.Scanner;

/**
 * @BelongsProject: suanfa
 * @BelongsPackage: test6
 * @Author: GuoJHao
 * @CreateTime: 2022-10-31  11:47
 * @Description: TODO
 * @Version: 1.0
 */

public class testphon {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MobilePhone p = new MobilePhone();
        p.time = input.nextInt();
        p.price = input.nextDouble();
        p.pay();
    }
}
interface PayAble{
    void pay();
}
class Phone implements PayAble{
    String code;
    public void pay() {
    }
}
class MobilePhone extends Phone{

    int time;
    double price;

    public void pay() {
        System.out.println("Fee=" +String.format("%.1f", time * price));
    }

}
