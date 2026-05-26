import java.util.*;
class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder("");
        //int n = numbers.length;
        Map<Integer, Integer[]> map2 = new HashMap<>();
        map2.put(1, new Integer[]{0,0});
        map2.put(2, new Integer[]{0,1});
        map2.put(3, new Integer[]{0,2});
        map2.put(4, new Integer[]{1,0});
        map2.put(5, new Integer[]{1,1});
        map2.put(6, new Integer[]{1,2});
        map2.put(7, new Integer[]{2,0});
        map2.put(8, new Integer[]{2,1});
        map2.put(9, new Integer[]{2,2});
        map2.put(0, new Integer[]{3,1});
        map2.put(-1, new Integer[]{3,0});
        map2.put(-2, new Integer[]{3,2});

        
        int L = -1;
        int R = -2;
       
        for(int n : numbers) {
            if(n == 1 || n==4 || n==7) {
                answer.append('L');
                L = n;
            } else if(n==3 || n==6 || n==9) {
                answer.append('R');
                R = n;
            } else {
                Integer[] loc1 = map2.get(L);
                Integer[] loc2 = map2.get(R);
                Integer[] cen = map2.get(n);
                // int v1 = -1*(cen[0] - loc1[0]) + (cen[1] - loc1[1])*-1;
                // int v2 = (cen[0] - loc2[0])*-1 + (cen[1] - loc2[1])*-1;
                int v1 = Math.abs(cen[0] - loc1[0]) + Math.abs(cen[1] - loc1[1]);
                int v2 = Math.abs(cen[0] - loc2[0]) + Math.abs(cen[1] - loc2[1]);
                //System.out.println("left: " + v1);
                //System.out.println("right: " + v2);
                if(v1 < v2) {
                    answer.append('L');
                    L = n;
                } else if(v2 < v1) {
                    answer.append('R');
                    R = n;
                } else {
                    if (hand.equals("right")) {
                        answer.append('R');
                        R = n;
                    } else {
                        answer.append('L');
                        L = n;
                    }
                }
            }
        }
        return answer.toString();
    }
}