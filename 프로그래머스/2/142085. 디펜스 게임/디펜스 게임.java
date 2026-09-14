import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {

        int answer = 0;
        int m = enemy.length;
        if (k >= m) return m;
        PriorityQueue<Integer> pq =
                new PriorityQueue<>(Collections.reverseOrder());

        int i = 0;

        while (i < m) {

            // 디펜스 불가
            if (n < enemy[i]) {
                //무적권이 없으면 진행 불가
                if(k<=0) break;

               //이전에 처리한 디펜스값을 더해줘야 하는 경우
                else if(!pq.isEmpty() && pq.peek()>enemy[i]) {
                    n += pq.poll();
                    k--;
                    // i라운드 디펜스 가능
                    if (n >= enemy[i]) {
                        n -= enemy[i];
                        pq.add(enemy[i]);
                        answer = i+1;
                        i++;
                    }
                    continue;
                }
                else if(pq.isEmpty() || pq.peek()<=enemy[i]) {
                    //현재 라운드를 무적권 사용하는 경우
                    k--;
                    answer = i+1;
                    i++;
                    continue;
                } 
            }

            // i라운드 디펜스 가능
            if (n >= enemy[i]) {
                n -= enemy[i];
                pq.add(enemy[i]);
                answer = i+1;
                i++;
            }
        }

        return answer;
    }
}