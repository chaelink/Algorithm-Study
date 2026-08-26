class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        int count =0;
        int removed = 0;
        
        while(s.length()>1) {
            //순회, 0 갯수, 1갯수 카운트
            int length = 0;
            for(int i=0; i< s.length(); i++) {
                if(s.charAt(i)=='0') removed++;
                else length++;
            }
            
            //이진 변환해서 s에 저장
            s = Integer.toString(length, 2);
            count++;
        }
        
        answer[0] = count;
        answer[1] = removed;
        
        return answer;
    }
}