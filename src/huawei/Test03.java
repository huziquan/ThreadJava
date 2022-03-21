package huawei;

import java.util.Scanner;

/*
* [信道分配] 算法工程师小明面对着这样一个问题， 需要将通信用的信道分配给尽量多的用户:
信道的条件及分配规则如下:
1）所有信道都有属性:"阶"， 阶为r的信道的容量为2^r特:
2)所有用户需要传辅的数据量都样D比特:
3)1个用户可以分配多个信道， 但每个信道只能分配给1个用户:
4)只有当分配给个用户的所有信道的容量和>=D,用户才能传输数据:
给出一组信道资源，最多可以为多少用户传输数据?
输入描述
第一行，一个数字R。R为最大阶数。0=R(20
第二行，R+1个数字，用空格隔开代表每种信道的数量N.按解阶的值从小到大排列。0<i<=R
0<N<1000
第三行，一个数字D, D为单个用户需要传输的数据量。0<D<100000
输出描述一个数字， 代表最多可以供多少用户传输数据。
示例口输入: 5
10 5 0 1 3 2
30
输出4

6个信道 1*10  2*5  4*0  8*1  16*3 32*2

单个用户信号的容量 30
 4个用户信号 32*2+（16*2）*1 +（16*1+8+10+10）*1
*
* */
public class Test03 {

    public static void main(String[] args){
        int users = 0;
        int R_num = 0;
        int D_num = 0;
        System.out.print("输入阶数R(0<=R<=20)：");
        Scanner scanner = new Scanner(System.in);
        R_num = scanner.nextInt();
        int[] channells = new int[R_num+1];
        System.out.println("输入信道数：");
        for(int i=0;i<=R_num;i++){
            channells[i]=scanner.nextInt();
        }
        System.out.print("输入用户数据量：");
        D_num = scanner.nextInt();

        users = getCustomers(channells,D_num);
        System.out.println("用户数："+users);
    }

    /*
    * 获取用户数 Math.pow(a,b)  a的b次方
    * */
    public static int getCustomers(int[] channel,int D){
        int arr_len= channel.length;
        int num_peo=0;
        int sum = 0;
        int B=1;
        for(int i=(arr_len-1);i>=0;i--){
            for(int j = 1;j<=channel[i];j++){
                 sum = sum+(int)Math.pow(2,i);
                if(D<=sum){
                   num_peo=num_peo+1;
                   System.out.println(num_peo+"+++++"+sum+"++++i:"+i+"+++j:"+j);
                   sum=0;
                }
            }
        }
        return num_peo;
    }

}
