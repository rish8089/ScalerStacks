package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class CheckTwoBracketExpressions {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        CheckTwoBracketExpressions obj = new CheckTwoBracketExpressions();
        String s1 = br.readLine();
        String s2 = br.readLine();
        System.out.println(obj.solve(s1, s2));
    }

    public int solve(String A, String B) {
        String res1 = simplify(A);
        String res2 = simplify(B);
        char []hash1=new char[26];
        char []hash2=new char[26];
        for (int i = 0; i < res1.length(); i++) {
            char ch = res1.charAt(i);
            if (!isOperator(ch)) {
                if (i == 0)
                    hash1[ch - 'a'] = '+';
                else
                    hash1[ch - 'a'] = res1.charAt(i - 1);
            }
        }
        for (int i = 0; i < res2.length(); i++) {
            char ch = res2.charAt(i);
            if (!isOperator(ch)) {
                if (i == 0)
                    hash2[ch - 'a'] = '+';
                else
                    hash2[ch - 'a'] = res2.charAt(i - 1);
            }
        }
        for(int i=0;i<26;i++){
            if(hash1[i]!=hash2[i])
                return 0;
        }
        return 1;
    }

    public String simplify(String A) {
        String B = "(" + A + ")";
        Stack<StringBuilder> s = new Stack<>();
        for (int i = 0; i < B.length(); i++) {
            char ch = B.charAt(i);
            if (ch == ')') {
                StringBuilder res = new StringBuilder();
                while (!s.isEmpty() && !s.peek().toString().equals("(")) {
                    StringBuilder s1 = s.pop();
                    if (!s.peek().toString().equals("(")) {
                        StringBuilder res1 = new StringBuilder();
                        char op = s.pop().charAt(0);
                        for (int j = 0; j < s1.length(); j++) {
                            char ch2 = s1.charAt(j);
                            if (isOperator(ch2)) {
                                res1.append(getResult(op, ch2));
                            } else {
                                if (j == 0)
                                    res1.append(op);
                                res1.append(ch2);
                            }
                        }
                        res = res1.append(res);
                    } else
                        res = s1.append(res);
                }
                s.pop();
                s.push(res);
            } else {
                s.push(new StringBuilder(String.valueOf(ch)));
            }
        }
        return s.pop().toString();
    }

    private boolean isOperator(char ch) {
        return ch == '+' || ch == '-';
    }

    private char getResult(char c1, char c2) {
        if (c1 == '+') {
            if (c2 == '+')
                return '+';
            else
                return '-';
        } else {
            if (c2 == '+')
                return '-';
            else
                return '+';
        }
    }
}
