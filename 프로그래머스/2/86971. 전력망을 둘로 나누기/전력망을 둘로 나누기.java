import java.util.*;
class Solution {
    List<List<Integer>> list = new ArrayList<>();
    int[] visit;
    public int solution(int n, int[][] wires) {
        //전선은 최대 99개
        //list에 송전탑 경로 설정
        int answer = n;
        for(int i=0; i<=n; i++) {
            list.add(new ArrayList<>());
        }
        
        for(int[] w : wires) {
            int a = w[0];
            int b = w[1];
            list.get(a).add(b);
            list.get(b).add(a);
        }
        
        //선을 하나씩 끊어가면서 갯수 세기, 최소 차를 저장
        for(int[] w : wires) {
            int a = w[0]; int b = w[1];
            list.get(a).remove(Integer.valueOf(b));
            list.get(b).remove(Integer.valueOf(a));
            visit = new int[n+1];
            visit[1] = 1;
            int num = dfs(1);
            int other = n - num;
            answer = Math.min(answer, Math.abs(num-other));
            list.get(a).add(b);
            list.get(b).add(a);
        }
        
        return answer;
    }
    
    int dfs(int node) {
        int count = 1;
        
        for(int n : list.get(node)) {
            if(visit[n]==0) {
                visit[n]=1;
                count += dfs(n);
            }
        }
        
        return count;
    }
}