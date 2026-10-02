import java.util.*;
class Solution {
    public int[] solution(String[] maps) {
        List<Integer> list = new ArrayList<>();
        int n = maps.length;
        int m = maps[0].length();
        int[][] visit = new int[n][m];
        Queue<int[]> q = new ArrayDeque<>();
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        
        //상하좌우 이동하며 섬 탐색 -> bfs
        for(int i=0; i<n; i++) {
            String str = maps[i];
            for(int j=0; j<m; j++) {
                //숫자, 방문 전, 큐에 삽입
                if(str.charAt(j)!='X' && visit[i][j]==0) {
                    int sum = str.charAt(j)-'0';
                    visit[i][j] = 1;
                    q.add(new int[]{i,j});
                    
                    while(!q.isEmpty()) {
                        int[] now = q.poll();
                        
                        for(int k=0; k<4; k++) {
                            int nx = now[0] + dx[k];
                            int ny = now[1] + dy[k];
                            
                            if(nx>=0 && nx<n && ny>=0 && ny<m && visit[nx][ny]==0 && maps[nx].charAt(ny)!='X') {
                                visit[nx][ny]=1;
                                q.add(new int[]{nx,ny});
                                sum += maps[nx].charAt(ny) - '0';
                            }
                        }
                    }
                    list.add(sum);
                }
            }
        }
        
        //지낼 수 있는 무인도가 없으면 -1
        if(list.size()==0) {
            int[] ans = {-1};
            return ans;
        }
        
        int cnt = list.size();
        int[] answer = new int[cnt];
        Collections.sort(list);
        int idx = 0;
        for(Integer num : list) {
            answer[idx] = num;
            idx++;
        }
        
        return answer;
    }
}