package Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class EvaluateExpression {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        EvaluateExpression obj=new EvaluateExpression();
        ArrayList<String> A=new ArrayList<>();
        int n=Integer.parseInt(br.readLine());
        String []str=br.readLine().split(" ");
        for(int i=0;i<n;i++){
            A.add(str[i]);
        }
        System.out.println(obj.evalRPN(A));
    }
    public int evalRPN(ArrayList<String> A) {
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<A.size();i++){
            String val=A.get(i);
            if(isOperator(val)){
                int a=s.pop();
                int b=s.pop();
                s.push(evaluate(b,a,val));
            }else
                s.push(Integer.parseInt(val));
        }
        return s.pop();
    }
    private boolean isOperator(String A){
        return A.equals("+") || A.equals("-") || A.equals("*") || A.equals("/");
    }
    private int evaluate(int a, int b, String op){
        switch (op){
            case "+":
                return a+b;
            case "-":
                return a-b;
            case "*":
                return a*b;
            case "/":
                return a/b;
            default:
                return 0;
        }
    }
}
