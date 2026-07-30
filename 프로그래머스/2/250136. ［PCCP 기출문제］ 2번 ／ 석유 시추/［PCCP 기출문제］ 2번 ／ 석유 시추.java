import java.util.*;

class Solution {
    public int solution(int[][] land) {
        int answer = 0;
        int n = land.length;
        int m = land[0].length; // 1. int[] -> int 로 수정
        
        int[] ans = new int[m]; // 각 열별 누적 석유량
        boolean[][] visit = new boolean[n][m]; // 방문 체크 배열
        
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && !visit[i][j]) {
                    
                    Queue<int[]> q = new ArrayDeque<>();
                    q.add(new int[]{i, j});
                    visit[i][j] = true; // 2. 큐에 넣을 때 방문 처리!
                    
                    int count = 0; // 석유 덩어리 크기
                    Set<Integer> cols = new HashSet<>(); // 걸쳐 있는 열(column) 저장 (중복 제거)
                    
                    // --- BFS 시작 ---
                    while (!q.isEmpty()) {
                        int[] curr = q.poll(); // 3. 변수명 n 대신 curr 사용
                        int r = curr[0];
                        int c = curr[1];
                        
                        count++;
                        cols.add(c); // 현재 칸이 속한 열(column) 번호 기록
                        
                        for (int k = 0; k < 4; k++) {
                            int nr = r + dx[k];
                            int nc = c + dy[k];
                            
                            // 맵 범위 내에 있고, 석유(1)이며, 방문하지 않았다면
                            if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                                if (land[nr][nc] == 1 && !visit[nr][nc]) {
                                    visit[nr][nc] = true;
                                    q.add(new int[]{nr, nc});
                                }
                            }
                        }
                    }
                    // --- BFS 끝 ---
                    
                    // 4. 탐색 끝난 덩어리의 크기를 걸쳐 있던 열들에 한 번에 누적
                    for (int col : cols) {
                        ans[col] += count;
                    }
                }
            }
        }
        
        // 5. 각 열의 누적 석유량 중 최댓값 찾기
        for (int oil : ans) {
            answer = Math.max(answer, oil);
        }
        
        return answer;
    }
}