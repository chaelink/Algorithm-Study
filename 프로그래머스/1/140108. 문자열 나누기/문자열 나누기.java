class Solution {
    public int solution(String s) {
        int answer = 0;
        
        while(s.length()>0) {
            int n = s.length();
            int a = 1;
            int b = 0;
            char x = s.charAt(0);
            boolean t = false;
            for(int i=1; i<n; i++) {
                if(s.charAt(i)==x) {
                    a++;
                } else {b++;}
                
                if(a==b) {
                    if(i<n-1) {
                        s = s.substring(i+1);
                        answer++;
                        t = true;
                        break;
                    } else {
                        answer++;
                        return answer;
                    }
                }
            }
            if(!t) {
                answer++;
                return answer; 
            }   
        }
        return answer;
    }
}