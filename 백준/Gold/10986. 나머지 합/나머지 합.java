import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 준비
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());  // 수열 길이
        int m = Integer.parseInt(st.nextToken());  // 나누는 수

        long[] prefixModCount = new long[m];       // 나머지별 개수 저장
        long sum = 0;                               // 누적합
        long result = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            sum += num;
            int mod = (int)(sum % m);

            // 음수 나머지 방지
            if (mod < 0) mod += m;

            // 자기 자신이 나머지 0이면 정답에 포함
            if (mod == 0) result++;

            // 해당 나머지를 가진 구간 개수만큼 결과 증가
            result += prefixModCount[mod];

            // 현재 나머지 개수 증가
            prefixModCount[mod]++;
        }

        System.out.println(result);
    }
}
