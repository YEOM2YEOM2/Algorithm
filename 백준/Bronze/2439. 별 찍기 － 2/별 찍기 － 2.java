import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().strip());

        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) System.out.print(" ");
            for (int j = 1; j < N - i + 1; j++) System.out.print("*");
            System.out.println();
        }
    }
}