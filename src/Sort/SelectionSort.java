package Sort;

public class SelectionSort {
     //选择排序 最小的放在最前面
    public int[] Sort(int[] arr){
        int minData=0;
         if(arr.length==0){
             return arr;
         }else{
             for(int i=0;i<arr.length;i++){
                 minData = i;
                 for(int j=i+1;j<arr.length;j++){
                     if(arr[minData]>arr[j]){
                         minData = j;
                     }
                 }
                 int temp = arr[minData];
                 arr[minData] = arr[i];
                 arr[i] = temp;
             }
             return arr;
         }
    }
    public static void main(String[] args){
        int[] array ={12,5,78,45,367,34,2,7,34,5,67,98,0,2,45,67};
        SelectionSort sort =new SelectionSort();
        int[] arr=sort.Sort(array);
        for(int num:arr){
            System.out.println("数据:"+num);
        }
    }

}
