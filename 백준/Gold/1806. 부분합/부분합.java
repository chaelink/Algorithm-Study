import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i]  = Integer.parseInt(st.nextToken());
        }
        
        int left=0, right=0, sum=0, Len = Integer.MAX_VALUE;
        
        while (true) {
            if(sum>=s) {
                Len = Math.min(Len, right-left);
                sum -= arr[left++];
            } else if (right==n) {
                break;
            } else {
                sum += arr[right++];
            }
        }
        
        System.out.println(Len == Integer.MAX_VALUE ? 0 : Len);
    }
}
