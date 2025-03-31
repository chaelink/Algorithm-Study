import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < l; i++) {
            String num = br.readLine(); 
            if(map.containsKey(num)) {
                map.remove(num);
            }
            map.put(num, i);
        }

        int count = 0;
        for(String key : map.keySet()) {
            System.out.println(key);
            count++;
            if(count == k) break;
        }
    }
}
