package Sort;
//希尔排序
public class ShellSort {
    public int[] Sort(int[] arr){

         int arrLength = arr.length;
         int grep=arrLength/2;
         int preIndex=0;
         int switchNum=0;
         while(grep>0) {
             for (int i = grep; i < arrLength; i++) {
                 preIndex = i - grep;
                 switchNum = arr[i];
                 while (preIndex>=0&& arr[preIndex]>switchNum) {
                      arr[preIndex+grep]=arr[preIndex];//很重要它保证了根据grep划分的小队列顺序是没问题的，参考插入排序
                      preIndex=preIndex-grep;
                 }
                 arr[preIndex+grep] = switchNum;
                 for(int num:arr){
                     System.out.print(num+"||");
                 }
                 System.out.println("第"+(i)+"次排序"+"grep:"+grep+"||preIndex:"+(i-grep));
             }
             grep=grep/2;
         }
        return arr;
    }

    public static void main(String[] args){
        int[] array ={12,5,78,45,70,34,2,7,34,5,67,98,0,2,45,67};
        ShellSort sort =new ShellSort();
        int[] arr=sort.Sort(array);
       /* for(int num:arr){
            System.out.print("||:"+num);
        }*/
    }
}
