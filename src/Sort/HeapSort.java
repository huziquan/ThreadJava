package Sort;

public class HeapSort {
    static  int len =0;// 控制每次最大堆顶数据 放置在最后面后，控制数组长度，防止最大值再次被采集

    public static int[] Sort(int[] array){
        len = array.length;
        if(len<0){
            return null;
        }
      while(len>0){
          BuileTree(array);
          swap(array,0,len-1);//交换最大堆的堆顶 与末尾的数
          len--;
      }
      return array;
    }
    /*
    * 建立一个二叉树(最大堆)
    * */
    public static void BuileTree(int[] array){
         for(int i=(len/2-1);i>=0;i--){
             /*System.out.println(i);*/
             adjustHeap(array,i);
         }
    }
    /*
    * 父节点与子节点的排序
    * */
    public static void adjustHeap(int[] array,int i){
        int top = i;
        //左子树比较
        if(2*i+1<len&&array[top]<array[2*i+1]){
            top = 2*i+1;
        }
        //右子树大小判断
        if(2*i+2<len&&array[top]<array[2*i+2]){
            top= 2*i+2;
        }
        if(top!=i) {
            swap(array, top, i);
            adjustHeap(array,top);
        }
        /*System.out.println("top:"+top);*/
    }
    /*
    * 数组位置交换
    * */
    public static void swap(int[] array,int i,int j){
        int temp= array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args){
        /*int[] array ={12,6,78,85,70,34,2};*/
        int[] array ={12,6,78,85,70,34,2,7,44,5,67,98,0,19,45,27};
        HeapSort sort =new HeapSort();
        sort.Sort(array);
        for(int num:array){
            System.out.print("||:"+num);
        }
    }
}
