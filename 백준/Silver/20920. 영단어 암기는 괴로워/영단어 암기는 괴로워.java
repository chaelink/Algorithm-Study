import java.io.*;
import java.util.*;

public class Main {
    static class Word {
        String word;
        int freq;

        Word(String word, int freq) {
            this.word = word;
            this.freq = freq;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            if (word.length() >= m) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        // Word 객체 리스트 생성
        List<Word> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(new Word(entry.getKey(), entry.getValue()));
        }

        // 정렬: 빈도수 → 길이 → 사전순
        list.sort((a, b) -> {
            if (a.freq != b.freq) {
                return b.freq - a.freq;
            } else if (a.word.length() != b.word.length()) {
                return b.word.length() - a.word.length();
            } else {
                return a.word.compareTo(b.word);
            }
        });

        // 출력
        StringBuilder sb = new StringBuilder();
        for (Word w : list) {
            sb.append(w.word).append('\n');
        }
        System.out.print(sb);
    }
}
