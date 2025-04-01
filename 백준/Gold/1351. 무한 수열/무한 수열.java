import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

    static HashMap<Long, Long> map = new HashMap<>();
    static long p;
    static long q;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        p = Long.parseLong(st.nextToken());
        q = Long.parseLong(st.nextToken());

        map.put(0L,1L);
        
        System.out.println(solve(n));
        
    }

    static long solve(long num) {
        if(map.containsKey(num)) {
            return map.get(num);
        }

        long a = (long)Math.floor(num/p);
        long b = (long)Math.floor(num/q);

        map.put(num, solve(a)+solve(b));
        return map.get(num);
    }
}
