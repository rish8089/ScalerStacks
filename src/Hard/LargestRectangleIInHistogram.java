package Hard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class LargestRectangleIInHistogram {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String []str=br.readLine().split(" ");
        ArrayList<Integer> A=new ArrayList<>();
        for(int i=0;i<n;i++)
            A.add(Integer.parseInt(str[i]));
        LargestRectangleIInHistogram obj=new LargestRectangleIInHistogram();
        System.out.println(obj.largestRectangleArea(A));
    }
    public int largestRectangleArea(ArrayList<Integer> A) {
        int n=A.size();
        int []rightMinSpan=new int[n];
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<n;i++){
            int val=A.get(i);
            while(!s.isEmpty() && A.get(s.peek())>val){
                int pos=s.pop();
                rightMinSpan[pos]=i-pos;
            }
            s.push(i);
        }
        while(!s.isEmpty()){
            int pos=s.pop();
            rightMinSpan[pos]=n-pos;
        }
        int []leftMinSpan=new int[n];
        for(int i=n-1;i>=0;i--){
            int val=A.get(i);
            while(!s.isEmpty() && A.get(s.peek())>val){
                int pos=s.pop();
                leftMinSpan[pos]=pos-i;
            }
            s.push(i);
        }
        while(!s.isEmpty()){
            int pos=s.pop();
            leftMinSpan[pos]=pos+1;
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans=Math.max(ans,(leftMinSpan[i]+rightMinSpan[i]-1)*A.get(i));
        }
        return ans;
    }
}
