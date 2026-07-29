import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        Arrays.sort(A);
        Integer[] b = new Integer[B.length];
        for(int i=0; i<B.length; i++) {
            b[i] = B[i];
        }
        Arrays.sort(b,Collections.reverseOrder());
        int n = A.length;
        for(int i=0; i<n; i++) {
            answer += A[i]*b[i];
        }     

        return answer;
    }
}