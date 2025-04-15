import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        TreeSet<Integer> set = new TreeSet<>();

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int I  = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            for(int j=0; j<c; j++) {
                int now = s + I*j;
                if(now >= t) {
                    set.add(now);
                    break;
                }
            }
        }
        if(set.isEmpty()) {
            System.out.println(-1);
        } else {
            int f = set.first();
            if(f == t) System.out.println(0);
            else System.out.println(f-t);
        }
    }
}
