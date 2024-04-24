import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().strip());
        String baseWord = br.readLine().strip();
        int[] baseCnt = new int[26];
        count(baseCnt, baseWord);

        int cnt = 0;
        for (int i = 1; i < N; i++) {
            String word = br.readLine().strip();
            int[] wordCnt = new int[26];
            count(wordCnt, word);

            int diff = 0;
            for (int j = 0; j < 26; j++) {
                diff += Math.abs(baseCnt[j] - wordCnt[j]);
            }

            if (diff <= 1) cnt++;
            else if (diff == 2 && baseWord.length() == word.length()) cnt++;
        }
        System.out.println(cnt);
    }

    private static void count(int[] arr, String word) {
            for (int i = 0; i < word.length(); i++) arr[word.charAt(i) - 65]++;
    }
}