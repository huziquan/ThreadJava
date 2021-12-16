package LeeCode;

public class Main {
    public static void main(String[] args) {
        // write your code here
        String str="pwwkew";
        Solution3 sol=new Solution3();
        int max=sol.lengthOfLongestSubstring(str);
        System.out.println("最长的长度："+max);
    }
}
