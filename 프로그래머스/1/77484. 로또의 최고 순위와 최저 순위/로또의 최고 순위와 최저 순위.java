class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        int hit = 0;
        int y = 0;
        int[] rank = {6,6,5,4,3,2,1};
        
        for(int i : lottos) {
            if(i==0) {
                y++;
            } else {
                for(int j=0; j<6; j++) {
                    if(win_nums[j] == i) {
                        hit++;
                    }
                }
            }
        }
        
        answer[0] = rank[hit+y];
        answer[1] = rank[hit];
        
        return answer;
    }
}