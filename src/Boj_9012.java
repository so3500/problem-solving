
//https://www.acmicpc.net/problem/9012
//Stack
// 괄호

import java.io.IOException;
import java.util.EmptyStackException;
import java.util.Scanner;
import java.io.File;
import java.util.Stack;

public class Boj_9012 {

    public enum State { YES, NO }

    private static State solve(String str, State state){
        Stack<Integer> stack = new Stack<>();
        try {
            for (int i=0; i<str.length(); i++){
                if (str.charAt(i) == '(')
                    stack.push(1);
                else
                    stack.pop();
            }
        }
        // ( 가 없는데 ) 를 시도하면 올바르지 않은 괄호 문자열
        catch (EmptyStackException e) {
            state = State.NO;
        }
        finally {
            // ( 혹은 ) 가 하나라도 남아있을 경우 올바르지 않은 괄호 문자열
            if (!stack.isEmpty()){
                state = State.NO;
            }
        }
        return state;
    }

    public static void main(String args[]) throws NumberFormatException, IOException{
//        File f = new File("input.txt");
//        Scanner scanner = new Scanner(f);
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        State state;
        String str;
        for (int i=0; i<N; i++){
            state = State.YES;
            str = scanner.nextLine();
            System.out.println(solve(str, state));
        }
    }
}
