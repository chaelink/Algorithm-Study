import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        List<List<Integer>> arr = new ArrayList<>();
        
        for(int i=0; i<=n; i++) {
            arr.add(new ArrayList<>());
        }
        
        StringTokenizer st;
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.get(a).add(b);
            arr.get(b).add(a);
        }
        
        int[] visited = new int[n+1];
        Queue<Integer> q = new ArrayDeque<>();
        
        visited[1] = 1;
        q.add(1);
        int result = -1;
        while(!q.isEmpty()) {
            int now = q.remove();
            result++;
            
            for(Integer i : arr.get(now)) {
                if(visited[i]!=1) {
                    q.add(i);
                    visited[i]=1;
                }
            }
        }
        System.out.println(result);
    }
}
        