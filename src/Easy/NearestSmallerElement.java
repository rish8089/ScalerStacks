package Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class NearestSmallerElement {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String []str=br.readLine().split(" ");
        ArrayList<Integer> A=new ArrayList<>();
        for(int i=0;i<n;i++)
            A.add(Integer.parseInt(str[i]));
        NearestSmallerElement obj=new NearestSmallerElement();
        ArrayList<Integer> res=obj.prevSmaller(A);
        for(Integer element:res)
            System.out.print(element+ " ");
    }
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        Stack<Integer> s=new Stack<>();
        ArrayList<Integer> res=new ArrayList<>();
        for(int i=0;i<A.size();i++){
            int val=A.get(i);
            while(!s.isEmpty() && s.peek()>=val){
                s.pop();
            }
            if(!s.isEmpty())
                res.add(s.peek());
            else
                res.add(-1);
            s.push(val);
        }
        return res;
    }
}
