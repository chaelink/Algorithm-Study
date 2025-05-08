
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<String[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            String[] path = new String[k];
            for (int j = 0; j < k; j++) {
                path[j] = st.nextToken();
            }
            list.add(path);
        }

        // 사전순 정렬
        list.sort((a, b) -> {
            int len = Math.min(a.length, b.length);
            for (int i = 0; i < len; i++) {
                int cmp = a[i].compareTo(b[i]);
                if (cmp != 0) return cmp;
            }
            return a.length - b.length;
        });

        // 출력
        for (int i = 0; i < list.size(); i++) {
            String[] now = list.get(i);
            int depth = 0;

            if (i == 0) {
                for (String s : now) {
                    printWithDash(depth++, s);
                }
            } else {
                String[] prev = list.get(i - 1);
                int same = 0;

                // 공통된 접두어 길이 찾기
                while (same < now.length && same < prev.length && now[same].equals(prev[same])) {
                    same++;
                }

                for (int j = same; j < now.length; j++) {
                    printWithDash(j, now[j]);
                }
            }
        }
    }

    static void printWithDash(int depth, String str) {
        for (int i = 0; i < depth; i++) {
            System.out.print("--");
        }
        System.out.println(str);
    }
}
