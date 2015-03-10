package hello;

import java.util.Scanner;

public class Primes {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);//获取键盘输入
        int a=scan.nextInt();//赋值
        if (a <= 1) {  //质数不能小于1
            System.out.println("不是质数");
        }else if(a==2 ||a==3){  //单独判断，想不到怎么弄
            System.out.println("是质数");
        }
        int k = (int) Math.sqrt(a);  //取判断数的平方根的整数
        for (int i = 2; i <= k; i++) {
            if(a % i == 0) {     //判断
                System.out.println("不是质数");
            }else{
                System.out.println("是质数");
            }
        }
    }
}
