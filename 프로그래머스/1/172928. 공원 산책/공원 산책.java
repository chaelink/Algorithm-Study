import java.util.*;
class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        //로봇 강아지의 최종 위치 구하기
        int w = park[0].length();
        int h = park.length;
        int[][] arr = new int[h][w];
        //1. 배열 정리하기
        for(int i=0; i<park.length; i++) {
            String str = park[i];
            for(int j=0; j<w; j++) {
                if(str.charAt(j)=='O') {
                    arr[i][j] = 1;
                } else if(str.charAt(j)=='X') {
                    arr[i][j] = 0;
                } else if(str.charAt(j)=='S') {
                    arr[i][j] = 1;
                    answer[0] = i; answer[1] = j;
                }
            }
        }
        
        //2. 루트 체크하기
        for(int i=0; i<routes.length; i++) {
            String[] str = routes[i].split(" ");
            int d = Integer.parseInt(str[1]);
            boolean check = true;
            if(str[0].equals("N")) {
                if(answer[0] - d<0) continue;
                for(int j=1; j<=d; j++) {
                    if(arr[answer[0] - j][answer[1]] == 0) check = false;
                }
                if(check) answer[0] -= d;
            } else if(str[0].equals("S")) {
                if(answer[0] + d>=h) continue;
                for(int j=1; j<=d; j++) {
                    if(arr[answer[0] + j][answer[1]] == 0) check = false;
                }
                if(check) answer[0] += d;
            } else if(str[0].equals("W")) {
                if(answer[1] - d<0) continue;
                for(int j=1; j<=d; j++) {
                    if(arr[answer[0]][answer[1]-j] == 0) check = false;
                }
                if(check) answer[1] -= d;
            } else if(str[0].equals("E")) {
                if(answer[1] + d>=w) continue;
                for(int j=1; j<=d; j++) {
                    if(arr[answer[0]][answer[1]+j] == 0) check = false;
                }
                if(check) answer[1] += d;
            }
        }
        
        return answer;
    }
}