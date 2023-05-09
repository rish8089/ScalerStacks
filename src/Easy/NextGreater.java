package Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class NextGreater {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String []str=br.readLine().split(" ");
        ArrayList<Integer> A=new ArrayList<>();
        for(int i=0;i<n;i++)
            A.add(Integer.parseInt(str[i]));
        NextGreater obj=new NextGreater();
        ArrayList<Integer> res=obj.nextGreater(A);
        for(Integer element:res)
            System.out.print(element+ " ");
    }
    public ArrayList<Integer> nextGreater(ArrayList<Integer> A) {
        ArrayList<Integer> list=new ArrayList<>();
        int n=A.size();
        for(int i=0;i<n;i++)
            list.add(-1);
        Stack<Integer> s=new Stack<>();
        for(int i=n-1;i>=0;i--){
            int val=A.get(i);
            while(!s.isEmpty() && s.peek()<=val)
                s.pop();
            if(!s.isEmpty())
                list.set(i,s.peek());
            s.push(val);
        }
        return list;
    }
}
