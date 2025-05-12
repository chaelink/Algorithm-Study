class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int time=0; int zero =0;
        
        
        while(!s.equals("1")) {
            int o = s.length();
            s = s.replace("0","");
            int l = s.length();
            zero += (o-l);
            s="";
            while(l!=0) {
                s += l % 2;
                l = l/2;
            }
            time++;
        }
        answer[0] = time;
        answer[1] = zero;
        return answer;
    }
}