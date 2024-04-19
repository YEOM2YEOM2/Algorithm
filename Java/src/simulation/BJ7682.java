package simulation;

import java.io.*;

public class BJ7682 {
    static char[][] arr;
    static boolean Oflag, Xflag;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String temp = br.readLine().strip();
            if (temp.equals("end")) break;

            arr = new char[3][3];
            int idx = 0;
            int Ocnt = 0;
            int Xcnt = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = temp.charAt(idx);
                    if (arr[i][j] == 'O') Ocnt++;
                    else if (arr[i][j] == 'X') Xcnt++;
                    idx++;
                }
            }
            Oflag = false;
            Xflag = false;
            tictactok();
            isPossible(Ocnt, Xcnt);
        }
        sb.delete(sb.length() - 1, sb.length());
        System.out.println(sb);
    }
    private static void tictactok() {
        // 가로
        for (int i = 0; i < 3; i++) {
            boolean flag = true;
            for (int j = 1; j < 3; j++) {
                if (arr[i][j - 1] != arr[i][j]) flag = false;
            }
            if (flag) {
                if (arr[i][0] == 'O') Oflag = true;
                else if (arr[i][0] == 'X') Xflag = true;
            }
        }

        // 세로
        for (int i = 0; i < 3; i++) {
            boolean flag = true;
            for (int j = 1; j < 3; j++) {
                if (arr[j - 1][i] != arr[j][i]) flag = false;
            }
            if (flag) {
                if (arr[0][i] == 'O') Oflag = true;
                else if (arr[0][i] == 'X') Xflag = true;
            }
        }

        // 대각선
        if (arr[0][0] == arr[1][1] && arr[1][1] == arr[2][2]) {
            if (arr[1][1] == 'O') Oflag = true;
            else if (arr[1][1] == 'X') Xflag = true;
        }

        if (arr[0][2] == arr[1][1] && arr[1][1] == arr[2][0]) {
            if (arr[1][1] == 'O') Oflag = true;
            else if (arr[1][1] == 'X') Xflag = true;
        }
    }
    private static void isPossible(int Ocnt, int Xcnt) {
        if (!Oflag && !Xflag) { // 승부 x
            if (Ocnt + 1 == Xcnt && Xcnt + Ocnt == 9) sb.append("valid" + "\n");
            else sb.append("invalid" + "\n");
        } else if (Oflag && Xflag) { // 둘 다 승 ex) XXXOOOX..
            sb.append("invalid" + "\n");
        } else if (Oflag) { // 'O' 승
            if (Ocnt == Xcnt) sb.append("valid" + "\n");
            else sb.append("invalid" + "\n");
        } else if (Xflag) { // 'X' 승
            if (Ocnt + 1 == Xcnt) sb.append("valid" + "\n");
            else sb.append("invalid" + "\n");
        }
    }
}
