package huawei;

import java.util.Scanner;

/*
*已知连续正整数数列{K}=K1,K2,K3…Ki的各个数相加之和为S，i=N (0<S<100000, 0<N<100000), 求此数列K。

输入描述:

输入包含两个参数，1）连续正整数数列和S，2）数列里数的个数N。

输出描述:

如果有解输出数列K，如果无解输出-1

示例1

输入

525 6

输出

85 86 87 88 89 90

sum = N*X+(0+1+2+..+N-1)=N*X + (N-1)*N/2
*
* */
public class Test04 {

    public  static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入数列之和以及数列个数：");
        int Sum = scanner.nextInt();
        int N = scanner.nextInt();
        int[] arr=getList(Sum,N);
        if(arr[0]==-1){
            System.out.println("没有此数列！");
        }else{
            for(int i=0;i<arr.length;i++){
                System.out.println(arr[i]);
            }
        }

    }

    public static int[] getList(int Sum,int N){
        int[] list =new  int[N];
        double room = (double)Sum/N - (double) (N-1)/2;
        if(room*10%10==0){
            for(int i=0;i<N;i++){
                list[i] =(int)room+i;
            }
            return list;
        }else{
            return new int[]{-1};
        }



    }
}
