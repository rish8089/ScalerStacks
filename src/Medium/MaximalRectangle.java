package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class MaximalRectangle {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String []nm=br.readLine().split(" ");
        int n=Integer.parseInt(nm[0]);
        int m=Integer.parseInt(nm[1]);
        ArrayList<ArrayList<Integer>> A=new ArrayList<>();
        for(int i=0;i<n;i++){
            String []str=br.readLine().split(" ");
            ArrayList<Integer> B=new ArrayList<>();
            for(int j=0;j<m;j++)
                B.add(Integer.parseInt(str[j]));
            A.add(B);
        }
        MaximalRectangle obj=new MaximalRectangle();
        System.out.println(obj.solve(A));
    }
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int n=A.size();
        int m=A.get(0).size();
        int i=0;
        int ans=0;
        int []col=new int[m];
        Arrays.fill(col,-1);
        while(i<n){
            ArrayList<Integer> B=new ArrayList<>();
            for(int j=0;j<m;j++){
                if(col[j]<i){
                    int k=i;
                    while(k<n && A.get(k).get(j)==1)
                        k++;
                    col[j]=k-1;
                }
                B.add(col[j]-i+1);
            }
            ans=Math.max(ans,largestRectangleArea(B));
            i++;
        }
        return ans;
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
