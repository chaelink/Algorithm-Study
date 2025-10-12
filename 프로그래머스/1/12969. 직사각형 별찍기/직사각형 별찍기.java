import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt();
        StringBuilder row = new StringBuilder();
        for (int i = 0; i < a; i++) row.append('*');
        for (int i = 0; i < b; i++) System.out.println(row);
    }
}
