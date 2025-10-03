import java.util.*;

class Solution {
    public int solution(String dirs) {
        int[] dx = {0, 0, 1, -1}; // U, D, R, L
        int[] dy = {1, -1, 0, 0};
        String order = "UDRL";
        
        HashSet<String> set = new HashSet<>();
        int x = 0, y = 0;
        
        for (char ch : dirs.toCharArray()) {
            int dir = order.indexOf(ch);
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if (nx < -5 || nx > 5 || ny < -5 || ny > 5) continue;
            
            int a = Math.min(x, nx);
            int b = Math.max(x, nx);
            int c = Math.min(y, ny);
            int d = Math.max(y, ny);
            
            set.add(a + "," + b + "," + c + "," + d);
            
            x = nx;
            y = ny;
        }
        return set.size();
    }
}
