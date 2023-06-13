package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// Infix -> 중위표기법
// Postfix -> 후위표기법
public class InfixToPostfix {
    // 연산자인지 검증하는 메소드
    // 스택 내부에서의 우선순위
    private int inStackPriority(char operator){
        if (operator == '+' || operator == '-') return 1;
        else if (operator == '*' || operator == '/') return 2;
        else if (operator == '(') return 0;
        else throw new IllegalArgumentException("not allowed argument");
    }
    // 스택 외부에서의 우선순위
    private int inComingPriority(char operator) {
        if (operator == '+' || operator == '-') return 1;
        else if (operator == '*' || operator == '/') return 2;
        else if (operator == '(') return 3;
        else throw new IllegalArgumentException("not allowed argument");
    }

    private boolean isOperator(char token) {
        return token == '(' || token == '+' || token == '-' || token == '*' || token == '/';
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        // 결과를 담아둘 StringBuilder
        StringBuilder answerBuilder = new StringBuilder();
        // 연산자 담는 스택 ( 연산자 = operator )
        Stack<Character> operStack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char token = input.charAt(i);
            // 연산자일때
            if (isOperator(token)) {
                if (operStack.empty()) {
                    operStack.push(token);
                } else {
                    while (inStackPriority(operStack.peek()) >= inComingPriority(token)) {
                        answerBuilder.append(operStack.pop());
                        if (operStack.empty()) break;
                    }
                    operStack.push(token);
                }
            }
            // 닫는 괄호일 때
            else if (token == ')') {
                char top = operStack.pop();
                while (top != '('){
                    answerBuilder.append(top);
                    top = operStack.pop();
                }
            }
            // 숫자의 경우 바로 출력
            else answerBuilder.append(token);
        }
        while (!operStack.empty()){
            answerBuilder.append(operStack.pop());
        }
        System.out.println(answerBuilder);
    }

    public static void main(String[] args) throws IOException {
        new InfixToPostfix().solution();
    }
}
