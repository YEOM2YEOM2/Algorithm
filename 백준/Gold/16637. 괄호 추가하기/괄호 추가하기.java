import java.io.*;

public class Main {
    static int N;
    static int ans = Integer.MIN_VALUE;
    static String[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().strip());
        input = br.readLine().strip().split("");
        dfs(Integer.parseInt(input[0]), 1);
        System.out.println(ans);
    }

    private static void dfs(int sum, int idx) {
        if (idx == N) {
            ans = Math.max(ans, sum);
            return;
        }

        if (input[idx].equals("+")) {
            dfs(sum + Integer.parseInt(input[idx + 1]), idx + 2); // 괄호 안 묶음.
            if (idx + 2 < N) { // 괄호 묶음.
                if (input[idx + 2].equals("+")) dfs(sum + (Integer.parseInt(input[idx + 1]) + Integer.parseInt(input[idx + 3])), idx + 4);
                else if (input[idx + 2].equals("-")) dfs(sum + (Integer.parseInt(input[idx + 1]) - Integer.parseInt(input[idx + 3])), idx + 4);
                else dfs(sum + (Integer.parseInt(input[idx + 1]) * Integer.parseInt(input[idx + 3])), idx + 4);
            }
        } else if (input[idx].equals("-")) {
            dfs(sum - Integer.parseInt(input[idx + 1]), idx + 2); // 괄호 안 묶음.
            if (idx + 2 < N) { // 괄호 묶음.
                if (input[idx + 2].equals("+")) dfs(sum - (Integer.parseInt(input[idx + 1]) + Integer.parseInt(input[idx + 3])), idx + 4);
                else if (input[idx + 2].equals("-")) dfs(sum - (Integer.parseInt(input[idx + 1]) - Integer.parseInt(input[idx + 3])), idx + 4);
                else dfs(sum - (Integer.parseInt(input[idx + 1]) * Integer.parseInt(input[idx + 3])), idx + 4);
            }
        } else { // 곱하기
            dfs(sum * Integer.parseInt(input[idx + 1]), idx + 2); // 괄호 안 묶음.
            if (idx + 2 < N) { // 괄호 묶음.
                if (input[idx + 2].equals("+")) dfs(sum * (Integer.parseInt(input[idx + 1]) + Integer.parseInt(input[idx + 3])), idx + 4);
                else if (input[idx + 2].equals("-")) dfs(sum * (Integer.parseInt(input[idx + 1]) - Integer.parseInt(input[idx + 3])), idx + 4);
                else dfs(sum * (Integer.parseInt(input[idx + 1]) * Integer.parseInt(input[idx + 3])), idx + 4);
            }
        }
    }
}