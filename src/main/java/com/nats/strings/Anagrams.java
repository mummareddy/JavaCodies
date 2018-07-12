package com.nats.strings;

import java.util.Stack;

/**
 * @author mummareddy.mahesh
 */
public class Anagrams {
    public static void main(String[] args) {
        String str1="bcd";
        String str2="cda";
        int count =0;
        int[] cnt=new int[26];
        for(char ch : str1.toCharArray())
        {
            cnt[ch-'a']++;
        }
        for(char ch : str2.toCharArray())
        {
            cnt[ch-'a']--;
        }
        for (int i:cnt)
        {
            count+=Math.abs(i);
        }
    }
    Stack s = new Stack();
}
