import java.util.*;

class Solution {
    public int solution(int[][] dots) {
        // 네 점에서 두 개씩 짝지어 평행 확인 (총 3가지 경우)
        
        // (0,1) vs (2,3)
        if (isParallel(dots[0], dots[1], dots[2], dots[3])) return 1;
        // (0,2) vs (1,3)
        if (isParallel(dots[0], dots[2], dots[1], dots[3])) return 1;
        // (0,3) vs (1,2)
        if (isParallel(dots[0], dots[3], dots[1], dots[2])) return 1;
        
        return 0;
    }
    
    private boolean isParallel(int[] a, int[] b, int[] c, int[] d) {
        int x1 = b[0] - a[0];
        int y1 = b[1] - a[1];
        int x2 = d[0] - c[0];
        int y2 = d[1] - c[1];
        
        return y1 * x2 == y2 * x1;
    }
}
