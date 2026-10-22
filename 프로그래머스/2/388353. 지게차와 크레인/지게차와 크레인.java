import java.util.*;
class Solution {
    int n; int m;
    char[][] arr;
    int[] dx = {0,0,1,-1}; int[] dy = {1,-1,0,0};
    public int solution(String[] storage, String[] requests) {
        n = storage.length;
        m = storage[0].length();
        arr = new char[n][m];
        
        //창고 -> 배열로 정리
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                arr[i][j] = storage[i].charAt(j);
            }
        }
        
        //작업 순회
        for(String str : requests) {
            //지게차
            if(str.length()==1) {
                cha(str);
            } else {
                //크레인
                crain(str);
            }
        }
        
        //최종, 남은 갯수 세기
        int answer = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                //System.out.print(arr[i][j]+" ");
                if(arr[i][j]!='1') answer++;
            }
            //System.out.println();
        }
        
        return answer;
    }
    
    void cha(String str) {
        char c = str.charAt(0);
        List<int[]> can = new ArrayList<>();
        //외곽 먼저 체크
        for(int i=0; i<n; i++) {
            if(arr[i][0]==c) {can.add(new int[]{i,0});}
            if(arr[i][m-1]==c) {can.add(new int[]{i,m-1});}
        }
        for(int j=0; j<m; j++) {
            if(arr[0][j]==c) {can.add(new int[]{0,j});}
            if(arr[n-1][j]==c) {can.add(new int[]{n-1,j});}
        }
        
        //내부 중, 접근 가능 체크
        for(int i=1; i<n-1; i++) {
            for(int j=1; j<m-1; j++) {
                if(arr[i][j]==c) {
                    Queue<int[]> q = new ArrayDeque<>();
                    int[][] visit = new int[n][m];
                    
                    q.add(new int[]{i,j});
                    visit[i][j] = 1;
                    
                    while(!q.isEmpty()) {
                        int[] now = q.poll();
                        if(now[0]==0 || now[0]==(n-1) || now[1]==0 || now[1]==(m-1)) {
                            can.add(new int[]{i,j});
                            break;
                        }
                        
                        for(int k=0; k<4; k++) {
                            int nx = now[0] + dx[k];
                            int ny = now[1] + dy[k];
                            if(nx>=0 && nx<n && ny>=0 && ny<m && arr[nx][ny]=='1' && visit[nx][ny]==0) {
                                q.add(new int[]{nx,ny});
                                visit[nx][ny] = 1;
                            }
                        }
                    }
                    
                }
            }
        }
        for(int[] q : can) {
            arr[q[0]][q[1]] = '1';
        }
        
    }
    
    void crain(String str) {
        //크레인(BB) -> 모두 가능 : for문 돌면서 같은 알파벳 삭제
        char c = str.charAt(0);
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(arr[i][j]==c) {
                    arr[i][j] = '1';
                }
            }
        }

    }
}