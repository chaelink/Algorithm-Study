import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] tel = new String[n];
            for (int j = 0; j < n; j++) {
                tel[j] = br.readLine();
            }

            Arrays.sort(tel); // 사전순 정렬

            boolean check = true;
            for (int j = 0; j < n - 1; j++) {
                if (tel[j + 1].startsWith(tel[j])) {
                    check = false;
                    break;
                }
            }

            if (check) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
