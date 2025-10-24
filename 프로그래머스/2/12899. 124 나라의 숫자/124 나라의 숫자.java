class Solution {
    public String solution(int n) {
        String answer = "";
        String[] add = new String[]{"4", "1", "2"};
        int num = n;
        while(n>0) {
            int remain = n%3;
            n = n/3;
            if(remain ==0) n--;
            answer = add[remain] + answer;
            
        }
        return answer;
    }
}