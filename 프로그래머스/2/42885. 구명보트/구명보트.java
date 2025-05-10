import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people); //오름차순 정렬임
        int start = 0;
        int end = people.length-1;
        
        //int[]를 그대로 사용? 삽입 삭제가 편한 자료구조로 옮겨서 구현?
        
        while(start<=end) {
            if(start==end) {
                answer++;
                start++;
                end--;
            } else {
                if(people[start] + people[end] <= limit) {
                    answer++;
                    start++;
                    end--;
                } else {
                    answer++;
                    end--;
                }
            }
        }
        return answer;
    }
}