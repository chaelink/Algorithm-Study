import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());  // 먼저 n을 입력받고
        int[] line = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());  // 정수 배열 입력

        for(int i = 0; i < n; i++) {
            line[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(line);
        int[] sum = new int[n];
        
        sum[0] = line[0];
        int result =0;
        result += sum[0];
        for(int i = 1; i < n; i++) {
            sum[i] = sum[i-1] + line[i];
            result += sum[i];
        }

        System.out.println(result);
    }
}
