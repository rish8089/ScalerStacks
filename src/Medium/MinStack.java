package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class MinStack {
    Stack<Integer> s;
    Stack<Integer> ms;
    MinStack(){
       s=new Stack<>();
       ms=new Stack<>();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int q=Integer.parseInt(br.readLine());
        MinStack obj=new MinStack();
        while(q>0){
            String []str=br.readLine().split(" ");
            switch(str[0]){
                case "push":
                    int val=Integer.parseInt(str[1]);
                    obj.push(val);
                    break;
                case "pop":
                    obj.pop();
                    break;
                case "top":
                    System.out.println(obj.top());
                    break;
                case "min":
                    System.out.println(obj.getMin());
            }
            q--;
        }
    }
    public void push(int x) {
        s.push(x);
        if(ms.isEmpty() || x<=ms.peek()){
            ms.push(x);
        }
    }

    public void pop() {
        if(!s.isEmpty()) {
            int val = s.pop();
            if (val == ms.peek())
                ms.pop();
        }
    }

    public int top() {
        return s.isEmpty()?-1:s.peek();
    }

    public int getMin() {
        return ms.isEmpty()?-1:ms.peek();
    }
}
