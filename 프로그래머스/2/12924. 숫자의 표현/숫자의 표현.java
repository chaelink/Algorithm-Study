class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i=1; i<=n; i++) {
            int idx = i;
            int nn = idx;
            idx++;
            
            while(nn<=n) {
                
                if(nn==n) {
                    answer++;
                    break;
                }
                nn += idx;
                idx++;
                
            }
        }
        return answer;
    }
}