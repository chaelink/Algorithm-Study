import java.util.*;
class Solution {
    public int solution(int[][] land) {
        int answer = 0;
        int n = land.length;
        int m = land[0].length;
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        int[][] visit = new int[n][m];
        Queue<int[]> q = new ArrayDeque<>();
        //각 시추관 별 누적합 계산
        int[] arr = new int[m];
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(visit[i][j]==0 && land[i][j]==1) {
                    int count = 0;
                    q.add(new int[]{i,j});
                    visit[i][j] = 1;
                    Set<Integer> s = new HashSet<>();
                      
                    while(!q.isEmpty()) {
                        int[] now = q.poll();
                        s.add(now[1]);
                        count++;
                        visit[now[0]][now[1]]=1;
                        
                        for(int k=0; k<4; k++) {
                            int ni = now[0] + dx[k];
                            int nj = now[1] + dy[k];
                            
                            if(ni>=0 && ni<n && nj>=0 && nj<m) {
                                if(land[ni][nj]==1 && visit[ni][nj]==0) {
                                    q.add(new int[]{ni,nj});
                                    visit[ni][nj]=1;
                                }
                            }
                        }
                    }
                    
                    for(Integer col : s) {
                        arr[col] += count;
                    }
                }
            }
        }
        
        for(int i=0; i<arr.length; i++) {
            answer = Math.max(answer,arr[i]);
        }
        
        return answer;
    }
}