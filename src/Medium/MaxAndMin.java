package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class MaxAndMin {
    private int MOD=1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String []str=br.readLine().split(" ");
        ArrayList<Integer> A=new ArrayList<>();
        for(int i=0;i<n;i++)
            A.add(Integer.parseInt(str[i]));
        MaxAndMin obj=new MaxAndMin();
        System.out.println(obj.solve(A));
    }
    public int solve(ArrayList<Integer> A) {
        //calculating right side max contributions
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
        int []rightMaxSpan=new int[n];
        for(int i=0;i<n;i++){
            int val=A.get(i);
            while(!s.isEmpty() && A.get(s.peek())<val){
                int pos=s.pop();
                rightMaxSpan[pos]=i-pos;
            }
            s.push(i);
        }
        while(!s.isEmpty()){
            int pos=s.pop();
            rightMaxSpan[pos]=n-pos;
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

        int []leftMaxSpan=new int[n];
        for(int i=n-1;i>=0;i--){
            int val=A.get(i);
            while(!s.isEmpty() && A.get(s.peek())<val){
                int pos=s.pop();
                leftMaxSpan[pos]=pos-i;
            }
            s.push(i);
        }
        while(!s.isEmpty()){
            int pos=s.pop();
            leftMaxSpan[pos]=pos+1;
        }
        int maxSum=0;
        int minSum=0;
        for(int i=0;i<n;i++){
            int val=A.get(i);
            long maxRange=(long)leftMaxSpan[i]*rightMaxSpan[i];
            long minRange=(long)leftMinSpan[i]*rightMinSpan[i];
            maxSum = (int) ((maxSum + ((long) maxRange * val) % MOD) % MOD);
            minSum = (int) ((minSum + ((long) minRange * val) % MOD) % MOD);
        }
        return (maxSum-minSum+MOD)%MOD;
    }
}
