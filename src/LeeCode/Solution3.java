package LeeCode;

import java.util.HashSet;
import java.util.Set;

public class Solution3 {
    // 暴力方法    字符串过长，会超出时间的限制
    public int lengthOfLongestSubstring(String s) {
        int MaxLength=0;
        int n=s.length();
            for(int i=0;i<n;i++){
                for(int j=i;j<n;j++){
                    //所有子串
                    String str=s.substring(i,j+1);
                    if(getJudge(str)){
                        if(MaxLength<=(j-i)){
                            MaxLength=(j+1-i);
                        }
                    }
                }
            }
            return MaxLength;
        }
    // 判断字串是否有重复字符
    boolean getJudge(String s){
        Set<Character> set=new HashSet<Character>();
        char[] arr= s.toCharArray();
        for(char ch:arr){
            set.add(ch);
        }
        if(set.size()==s.length()){
            return true;
        }else{
            return false;
        }
    }
}
