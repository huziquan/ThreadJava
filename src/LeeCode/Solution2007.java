package LeeCode;

import java.lang.reflect.Array;
import java.util.Arrays;
/*
* 排序->  arrayList存储原始数组->list转化为数组
* */
public class Solution2007 {
    public int[] findOriginalArray(int[] changed) {
     int arr_length = changed.length;
     Arrays.sort(changed);
     if(changed[0]!=0&&(arr_length%2)!=0){
         //奇数项  没有数据0
       return new int[0];
     }else if(changed[0]==0&&(arr_length%2)!=0){
         //奇数项 有数据0
         int [] arr = new int[12];
         return arr;
     }else {
         //偶数项
         int [] arr = new int[12];
         return arr;
     }




    }
}
