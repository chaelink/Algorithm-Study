import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        // 1. 이분 탐색 및 시뮬레이션을 위해 바위 위치 정렬 필수!
        Arrays.sort(rocks);
        
        // 2. 답의 범위를 설정 (최소 거리 1, 최대 거리 distance)
        int left = 1;
        int right = distance;
        
        while (left <= right) {
            int mid = left + (right - left) / 2; // 테스트해 볼 '바위 사이의 최소 거리'
            
            int removedCount = 0; // 지운 바위 개수
            int prev = 0;         // 바로 직전 바위(또는 출발점)의 위치
            
            // 3. 각 바위 사이의 거리를 측정하며 mid 이상 유지할 수 있는지 확인
            for (int rock : rocks) {
                // 현재 바위와 이전 바위 사이의 거리가 mid보다 작다면
                // 최소 거리(mid)를 유지하기 위해 이 바위를 제거해야함
                if (rock - prev < mid) {
                    removedCount++;
                } else {
                    // 바위를 제거하지 않고 남겨두었으므로 이전 위치 갱신
                    prev = rock;
                }
            }
            
            // 4. 마지막 바위와 도착 지점(distance) 사이의 거리도 확인
            if (distance - prev < mid) {
                removedCount++;
            }
            
            // 5. 제거한 바위 수가 허용치(n) 이하인 경우
            if (removedCount <= n) {
                answer = mid;       // 현재 mid는 가능한 거리이므로 정답 후보 저장
                left = mid + 1;     // 더 큰 최소 거리도 가능한지 탐색 (오른쪽 영역)
            } else {
                right = mid - 1;    // 바위를 너무 많이 지웠으므로 거리를 줄임 (왼쪽 영역)
            }
        }
        
        return answer;
    }
}