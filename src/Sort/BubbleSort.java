package Sort;

public class BubbleSort {
//冒泡排序，从低到高排序,领区交换
    public int[] BubbleSort(int[] arr){
        int leng =arr.length;
        if(leng<=1){
            return arr;
        }else {
            for (int i = 0; i < leng - 1; i++) {
                for (int j = 0; j < leng - 1 - i; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int max = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = max;
                    }
                }
            }
            return arr;
        }
    }

    public static void main(String[] args){
        int[] array ={12,5,78,45,367,34,2,7,34,5,67,98,0,2,45,67};
        BubbleSort sort=new BubbleSort();
        int[] arr=sort.BubbleSort(array);
        for(int num:arr){
            System.out.println("数据:"+num);
        }
    }
}
