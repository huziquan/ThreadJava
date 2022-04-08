package Sort;

import java.util.Arrays;

/*
* 归并排序
* */
public class MergeSort {

    public int[] Sort(int[] arr){
        if(arr.length<2){
            return arr;
        }
        int middle_num = arr.length/2;
        int[] left = Arrays.copyOfRange(arr,0,middle_num);
        int[] right = Arrays.copyOfRange(arr,middle_num,arr.length);
        return UnionArray(Sort(left),Sort(right));
    }

    /*
    * 将两个成为一定序列的数组合并成为一个
    * */
    public int[] UnionArray(int[] left,int[] right){
     int[] result_arr = new int[left.length+right.length];
     for(int i=0,j=0,index=0;index<result_arr.length;index++){
         if(j>=right.length){
             result_arr[index] = left[i];
             i++;
         } else if(i>=left.length){
             result_arr[index]=right[j];
             j++;
         } else if(left[i]<=right[j]){
              result_arr[index]=left[i];
              i++;
         }else if(left[i]>right[j]){
             result_arr[index]=right[j];
             j++;
         }

     }
        for(int num:result_arr){
            System.out.print(num+"||");
        }
        System.out.println("递归后合并的数组");
          return result_arr;
    }

    public static void main(String[] args){
        int[] array ={12,5,78,45,70,34,2,7,34,5,67,98,0,45,67};
       MergeSort sort =new MergeSort();
        int[] arr=sort.Sort(array);
       /* for(int num:arr){
            System.out.print("||:"+num);
        }*/
    }


}
