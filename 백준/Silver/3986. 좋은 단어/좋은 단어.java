import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine().strip());
        int ans = 0;
        for (int i = 0; i < N; i++) {
            String input = br.readLine().strip();
            Stack<Character> stack = new Stack<>();
            for (int j = 0; j < input.length(); j++) {
                if (stack.isEmpty()) stack.push(input.charAt(j));
                else {
                    if (stack.peek() == input.charAt(j)) stack.pop();
                    else stack.push(input.charAt(j));
                }
            }

            if (stack.isEmpty()) ans++;
        }
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
}