class Solution {
    public double solution(int[] numbers) {
        int n = numbers.length;
        int sum = 0;
        for(int i=0; i<n; i++) {
            sum += numbers[i];
        }
        double answer = (double)sum / n;
        return answer;
    }
}