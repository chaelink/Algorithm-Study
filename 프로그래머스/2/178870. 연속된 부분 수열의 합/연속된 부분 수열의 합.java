class Solution {
    public int[] solution(int[] sequence, int k) {

        int left = 0;
        int right = 0;
        int sum = sequence[0];

        int bestLeft = 0;
        int bestRight = sequence.length - 1;
        int minLength = sequence.length;

        while (left <= right && right < sequence.length) {

            // 정답 후보 발견
            if (sum == k) {
                int length = right - left + 1;

                if (length < minLength) {
                    minLength = length;
                    bestLeft = left;
                    bestRight = right;
                }

                // 더 짧은 구간 탐색
                sum -= sequence[left];
                left++;

            // 합이 작으면 오른쪽 확장
            } else if (sum < k) {
                right++;

                if (right < sequence.length) {
                    sum += sequence[right];
                }

            // 합이 크면 왼쪽 축소
            } else {
                sum -= sequence[left];
                left++;
            }
        }

        return new int[]{bestLeft, bestRight};
    }
}