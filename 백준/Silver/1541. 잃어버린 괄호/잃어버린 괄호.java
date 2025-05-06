import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sb = br.readLine();
        boolean minus = false;
        StringBuilder sb2 = new StringBuilder();
        int result =0;

        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if(c=='-') {
                int a = Integer.parseInt(sb2.toString());
                sb2 = new StringBuilder();
                if(minus) {
                    result -= a;
                } else {
                    result += a;
                }
                minus = true;
            }else if(c=='+') {
                int a = Integer.parseInt(sb2.toString());
                sb2 = new StringBuilder();
                if(minus) {
                    result -= a;
                } else {
                    result += a;
                }
            } else {
                sb2.append(c);
            }
        }
        int a = Integer.parseInt(sb2.toString());
        if(minus) {
            result -= a;
        } else {
            result += a;
        }
        System.out.println(result);
    }
}
