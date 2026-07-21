class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long n = numbers[i];

            // 1. 짝수면 무조건 n + 1
            if (n % 2 == 0) {
                answer[i] = n + 1;
            } 
            // 2. 홀수면 가장 오른쪽의 '01'을 '10'으로 변경
            else {
                // 가장 하위의 꺼져있는 비트(0) 위치 찾기
                long lastZero = ~n & (n + 1);
                // 해당 위치의 비트를 1로 만들고, 그 한 칸 아래 비트를 0으로 바꿈
                answer[i] = n + lastZero - (lastZero >> 1);
            }
        }

        return answer;
    }
}