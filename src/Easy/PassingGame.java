package Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class PassingGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String []AB=br.readLine().split(" ");
        int A=Integer.parseInt(AB[0]);
        int B=Integer.parseInt(AB[1]);
        ArrayList<Integer> C=new ArrayList<>();
        String []str=br.readLine().split(" ");
        for(int i=0;i<A;i++)
            C.add(Integer.parseInt(str[i]));
        PassingGame obj=new PassingGame();
        System.out.println(obj.solve(A,B,C));
    }
    public int solve(int A, int B, ArrayList<Integer> C) {
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<A;i++){
            int val=C.get(i);
            if(val==0){
                B=s.pop();
            }else{
                s.push(B);
                B=val;
            }
        }
        return B;
    }
}
