package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_1497_기타콘서트 {

    static int N, M, maxSong, needGuiter;

    static int indexArr[];

    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        indexArr = new int[N];
        needGuiter = N;
        int cnt = 0;

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();

            String[] str = st.nextToken().split("");

            for(int j=0; j<M; j++) {
                arr[i][j] = str[j].equals("Y") ? 1 : 0;

                if(arr[i][j]==1)
                    cnt++;
            }
        }

        for(int i=1; i<=N; i++)
            recur(0,0,i);

        if(cnt == 0)
            System.out.println(-1);
        else
            System.out.println(needGuiter);

    }

    public static void recur(int idx,int start, int max) {
        if(idx == max) {
            if(bitmask(arr,indexArr,max)) {
                System.out.println(max);
                System.exit(0);
            }
            return;

        }

        for(int i=start; i<N; i++) {
            indexArr[idx] = i;
            recur(idx+1, i+1, max);
        }
    }

    public static boolean bitmask(int guiter[][], int index[],int max) {
        boolean flag = true;
        int temp = 0;

        for(int i=0; i<M; i++) {
            int result = guiter[index[0]][i];

            if(result ==0) {
                for(int j=1; j<max; j++)
                    result = guiter[index[j]][i] | result;
            }

            if(result == 0)
                flag = false;
            if(result == 1)
                temp++;
        }

        if(maxSong < temp) {
            maxSong = temp;
            needGuiter = max;
        }

        return flag;
    }
}