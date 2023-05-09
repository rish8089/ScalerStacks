package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class AllSubarrays {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String []str=br.readLine().split(" ");
        ArrayList<Integer> A=new ArrayList<>();
        for(int i=0;i<n;i++)
            A.add(Integer.parseInt(str[i]));
        AllSubarrays obj=new AllSubarrays();
        System.out.println(obj.solve(A));
    }
    public int solve(ArrayList<Integer> A) {
        Stack<Integer> s=new Stack<>();
        int ans=0;
        for(int i=0;i<A.size();i++){
            int val=A.get(i);
            while(!s.isEmpty() && s.peek()<=val){
                ans=Math.max(ans,s.peek()^val);
                s.pop();
            }
            if(!s.isEmpty()){
                ans=Math.max(ans,s.peek()^val);
            }
            s.push(val);
        }
        return ans;
    }
}
