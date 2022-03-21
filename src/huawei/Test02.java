package huawei;

import java.util.*;

/*
*
* [最大N个数与最小N个数的和] 给定一个数组， 编写个函数来计算它的最大N个数与最小N个数的和。 你需要对数组进
行去重。说明: °数组中数字范围|0. 1000。最大N个数与最小N个数不能有重叠，如有重叠。输入非法返回输入非法
返回.1输入描述:
第行输入M，M标识数组大小
第二行输入M个数，标识数组内容
第三行输入N, N表达需要计算的最大，最小N个数
输出描述:
输出最大N个数与最小N个数的和。
示例1:输入
95 888364100
2
输出
342

* */
public class Test02 {
     public static void main(String[] args){
         Scanner scanner = new Scanner(System.in);
          int M_num = scanner.nextInt();
          System.out.println("数组的长度："+M_num);
          int[] nums = new int[M_num];

          for(int i=0;i<M_num;i++){
              nums[i]= scanner.nextInt();
          }
          System.out.print("请输入最大以及最小的个数：");
          int N_num = scanner.nextInt();
          int sum_num=getSumBigAndSmall(nums,N_num);
          if(sum_num<=0){
              System.out.println("最大值与最小值有重叠！");
          }else{
              System.out.println("最终值："+sum_num);
          }
     }
     /*处理内容*/
     public static int getSumBigAndSmall(int[] arr,int N){
         int sum=0;
         Object[] array = getNoRepeat(arr);
         int ne_length=array.length;

         if(N>=(array.length)){
             return -1;
         }else {
             for (int i = 0; i < array.length; i++) {
                 System.out.println(array[i]);
             }
             for (int i = 0; i < N; i++) {
                 sum = sum + (int) array[i] + (int) array[ne_length - i-1];
             }
             return sum;
         }
     }

     /*去重排序*/
    public   static Object[] getNoRepeat(int[] arr){
        Set set = new HashSet();
         for(int i=0;i<arr.length;i++){
             set.add(arr[i]);
         }
         return set.toArray();
    }

}
