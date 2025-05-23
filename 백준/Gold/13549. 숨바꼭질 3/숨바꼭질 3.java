import java.io.*;
import java.util.*;

public class Main {
    static int MAX = 100_001;
    static int[] time = new int[MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        Arrays.fill(time, -1);
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(start);
        time[start] = 0;

        while (!dq.isEmpty()) {
            int now = dq.poll();

            if (now * 2 < MAX && time[now * 2] == -1) {
                time[now * 2] = time[now];
                dq.offerFirst(now * 2);
            }

            if (now - 1 >= 0 && time[now - 1] == -1) {
                time[now - 1] = time[now] + 1;
                dq.offerLast(now - 1);
            }

            if (now + 1 < MAX && time[now + 1] == -1) {
                time[now + 1] = time[now] + 1;
                dq.offerLast(now + 1);
            }
        }

        System.out.println(time[target]);
    }
}
