package com.nats.Arrays;
import java.io.*;
import java.util.*;

/**
 * Created by nataraja.maruthi on 1/5/18.
 */
public class Solution {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int array[] = new int[n];
        for (int i = 0;i<n;i++) {
            array[i] = sc.nextInt();
        }
        for (int i = n-1;i>=0;i--) {
            System.out.print(array[i]);
            System.out.print(" ");
        }
    }
}
