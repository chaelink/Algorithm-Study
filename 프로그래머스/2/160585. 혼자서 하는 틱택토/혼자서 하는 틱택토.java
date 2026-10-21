import java.util.*;
class Solution {
    int[] dx = {0,0,1,-1,1,1,-1,-1};
    int[] dy = {1,-1,0,0,1,-1,-1,1};
    public int solution(String[] board) {
        //규칙대로 진행했을 때 나올 수 있는 상황인가
        //oxox 통과
        //oxoxo-> 선공 승리, 종료
        //실수가 나올 수 있어도, 규칙을 지킬 수 있으면 1
        
        //1. o,x 갯수 카운트 >= 이면 정상 가능, else 0
        int one=0;
        int two=0;
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(board[i].charAt(j)=='O') {
                    one++;
                } else if (board[i].charAt(j)=='X') {two++;}
            }
        }
        if((one==two) || (one==two+1)) {}
        else {return 0;}
        
        //2. 승리 이후에도 이어 갔는가
        //2-1. 선공 승리 이후 x가 있으면 0
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(board[i].charAt(j)=='O') {
                    if(check(i,j,board)) {
                        if(one==two) return 0;
                    }
                }
            }
        }
        
        //후공 성공 후 o가 있으면 0
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(board[i].charAt(j)=='X') {
                    if(check(i,j,board)) {
                        if(one>two) return 0;
                    }
                }
            }
        }
        
        return 1;
    }
    
    boolean check (int a, int b, String[] board) {
        char c = board[a].charAt(b);
        for(int i=0; i<8; i++) {
            int nx = a;
            int ny = b;
            int cnt=0;
            for(int j=0; j<2; j++) {
                nx += dx[i];
                ny += dy[i];
                if(nx>=0 && nx<3 && ny>=0 && ny<3 && board[nx].charAt(ny)==c) {
                    cnt++;
                } else {
                    break;
                }
            }
            if(cnt==2) return true;
        }
        return false;
    }
}