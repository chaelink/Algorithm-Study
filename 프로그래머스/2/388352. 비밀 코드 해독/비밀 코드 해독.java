import java.util.*;
class Solution {
    List<Integer>list = new ArrayList<>();
    //지금 내 방식 : n까지의 전체 조합을 구하고 -> 조건 일치 확인
    int answer = 0;
    public int solution(int n, int[][] q, int[] ans) {
        
        dfs(1,n, q, ans);
        
        return answer;
    }
    
    void dfs(int idx, int n, int[][] q, int[] ans) {
        //n까지의 수 중 5개 -> 조합(순서 상관 없음)
        if(list.size()==5) {
            if(check(q,ans)) {
                answer++;
            }
            return;
        }
        
        //탐색
        for(int i=idx; i<=n; i++) {
            list.add(i);
            dfs(i+1,n,q,ans);
            list.remove(list.size()-1);
        }
    }
    
    boolean check(int[][] q, int[] ans) {
        //q를 순회하면서 응답만큼 포함하는 지 체크 -> 하나라도 아니면 break;
        for(int j = 0; j<q.length; j++) {
            int[] k = q[j];
            int in = 0;
            for(int i=0; i<5; i++) {
                if(list.contains(k[i])) in++;
                if(in > ans[j]) return false;
            }
            if(in != ans[j]) return false;
        }
        return true;
    }
}