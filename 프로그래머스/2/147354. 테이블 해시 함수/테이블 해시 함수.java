import java.util.*;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        //튜플을 col번째 컬럼 기준으로 오름차순, pk기준 내림차순
        
        //1. 정렬
        Arrays.sort(data, (a,b) -> {
            if(a[col-1] == b[col-1]) {
                return b[0] - a[0];
            }
            return a[col-1] - b[col-1];
        });
        
        //2. i 범위 구해서, i로 나눈 나머지 합, 비트와이스
        row_begin--;
        row_end--;
        for(int i=0; i<data.length; i++) {
            if(i>=row_begin && i<=row_end) {
                int sum = 0;
                for(int j=0; j<data[i].length; j++) {
                    sum += (data[i][j]%(i+1));
                }
                answer = (answer ^ sum);
            }
        }
        
        return answer;
    }
}