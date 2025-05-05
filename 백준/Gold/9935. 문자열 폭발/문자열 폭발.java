import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String boom = br.readLine();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            sb.append(input.charAt(i));

            // 폭발 문자열 길이 이상이 되었을 때만 비교
            if (sb.length() >= boom.length()) {
                boolean match = true;
                for (int j = 0; j < boom.length(); j++) {
                    if (sb.charAt(sb.length() - boom.length() + j) != boom.charAt(j)) {
                        match = false;
                        break;
                    }
                }

                if (match) {
                    sb.delete(sb.length() - boom.length(), sb.length());
                }
            }
        }

        if (sb.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb.toString());
        }
    }
}
