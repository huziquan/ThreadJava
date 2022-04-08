package Sort;

import java.util.Arrays;

public class CountSort {
    /*
    * 计数排序
    * */
    public static int[] Sort(int[] array){
        int len =array.length;
        int min = 0;
        int max = 0;
        for(int i=0;i<len;i++){
            if(min>=array[i]){
                min = array[i];
            }
            if(max<array[i]){
                max = array[i];
            }
        }
        //创建一个只有max-min+1长度的并且值为0的数组
        int[] new_array = new int[max-min+1];
        Arrays.fill(new_array,0);
        int base= 0-min;
        /*对array[i]进行统计，并通过new_array进行统计
        * */
        for(int i=0;i<len;i++){
            new_array[array[i]+base]++;
        }
    /*    for(int num:new_array){
            System.out.print("||:"+num);
        }*/

        int n=0;//控制新数组
        int m=0;//控制返回数组
        while(m<array.length){
            System.out.println("new_array:"+new_array[n]);
            if(new_array[n]==0){
                n++;
                System.out.println(n+"=-="+base);
            }else{
                array[m] = n-base;
                new_array[n]--;
                m++;
            }
        }
        return array;
    }

    public static void main(String[] args){
        int[] array ={12,5,78,45,70,34,2,7,34,5,67,98,0,2,45,67};
        CountSort sort =new CountSort();
        int[] arr=sort.Sort(array);
        for(int num:arr){
            System.out.print("||:"+num);
        }
    }
}
