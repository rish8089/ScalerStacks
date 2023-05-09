package Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BalancedParanthesis {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BalancedParanthesis obj=new BalancedParanthesis();
        String s=br.readLine();
        System.out.println(obj.solve(s));
    }
    public int solve(String A) {
        Stack<Character> s=new Stack<>();
        for(int i=0;i<A.length();i++){
            char ch=A.charAt(i);
            if(isClosing(ch)){
                char open=getOpen(ch);
                if(s.isEmpty() || open!=s.peek())
                    return 0;
                s.pop();
            }else{
                s.push(ch);
            }
        }
        return s.isEmpty()?1:0;
    }
    private boolean isClosing(char ch){
        return ch==')' || ch=='}' || ch==']';
    }
    private char getOpen(char ch){
        if(ch==')')
            return '(';
        else if(ch=='}')
            return '{';
        else
            return '[';
    }
}
