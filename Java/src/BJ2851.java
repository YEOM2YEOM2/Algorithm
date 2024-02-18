import java.io.*;

public class BJ2851 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int ans = 0;
        for (int i = 0; i < 10; i++) {
            int temp = Integer.parseInt(br.readLine());
            if (Math.abs(100 - ans - temp) <= Math.abs(100 - ans)) {
                ans += temp;
            } else {
                break;
            }
        }
        System.out.println(ans);
    }
}
