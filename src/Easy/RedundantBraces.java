package Easy;

import Medium.InfixToPostfix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class RedundantBraces {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        RedundantBraces obj=new RedundantBraces();
        String s=br.readLine();
        System.out.println(obj.braces(s));
    }
    public int braces(String A) {
        Stack<Character> s=new Stack<>();
        for(int i=0;i<A.length();i++){
            char ch=A.charAt(i);
            if(ch==')'){
                char ch2=s.pop();
                if(ch2=='(' || s.peek()=='(')
                    return 1;
                else{
                    while(s.peek()!='(')
                        s.pop();
                    s.pop();
                }
            }else
                s.push(ch);
        }
        return 0;
    }
}
