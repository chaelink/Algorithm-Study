import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        //무조건 최대 2명씩
        Arrays.sort(people);
        
        int start=0;
        int end = people.length-1;
        
        while(start <= end) {
            if(people[start] + people[end]<=limit) {
                start++;
            }
            answer++;
            end--;
        }
   
        return answer;
    }
}