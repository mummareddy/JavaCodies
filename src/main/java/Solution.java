import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static boolean isBalanced(String expression) {
        char[] chArr=expression.toCharArray();
        Stack<Character> s=new Stack<Character>();
        if (!((chArr.length % 2) ==0))
            return false;
        int i=0;
        while(i<chArr.length)
        {
            if ((chArr[i]=='(') || (chArr[i]=='[') || (chArr[i]=='{'))
            {
                s.push(chArr[i]);
            }
            else
            {
                if((chArr[i]==')') || (chArr[i]==']') ||(chArr[i]=='}') && s.empty())
                    return false;
                char ch = s.peek();
                if(chArr[i]==')')
                    return ch == '(';
                else if(chArr[i]==']')
                    return ch=='[';
                else if(chArr[i]=='}')
                    return ch=='{';
                s.pop();
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Math.sqrt(10));
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}
