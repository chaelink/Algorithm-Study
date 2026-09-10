import java.util.*;
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        
        listA.add(arrayA[0]);
        for(int i=2; i*i<arrayA[0]; i++) {
            if(arrayA[0] % i ==0) {
                listA.add(i);
                listA.add(arrayA[0] / i);
            }
        }
        
        listB.add(arrayB[0]);
        for(int i=2; i<arrayB[0]; i++) {
            if(arrayB[0] % i ==0) {
                listB.add(i);
                //System.out.println(i);
            }
        }
        
        Collections.sort(listA, Collections.reverseOrder());
        Collections.sort(listB, Collections.reverseOrder());
        
        for(Integer num : listA) {
            int a = checkA(num, arrayA);
            int b = checkB(num, arrayB);
            if((a==1&&b==2) ||(a==2&&b==1)) {
                answer = Math.max(answer, num);
                break;
            }
        }
        
        for(Integer num : listB) {
            int a = checkA(num, arrayA);
            int b = checkB(num, arrayB);
            if((a==1&&b==2) ||(a==2&&b==1)) {
                answer = Math.max(answer, num);
                break;
            }
        }
        
        return answer;
    }
    
    int checkA(int num,int[] arrayA) {
        int count = 0;
        for(int i=0; i<arrayA.length; i++) {
            if(arrayA[i] % num != 0) {
                count++;
            }
        }
        if(count==0) return 1;
        if(count == arrayA.length) {
            return 2;
        }
        return 0;
    }
    
    int checkB(int num,int[] arrayB) {
        int count =0;
        for(int i=0; i<arrayB.length; i++) {
            if(arrayB[i] % num != 0) {
                count++;
            }
        }
        if(count==0) return 1;
        if(count == arrayB.length) {
            return 2;
        }
        return 0;
    }
    
    
}