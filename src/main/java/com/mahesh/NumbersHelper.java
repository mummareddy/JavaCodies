package com.mahesh;

/**
 * Created by mummareddym on 15/03/2021
 */
public class NumbersHelper {
    public static void main(String[] args) {
        int a=10; int b=5;
        System.out.println(add(a, b));
        System.out.println(sub(a, b));
        System.out.println(mul(a, b));
        System.out.println(div(a, b));
        System.out.println(div(a, b));

    }
    static int add(int a, int b){
        return a+b;
    }
    static int sub(int a, int b){
        return a-b;
    }
    static int mul(int a, int b){
        return a*b;
    }
    static int div(int a, int b){
        return a/b;
    }

}
