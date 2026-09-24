import java.util.*;
class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int n = park.length; //세로
        int m = park[0].length(); //가로
        
        //시작 위치 구하기
        for(int i=0; i<n; i++) {
            String str = park[i];
            for(int j=0; j<str.length(); j++) {
                if(str.charAt(j)=='S') {
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }
        
        //루트 돌면서 가능하면 이동
        for(String r : routes) {
            String[] route = r.split(" ");
            int d = Integer.parseInt(route[1]);
            boolean go = true;
            if(route[0].equals("N")) {
                if(answer[0] - d>=0) {
                    for(int i=answer[0]; i>=answer[0]-d; i--) {
                        if(park[i].charAt(answer[1])=='X') {
                            go = false;
                            break;
                        }
                    }
                    if(go) {answer[0] = answer[0]-d;}
                }
            }
            if(route[0].equals("S")) {
                if(answer[0] + d<n) {
                    for(int i=answer[0]; i<=answer[0]+d; i++) {
                        if(park[i].charAt(answer[1])=='X') {
                            go = false;
                            break;
                        }
                    }if(go) {answer[0] = answer[0]+d;}
                }
                
            }
            if(route[0].equals("W")) {
                if(answer[1] - d>=0) {
                    for(int i=answer[1]; i>=answer[1]-d; i--) {
                        if(park[answer[0]].charAt(i)=='X') {
                            go = false;
                            break;
                        }
                    }if(go) {answer[1] = answer[1]-d;}
                }
                
            }
            if(route[0].equals("E")) {
                if(answer[1] + d<m) {
                    for(int i=answer[1]; i<=answer[1]+d; i++) {
                        if(park[answer[0]].charAt(i)=='X') {
                            go = false;
                            break;
                        }
                    }if(go) {answer[1] = answer[1]+d;}
                }
                
            }
        }
        
        return answer;
    }
}