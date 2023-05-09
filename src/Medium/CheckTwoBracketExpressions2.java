package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class CheckTwoBracketExpressions2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        CheckTwoBracketExpressions2 obj = new CheckTwoBracketExpressions2();
        String s1 = br.readLine();
        String s2 = br.readLine();
        System.out.println(obj.solve(s1, s2));
    }
    public int solve(String A, String B) {
        char []hash1=new char[26];
        calculateSigns(A,hash1);
        char []hash2=new char[26];
        calculateSigns(B,hash2);
        for(int i=0;i<26;i++){
            if(hash1[i]!=hash2[i])
                return 0;
        }
        return 1;
    }
    private void calculateSigns(String A, char []hash){
        int cnt=0;
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<A.length();i++){
            char ch=A.charAt(i);
            if(ch=='('){
                if(i-1>=0 && A.charAt(i-1)=='-')
                    cnt++;
                s.push(i);
            }else if(ch==')'){
                int pos=s.pop();
                if(pos-1>=0 && A.charAt(pos-1)=='-')
                    cnt--;
            }else if(!isOperator(ch)){
                int noOfMinusSigns=cnt;
                if(i-1>=0 && A.charAt(i-1)=='-')
                    noOfMinusSigns++;
                hash[ch-'a']=noOfMinusSigns%2==0?'+':'-';
            }
        }
    }
    private boolean isOperator(char ch) {
        return ch == '+' || ch == '-';
    }
}
