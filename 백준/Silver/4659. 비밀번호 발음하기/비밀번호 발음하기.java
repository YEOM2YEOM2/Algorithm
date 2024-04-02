import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = br.readLine().strip();
            if (input.equals("end")) break;

            boolean[] flag = {false, true, true};
            // [1] 모음 하나이상 포함 & [2] 모음, 자음 연속 3개 x
            int cntC = 0;
            int cntV = 0;
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == 'a' || input.charAt(i) == 'e' || input.charAt(i) == 'i' || input.charAt(i) == 'o' || input.charAt(i) == 'u') {
                    cntC = 0;
                    cntV++;
                    flag[0] = true;
                } else {
                    cntC++;
                    cntV = 0;
                }

                if (cntC >= 3 || cntV >= 3) {
                    flag[1] = false;
                    break;
                }
            }
            // [3] 같은 글자 연속 x
            for (int i = 0; i < input.length() - 1; i++) {
                if (input.charAt(i) == input.charAt(i + 1)) {
                    if (input.charAt(i) == 'e' || input.charAt(i) == 'o') continue;
                    flag[2] = false;
                    break;
                }
            }

            boolean isAccept = true;
            for (int i = 0; i < 3; i++) if (!flag[i]) isAccept = false;

            if (isAccept) System.out.println("<" + input + "> is acceptable.");
            else System.out.println("<" + input + "> is not acceptable.");
        }
    }
}