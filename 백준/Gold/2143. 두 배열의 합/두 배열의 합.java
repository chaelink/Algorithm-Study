
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] b = new int[m];
        st = new StringTokenizer(br.readLine()); // 꼭 새로 초기화해야 함
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        // 부분합 개수 저장용 해시맵
        Map<Integer, Integer> mapA = new HashMap<>();
        Map<Integer, Integer> mapB = new HashMap<>();

        // A의 부분합 저장
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += a[j];
                mapA.put(sum, mapA.getOrDefault(sum, 0) + 1);
            }
        }

        // B의 부분합 저장
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = i; j < m; j++) {
                sum += b[j];
                mapB.put(sum, mapB.getOrDefault(sum, 0) + 1);
            }
        }

        // 조건에 맞는 쌍의 수 계산
        long count = 0;
        for (Map.Entry<Integer, Integer> entry : mapA.entrySet()) {
            int sumA = entry.getKey();
            int countA = entry.getValue();
            int needB = t - sumA;

            if (mapB.containsKey(needB)) {
                count += (long) countA * mapB.get(needB);  // 반드시 long 변환 필요
            }
        }

        System.out.println(count);
    }
}
