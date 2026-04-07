
import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int[n+1];
        for (int num: reserve) {
            students[num]++;
        }
        
        for (int num: lost) {
            students[num]--;
        }
        
        Arrays.sort(lost); // 번호가 작은 순대로 lost 정렬
        
        int lostStudent = 0;
        for (int num: lost) {
            if (students[num] >= 0) continue;
            
            // 양 옆 학생들 중 여벌이 있는 학생이 빌려준다.
            // 번호가 작은 학생부터 잃어버린 학생들이 있는지 확인하므로, 왼쪽의 학생부터 여벌이 있는지 확인한다.
            if (num - 1 >= 1 && students[num-1] > 0) {
                students[num-1]--;
                continue;
            }
            if (num + 1 <= n && students[num+1] > 0) {
                students[num+1]--;
                continue;
            }
            lostStudent++;
        }
        
        int answer = n - lostStudent;
        return answer;
    }
}