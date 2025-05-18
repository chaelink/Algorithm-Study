
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] num;
    static int[] arr;
    //static int[] visited = new int[10001];
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        num = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0,0);


    }

    public static void dfs(int i, int d) {
        if(d == m) {
            for(int j = 0; j < m; j++) {
                System.out.print(num[j] + " ");
            }
            System.out.println();
            return;
        }

        int sameNum = 0;
        for(int j =i ; j < n; j++) {
            if(sameNum != arr[j]) {
                num[d] = arr[j];
                sameNum = arr[j];
                dfs(j, d+1);
            }
        }
    }
}
