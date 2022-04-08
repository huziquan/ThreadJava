package zijietiaodong;

import java.util.Arrays;
import java.util.Scanner;

public class String02 {
  public static void main(String[] args){
      Scanner scanner = new Scanner(System.in);
      String row1 = scanner.nextLine();
      String row2 = scanner.nextLine();
      int[] line1 = getData(row1);
      int[] line2 = getData(row2);
      Arrays.sort(line2);
      System.out.println("答案："+(getReturn(line1[0],line1[1],line2)%99997867));

  }

  public static int getReturn(int N, int D,int[] array){
      int data= 0;
      int min,max;
      for(int i=0;i<N-2;i++){
          min = i;
          max = i+2;
          while(max<array.length&&(array[max]-array[min]<=D)){
              data = data+(max-min-1);
              max++;
              System.out.println(data+"==="+min+"-----"+max);
          }
      }
      return data;
  }

  public static int[] getData(String arg){
      String[] arr = arg.split("\\s");
      int[] array = new int[arr.length];
      for(int i=0;i<arr.length;i++){
          array[i] = Integer.parseInt(arr[i]);
      }
      return array;
  }

}
