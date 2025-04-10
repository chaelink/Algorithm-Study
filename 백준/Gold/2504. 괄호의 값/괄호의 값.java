import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        Stack<Character> stack = new Stack<>();
        int result = 0;
        int temp = 1;
        boolean valid = true;

        for (int i = 0; i < input.length(); i++) {
            char now = input.charAt(i);

            if (now == '(') {
                stack.push(now);
                temp *= 2;
            } else if (now == '[') {
                stack.push(now);
                temp *= 3;
            } else if (now == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    valid = false;
                    break;
                }

                if (input.charAt(i - 1) == '(') {
                    result += temp;
                }
                stack.pop();
                temp /= 2;
            } else if (now == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    valid = false;
                    break;
                }

                if (input.charAt(i - 1) == '[') {
                    result += temp;
                }
                stack.pop();
                temp /= 3;
            }
        }

        if (!valid || !stack.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }
    }
}
