import java.util.*;

public class Main {
    static boolean[] visited;
    static int[] arr;
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {

            int n = sc.nextInt();
            arr = new int[n+1];
            visited = new boolean[n+1]; //이미 사이클에 속해있는 수인지 체크

            int count = 0;

            for (int j = 1; j <= n; j++) {  //순열 입력받기
                arr[j] = sc.nextInt();
            }

            for (int j = 1; j <= n; j++) {
                if(!visited[j]) {
                    check(j);
                    count++;

                }
                
            }
            System.out.println(count);
        }
    }

    public static void check(int n) {
        if(!visited[n]) {
            visited[n] = true;
            check(arr[n]);
        } 
    }
}
