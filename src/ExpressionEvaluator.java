import java.util.Scanner;
import java.util.Stack;

public class ExpressionEvaluator {
    public static char reverse(char c){
        if(c == '}'){
            return '{';
        } else if(c == ']'){
            return '[';
        } else if(c == ')'){
            return '(';
        } else return ' ';
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String exp = scan.nextLine();
        System.out.println("Your expression is: " + exp);

        char[] expArr = exp.toCharArray();
        Stack<Character> stack = new Stack<>();

        for(int i=0; i < expArr.length; i++){
            if(stack.isEmpty() && (expArr[i] == '{' || expArr[i] == '[' || expArr[i] == '('))
                stack.push(expArr[i]);
            else{
                if(expArr[i] == '{' || expArr[i] == '[' || expArr[i] == '('){
                    stack.push(expArr[i]);
                } else if(expArr[i] == '}' || expArr[i] == ']' || expArr[i] == ')'){
                    if(!(stack.isEmpty()) && stack.peek() == reverse(expArr[i])){
                        stack.pop();
                    } else stack.push(expArr[i]);
                }
            }
        }

        if(stack.isEmpty()) System.out.println("Expression is valid!");
        else System.out.println("Expression is not valid!");

    }
}
