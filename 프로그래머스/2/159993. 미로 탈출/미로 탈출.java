import java.util.*;

class Solution {
    public int solution(String[] maps) {
        int answer = -1; 
        int sx=0; int sy=0; int li=0; int lj=0;int lt=0;
        boolean lever = false;
        int n = maps.length;
        int m = maps[0].length();
        int[][] visited = new int[n][m];
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        
        List<List<Character>> map = new LinkedList<>();        
        for(int i=0; i<maps.length; i++) {
            map.add(i,new LinkedList<>());
            String s = maps[i];
            for(int j=0; j<s.length(); j++) {
                map.get(i).add(s.charAt(j));
                if(s.charAt(j)=='S') {
                    sx = i;
                    sy = j;
                }
            }
        }
        
        visited[sx][sy] = 1;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sx,sy,0});
        
        while(!q.isEmpty()) {
            int[] now = q.remove();
            int ni = now[0]; int nj = now[1]; int t = now[2];
            if(map.get(ni).get(nj)=='L') {
                lever = true;
                li = ni;
                lj = nj;
                lt = t;
                break;
            }
            
            for(int i=0; i<4; i++) {
                int ii = ni + dx[i];
                int jj = nj + dy[i];
                int tt= t+1;
                
                if(ii>=0 && ii<n && jj>=0 && jj<m && map.get(ii).get(jj)!='X' && visited[ii][jj]==0) {
                    visited[ii][jj]=1;
                    q.add(new int[]{ii,jj,tt});
                }
            }
        }
        if(!lever) {
            return answer;
        }
        Queue<int[]> q2 = new ArrayDeque<>();
        visited[li][lj] = 2;
        q2.add(new int[]{li,lj,lt});
        
        while(!q2.isEmpty()) {
            int[] now2 = q2.remove();
            int ni2 = now2[0]; int nj2 = now2[1]; int t2 = now2[2];
            if(map.get(ni2).get(nj2)=='E') {
                return t2;
            }
            for(int i=0; i<4; i++) {
                int ii2 = ni2 + dx[i];
                int jj2 = nj2 + dy[i];
                int tt2 = t2+1;
                
                if(ii2>=0 && ii2<n && jj2>=0 && jj2<m && map.get(ii2).get(jj2)!='X' && visited[ii2][jj2]!=2) {
                    visited[ii2][jj2]=2;
                    q2.add(new int[]{ii2,jj2,tt2});
                }
            }
        }
        return answer;
    }
}