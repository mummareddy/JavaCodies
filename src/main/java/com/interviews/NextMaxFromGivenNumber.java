package com.interviews;

import java.util.Arrays;

/**
 * @author mummareddy.mahesh
 */
public class NextMaxFromGivenNumber {
    static void getNextMax(String num) {
        char[] digs = num.toCharArray();
        int i,j;
        int temp ;
        for(i=digs.length-1;i>1;i--)
        {
            if(digs[i]>digs[i-1]){
                break;
            }
        }
        j=i+1;temp = i;
        while(j < digs.length)
        {
         if((digs[j] < digs[temp]) && digs[j] > digs[i-1]) {
             temp = j;
         }
         j++;
        }

        char swapchar = digs[i-1];
        digs[i-1] = digs[temp];
        digs[temp] = swapchar;

        Arrays.sort(digs,i,digs.length);
        System.out.println(new String(digs));
    }

    public static void main(String[] args) {
        getNextMax("456731");
    }
}
