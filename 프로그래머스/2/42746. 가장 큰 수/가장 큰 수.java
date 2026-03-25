import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        int n = numbers.length;

        List<String> str = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            str.add(String.valueOf(numbers[i]));
        }

        // 핵심: (b+a)와 (a+b)를 비교
        Collections.sort(str, (a, b) -> (b + a).compareTo(a + b));

        // 예외 처리: [0, 0, 0] 같은 경우 "000"이 아니라 "0"
        if (str.get(0).equals("0")) {
            return "0";
        }

        for (String s : str) {
            answer.append(s);
        }

        return answer.toString();
    }
}