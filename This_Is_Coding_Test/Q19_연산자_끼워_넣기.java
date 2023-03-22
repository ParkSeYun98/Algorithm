package This_Is_Coding_Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q19_연산자_끼워_넣기 {
    private static int N;
    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;

    private static int[] num;
    private static int[] operatorCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        num = new int[N];
        operatorCnt = new int[4];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++)
            num[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<4; i++)
            operatorCnt[i] = Integer.parseInt(st.nextToken());

        DFS(1, num[0]);

        System.out.println(max);
        System.out.println(min);
    }

    public static void DFS(int idx, int partSum) {
        if(idx == N) {
            max = Math.max(max, partSum);
            min = Math.min(min, partSum);

            return;
        }

        for(int i=0; i<4; i++) {
            if(operatorCnt[i] == 0)
                continue;
            else {
                operatorCnt[i]--;

                if(i == 0)
                    DFS(idx+1, partSum + num[idx]);
                else if(i == 1)
                    DFS(idx+1, partSum - num[idx]);
                else if(i == 2)
                    DFS(idx+1, partSum * num[idx]);
                else
                    DFS(idx+1, partSum / num[idx]);

                operatorCnt[i]++;
            }
        }
    }
}
