import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < priorities.length; i++) queue.add(i);

        while (!queue.isEmpty()) {
            int curIdx = queue.poll();
            int curPriority = priorities[curIdx];

            // 큐에 남은 것 중 우선순위 더 높은 게 있으면
            boolean hasHigher = queue.stream()
                .anyMatch(idx -> priorities[idx] > curPriority);

            if (hasHigher) {
                queue.add(curIdx);  // 뒤로 다시 넣기
            } else {
                answer++;
                if (curIdx == location) return answer;
            }
        }
        return answer;
    }
}