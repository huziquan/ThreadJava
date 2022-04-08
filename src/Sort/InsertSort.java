package Sort;
/*
* 在一个有序数列中进行比对，并进行排序
* */
public class InsertSort {
    public int[] Sort(int[] arr){

        if(arr.length<=0){
            return arr;
        }else {
            int Index = 0;
            for(int i=0;i<arr.length-1;i++){
                Index = i;
                int switchNum=arr[Index+1];
               while(Index>=0&&arr[Index]>switchNum){
                   arr[Index+1]=arr[Index];
                   Index--;
               }
               arr[Index+1] =  switchNum;

                for(int num:arr){
                    System.out.print(num+"||");
                }
                System.out.println("第"+(i+1)+"次排序");
            }
            return arr;
        }
    }
    public static void main(String[] args){
        int[] array ={12,5,78,45,70,34,2,7,34,5,67,98,0,2,45,67};
        InsertSort sort =new InsertSort();
        int[] arr=sort.Sort(array);
       /* for(int num:arr){
            System.out.print("||:"+num);
        }*/
    }

}
