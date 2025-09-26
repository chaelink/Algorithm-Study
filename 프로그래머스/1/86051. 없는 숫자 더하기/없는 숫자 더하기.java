import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        //해시셋
        //리스트
        //List<Integer> list = new LinkedList<>();
        Set<Integer> list = new HashSet<>();
        for(int i=0; i<10; i++) {
            list.add(i);
        }
        
        for(int i=0; i<numbers.length; i++) {
            if(list.contains(numbers[i])) {
                list.remove(numbers[i]);
            }
        }
        
        for(Integer i : list) {
            answer += i;
        }
        return answer;
    }
}