import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> st = new Stack<>();
        int n = board.length;
        
        for(int num : moves) {
            int row = num-1;
            for(int i=0; i<n; i++) {
                if(board[i][row] != 0) {
                    st.push(board[i][row]);
                    board[i][row] = 0;
                    break;
                }
            }
            
            if(st.size()>=2) {
                if(st.get(st.size()-1) == st.get(st.size()-2)) {
                    st.pop();
                    st.pop();
                    answer = answer+2;
                }
            }
        }
        
        
        return answer;
    }
}