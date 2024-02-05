import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String word = scan.nextLine();
        int idx = scan.nextInt();
        System.out.println(word.charAt(idx-1));
    }
}
