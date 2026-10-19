import java.util.*;

class Solution {
    int[][] visit;
    int idx = 1;
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    int n, m;

    Map<Integer, Integer> map = new HashMap<>();

    public int solution(int[][] land) {
        int answer = 0;
        n = land.length;
        m = land[0].length;

        visit = new int[n][m];

        // 1. BFS로 석유 덩어리 번호 및 크기 저장
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && visit[i][j] == 0) {
                    visit[i][j] = idx;
                    bfs(i, j, land);
                    idx++;
                }
            }
        }

        // 2. 각 열에서 시추 가능한 석유량 계산
        for (int j = 0; j < m; j++) {
            Set<Integer> set = new HashSet<>();

            for (int i = 0; i < n; i++) {
                if (visit[i][j] != 0) {
                    set.add(visit[i][j]);
                }
            }

            int sum = 0;

            // 중복되지 않은 석유 덩어리 크기 합산
            for (int id : set) {
                sum += map.get(id);
            }

            answer = Math.max(answer, sum);
        }

        return answer;
    }

    // 3. BFS로 연결된 석유 덩어리 크기 계산
    void bfs(int x, int y, int[][] land) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y});

        int count = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            count++;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < n &&
                    ny >= 0 && ny < m &&
                    land[nx][ny] == 1 &&
                    visit[nx][ny] == 0) {

                    visit[nx][ny] = idx;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        // 탐색 완료 후 석유 덩어리 크기 저장
        map.put(idx, count);
    }
}