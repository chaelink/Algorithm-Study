class Solution {
    public int[] solution(long n) {
        String str = n + "";
        int m = str.length();
        int[] answer = new int[m];
        
        int idx =0;
        for(int i=m-1; i>=0; i--) {
            answer[idx] = str.charAt(i)-'0';
            idx++;
        }
        
        return answer;
    }
}