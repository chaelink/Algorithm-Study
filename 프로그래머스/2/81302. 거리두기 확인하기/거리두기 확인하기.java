import java.util.*;

class Solution {
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    int[][] visited;
    int[] answer = new int[5];
    
    
    public int[] solution(String[][] places) {
        for(int i=0; i<5; i++) {
            answer[i] = 1;
        }
        //대기실 5개 이므로 for문 5번
        for(int p=0; p<5; p++) {  //대기실5
            visited = new int[5][5];
            for(int i=0; i<5; i++) {
                for(int j=0; j<5; j++) {
                    if(places[p][i].charAt(j)=='P') {
                        visited[i][j]=1;
                        dfs(p, i, j, places,1);
                        visited[i][j] = 0;
                    }
                }
            }
        }
        //각 대기실 내부 순회 -> p면 dfs 거리 2칸 까지 체크
        
        return answer;
    }
    
    public void dfs(int p, int i, int j, String[][] places, int idx) {
        if(idx>=3) {
            return;
        }
        for(int k=0; k<4; k++) {
            int ni = i + dx[k];
            int nj = j + dy[k];
            if(ni>=0 && ni<5 && nj>=0 && nj<5 && visited[ni][nj]==0) {
                if(places[p][ni].charAt(nj)=='P') {
                    answer[p] = 0;
                    return;
                }
                if(places[p][ni].charAt(nj)=='O') {
                    dfs(p, ni, nj, places, idx+1);
                }
            }
        }
    }
}