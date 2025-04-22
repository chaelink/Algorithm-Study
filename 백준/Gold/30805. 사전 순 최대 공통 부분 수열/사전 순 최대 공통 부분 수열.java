import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) A[i] = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        int[] B = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) B[i] = Integer.parseInt(st.nextToken());

        List<Integer> result = new ArrayList<>();
        int idxA = 0, idxB = 0;

        while (idxA < n && idxB < m) {
            int max = -1;
            int nextA = -1, nextB = -1;

            // A에서 idxA부터 끝까지 돌면서
            for (int i = idxA; i < n; i++) {
                // B에서 idxB부터 끝까지 찾기
                for (int j = idxB; j < m; j++) {
                    if (A[i] == B[j]) {
                        if (A[i] > max) {
                            max = A[i];
                            nextA = i;
                            nextB = j;
                        }
                        break; // 첫 등장만 보면 됨
                    }
                }
            }

            if (max == -1) break; // 공통 부분 수열 끝
            result.add(max);
            idxA = nextA + 1;
            idxB = nextB + 1;
        }

  
        System.out.println(result.size());
        if (!result.isEmpty()) {
            for (int num : result) {
                System.out.print(num + " ");
            }
        }
    }
}
