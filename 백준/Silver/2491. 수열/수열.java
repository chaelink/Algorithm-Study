import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int max = 1, inc = 1, dec = 1;
        for(int i = 1; i < n; i++) {
            if(arr[i] >= arr[i-1]) {
                inc++;
            } else {
                inc = 1;
            }
            if(arr[i] <= arr[i-1]) {
                dec++;
            } else {
                dec = 1;
            }
            max = Math.max(max, Math.max(inc, dec));
        }

        System.out.println(max);
    }
}
