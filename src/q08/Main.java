import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String line = br.readLine();

            if (line.startsWith("PUSH")) {
                int val = Integer.parseInt(line.split(" ")[1]);
                stack.push(val);
            } 
            else if (line.equals("POP")) {
                if (stack.isEmpty()) {
                    output.append("EMPTY\n");
                } else {
                    output.append(stack.pop()).append("\n");
                }
            } 
            else if (line.equals("PEEK")) {
                if (stack.isEmpty()) {
                    output.append("EMPTY\n");
                } else {
                    output.append(stack.peek()).append("\n");
                }
            } 
            else if (line.equals("SIZE")) {
                output.append(stack.size()).append("\n");
            }
        }

        // Print final output (no extra blank line)
        System.out.print(output.toString().trim());
    }
}
   
