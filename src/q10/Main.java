import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().trim();

        Stack<Integer> stack = new Stack<>();

        String[] tokens = input.split("\\s+");

        for (String token : tokens) {
            // If number
            if (Character.isDigit(token.charAt(0))) {
                stack.push(Integer.parseInt(token));
            } 
            // Operator
            else {
                int b = stack.pop();
                int a = stack.pop();

                switch (token) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(a / b);
                        break;
                }
            }
        }

        // Final result
        System.out.print(stack.pop());
    }
}
