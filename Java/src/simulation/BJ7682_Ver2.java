package simulation;

import java.io.*;

public class BJ7682_Ver2 {
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
        boolean flag = false; // sb 입력되었는지 아닌지 판단
        // 칸이 다 채워짐 & X : 5개, O : 4개
        if (Ocnt + Xcnt == 9 && Xcnt == Ocnt + 1) {
            flag = true;
            if (Oflag && Xflag) sb.append("invalid" + "\n"); // 둘 다 이길 때
            else if (Oflag && !Xflag) sb.append("invalid" + "\n"); // O가 이길 때
            else sb.append("valid" + "\n"); // 승부 x, X승
        } // 말이 아직 남아있을 때
        else {
            if (Xcnt == Ocnt + 1) { // X의 개수가 O의 개수보다 하나 많을 경우
                flag = true;
                if (Xflag && !Oflag) sb.append("valid" + "\n"); // X만 이겼을 때 valid
                else sb.append("invalid" + "\n");
            } else if (Xcnt == Ocnt) { // X의 개수 == O의 개수
                flag = true;
                if (Oflag && !Xflag) sb.append("valid" + "\n"); // O만 이겼을 때
                else sb.append("invalid" + "\n");
            }
        }
        // 다 채워졌는데 개수 안 맞는 경우, 덜 채웠는데 개수 안 맞는 경우
        if (!flag) sb.append("invalid" + "\n");
    }
}