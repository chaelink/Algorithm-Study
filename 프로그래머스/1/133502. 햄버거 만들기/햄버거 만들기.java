import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        int[] ham = {1, 2, 3, 1};
        Stack<Integer> stack = new Stack<>();

        for (int ing : ingredient) {
            stack.push(ing);

            // 스택 상위 4개가 {1,2,3,1}인지 확인
            if (stack.size() >= 4) {
                boolean match = true;
                for (int j = 0; j < 4; j++) {
                    if (stack.get(stack.size() - 4 + j) != ham[j]) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    for (int j = 0; j < 4; j++) stack.pop();
                    answer++;
                }
            }
        }
        return answer;
    }
}