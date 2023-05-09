package Medium;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class DoubleCharacterTrouble {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        DoubleCharacterTrouble dct=new DoubleCharacterTrouble();
        String s=br.readLine();
        System.out.println(dct.solve(s));
    }
    public String solve(String A) {
        Stack<Character> s=new Stack<>();
        for(int i=0;i<A.length();i++){
            char ch=A.charAt(i);
            if(!s.isEmpty() && s.peek()==ch){
                s.pop();
            }else{
                s.push(ch);
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!s.isEmpty()){
            sb.append(s.pop());
        }
        return sb.reverse().toString();
    }
}
