import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        //차량번호, 분 해시맵으로 관리
        HashMap<String, Integer> map = new HashMap<>();
        
        //각 차량별 출입 관리(차량번호, 시간)
        HashMap<String,String> rec = new HashMap<>();
        
        //입출 전체 확인
        for(int i=0; i<records.length; i++) {
            String[] str = records[i].split(" ");
            String car = str[1];
            String time = str[0];
            
            if(rec.containsKey(car)) {
                String in = rec.get(car);
                int afterCalc = calc(in, time);
                if(map.containsKey(car)) {
                    int before = map.get(car);
                    map.put(car, before+afterCalc);
                } else {
                    map.put(car, afterCalc);
                }
                rec.remove(car);
            } else {
                rec.put(car, time);
            }
        }
        
        //입차만 하고 출차하지 않은 차 계산
        for(Map.Entry<String, String> entry : rec.entrySet()) {
            String car = entry.getKey();
            String in = entry.getValue();
            int time = calc(in, "23:59");
            if(map.containsKey(car)) {
                int before = map.get(car);
                map.put(car, before+time);
            } else {
                map.put(car, time);
            }
        }
        
        //차량 번호 작은 순 정렬
        List<String> carList = new ArrayList<>(map.keySet());
        Collections.sort(carList);
        List<Integer> answer = new LinkedList<>();
        
        //시간 계산 완료, 이제 비용 계산
        for(String car : carList) {
            int time = map.get(car);
            if(time<=fees[0]) {
                answer.add(fees[1]);
            } else {
                int a = time - fees[0];
                int mok = 0;
                if(a%fees[2]!=0) {
                    mok = a/fees[2] + 1;
                } else {
                    mok = a/fees[2];
                }
                answer.add(fees[1] + mok*fees[3]);
            }
        }
        //list -> 배열
        int n = answer.size();
        int[] ans = new int[n];
        int idx = 0;
        for(Integer i : answer) {
            ans[idx] = i;
            idx++;
        }
        return ans;
    }
    
    public int calc(String in, String out) {
        String[] input = in.split(":");
        int in1 = Integer.parseInt(input[0]);
        int in2 = Integer.parseInt(input[1]);
        
        String[] output = out.split(":");
        int out1 = Integer.parseInt(output[0]);
        int out2 = Integer.parseInt(output[1]);
        
        if(in1==out1) {
            return out2 - in2;
        } else if(out2>=in2) {
            int si = out1 - in1;
            return si*60 + out2-in2;
        } else {
            int si = out1 - in1 -1;
            int bun = (60+out2) - in2;
            return si*60 + bun;
        }
    }
}