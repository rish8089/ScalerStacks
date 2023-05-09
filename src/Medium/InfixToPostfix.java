package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


/**
 * cases that don't work here
 * -a-b
 * ()
 */

public class InfixToPostfix {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        InfixToPostfix obj=new InfixToPostfix();
        String s=br.readLine();
        System.out.println(obj.solve(s));
    }
    public String solve(String A) {
        String B="("+A+")";
        Stack<StringBuilder> s=new Stack<>();
        Stack<Character> op=new Stack<>();
        for(int i=0;i<B.length();i++){
            char ch=B.charAt(i);
            if(isOperator(ch)){
                while(!op.isEmpty() && precedence(op.peek())>=precedence(ch)){
                    StringBuilder s1=s.pop();
                    StringBuilder s2=s.pop();
                    s2.append(s1).append(op.pop());
                    s.push(s2);
                }
                op.push(ch);
            }else if(ch=='(')
                op.push(ch);
            else if(ch==')'){
                while(!op.isEmpty() && op.peek()!='('){
                    StringBuilder s1=s.pop();
                    StringBuilder s2=s.pop();
                    s2.append(s1).append(op.pop());
                    s.push(s2);
                }
                op.pop();
            }else
                s.push(new StringBuilder(String.valueOf(ch)));
        }
        return s.pop().toString();
    }
    private boolean isOperator(char ch){
        return ch=='+' || ch=='-' || ch=='*' || ch=='/' || ch=='^';
    }

    private int precedence(char ch) {
        switch (ch) {
            case '+':
                return 1;
            case '-':
                return 1;
            case '*':
                return 2;
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return 0;
        }
    }
}
