package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_10726_이진수_표현 {
    private static int N;
    private static long M;
    private static String result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            result = "";
            change();

            System.out.println("#" + tc + " " + result);
        }
    }

    public static void change() {
        String binaryM = Long.toBinaryString(M);

        if(binaryM.length() < N) {
            boolean flag = false;

            for(int i=0; i < binaryM.length(); i++) {
                if(binaryM.charAt(i) != '1') {
                    flag = true;
                    break;
                }
            }

            result = "OFF";
        }
        else {
            boolean flag = false;

            for(int i=0; i<N; i++) {
                if(binaryM.charAt(binaryM.length()-1-i) != '1') {
                    flag = true;
                    break;
                }
            }

            if(!flag)
                result = "ON";
            else
                result = "OFF";
        }
    }
}