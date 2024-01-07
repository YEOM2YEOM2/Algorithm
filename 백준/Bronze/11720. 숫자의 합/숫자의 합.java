import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        scan.nextLine();
        String num = scan.nextLine();
        String[] nums = num.split("");

        int sum = 0;
        for (String s : nums) {
            sum += Integer.parseInt(s);
        }

        System.out.println(sum);
    }
}
