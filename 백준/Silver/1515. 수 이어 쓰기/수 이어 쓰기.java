import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine().strip();
        int num = 1;
        int idx = 0;
        while (idx != N.length()) {
            String number = Integer.toString(num);
            for (int i = 0; i < number.length(); i++) {
                if (N.charAt(idx) == number.charAt(i)) idx++;
                if (idx == N.length()) break;
            }
            num++;
        }
        System.out.println(num - 1);
    }
}