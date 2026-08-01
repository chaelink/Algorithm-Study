import java.util.*;
class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        int last = attacks[attacks.length-1][0]; 
        int succ = 0;
        int hp = health;
        int idx = 0;
        int time = 0;
        
        for(int i=0; i<attacks.length; i++) {
            int diff = attacks[i][0] - time-1;
            for(int j=0; j<diff; j++) {
                hp+= bandage[1];
            }
            if(diff/bandage[0]>0) {
                hp += (diff/bandage[0])*bandage[2];
            }
            if(hp>health) hp = health;
            
            hp -= attacks[i][1];
            if(hp<=0) return -1;
            time = attacks[i][0];
            //System.out.println(hp);
        }
        
//         for(int i=1; i<=last; i++) {     
//             //몬스터 공격 여부 확인
//             if(i == attacks[idx][0]) {
//                 hp -= attacks[idx][1];
//                 if(hp<=0) return -1;
//                 idx++;
//                 succ = 0;
//                 continue;
//             }
            
//             //몬스터 공격 받지 않는 경우
//             succ++;
//             hp += bandage[1];
//             if(succ==bandage[0]) {
//                 hp += bandage[2];
//                 succ=0;
//             }
//             hp = Math.min(hp,health);
//         }
        
        return hp;
        
        //t초동안 붕대, 초당 x 체력 회복
        //t초 연속 성공, y 체력 추가
    }
}