import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[][] arr = new int[n][3];
        int[][] dpMax = new int[n][3];
        int[][] dpMin = new int[n][3];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 방향 벡터: 왼쪽, 그대로, 오른쪽
        int[] dx = {-1, 0, 1};

        // 초기값 설정
        for (int j = 0; j < 3; j++) {
            dpMax[0][j] = arr[0][j];
            dpMin[0][j] = arr[0][j];
        }

        // DP 계산
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                int maxVal = Integer.MIN_VALUE;
                int minVal = Integer.MAX_VALUE;

                for (int d = 0; d < 3; d++) {
                    int prev = j + dx[d];
                    if (prev >= 0 && prev <= 2) {
                        maxVal = Math.max(maxVal, dpMax[i - 1][prev]);
                        minVal = Math.min(minVal, dpMin[i - 1][prev]);
                    }
                }

                dpMax[i][j] = maxVal + arr[i][j];
                dpMin[i][j] = minVal + arr[i][j];
            }
        }

        int max = Math.max(Math.max(dpMax[n - 1][0], dpMax[n - 1][1]), dpMax[n - 1][2]);
        int min = Math.min(Math.min(dpMin[n - 1][0], dpMin[n - 1][1]), dpMin[n - 1][2]);

        System.out.println(max + " " + min);
    }
}
