package Sort;
/*
* 快排
* */
public class QuickSort {
    /*
    * 循环递归调用
    * */
    public static int[] Sort(int[] arr,int start,int end){
        if(start>end||start<0||end>=arr.length||arr.length<1){
            return null;
        }
        int smallIndex = quicksort(arr,start,end);

        if(smallIndex>start)
            Sort(arr,start,smallIndex-1);

        if(smallIndex<end)
            Sort(arr,smallIndex+1,end);
        return arr;
    }

    /*
    * 单次快排，返回的是 小于pivot(随机进行中分)的数，返回后以此位置将传入的arr分成两组
    * */
    public static int quicksort(int[] arr,int start,int end){
        int pivot =(int)(start+Math.random()*(end-start+1));
        int smallIndex = start-1;//在此数据上+1便是记录比下标为pivot小的数有多少个数，同时也作为数据中的一个下标
        swap(arr,pivot,end);//将判断作为判断的数放在最后，避免中间因为比自己小的数据替换了 pivot位置的数，造成没有比对的对象
        for(int i=start;i<=end;i++){
            if(arr[i]<=arr[end]){
                smallIndex++;
                if(i>smallIndex){
                    swap(arr,i,smallIndex);
                }
            }

        }
        for(int num:arr){
            System.out.print(num+"||");
        }
        System.out.println("快速排序："+pivot+"||"+smallIndex);
        return smallIndex;
    }
      /*
      * 数据交换
      * */
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] =arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args){
        int[] array ={12,5,78,45,70,44,2,7,34,14,67,98,0,49,71};
        QuickSort sort =new QuickSort();
        int[] arr=sort.Sort(array,0,(array.length-1));
    }
}
