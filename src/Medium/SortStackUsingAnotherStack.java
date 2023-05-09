package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class SortStackUsingAnotherStack {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String []str=br.readLine().split(" ");
        ArrayList<Integer> A=new ArrayList<>();
        for(int i=0;i<n;i++)
            A.add(Integer.parseInt(str[i]));
        SortStackUsingAnotherStack obj=new SortStackUsingAnotherStack();
        ArrayList<Integer> res=obj.solve(A);
        for(Integer element:res)
            System.out.print(element+ " ");
    }
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        Stack<Integer> s=new Stack<>();
        Stack<Integer> temp=new Stack<>();
        for(int i=0;i<A.size();i++){
            int val=A.get(i);
            while(!s.isEmpty() && s.peek()>val){
                temp.push(s.pop());
            }
            s.push(val);
            while(!temp.isEmpty())
                s.add(temp.pop());
        }
        ArrayList<Integer> res=new ArrayList<>();
        for(int i=0;i<A.size();i++)
            res.add(0);
        int i=A.size()-1;
        while(!s.isEmpty()) {
            res.set(i,s.pop());
            i--;
        }
        return res;
    }
}
