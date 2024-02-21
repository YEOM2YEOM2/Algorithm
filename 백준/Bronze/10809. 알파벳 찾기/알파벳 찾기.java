import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        for (int i = 97; i < 123; i++) {
            System.out.print(word.indexOf((char) i) + " ");
        }
    }
}