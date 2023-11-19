/*
* Memory : 11556 KB
* Time : 80 ms
* */

package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class G5_1722_순열의_순서 {

    private static int N;
    private static long k;
    private static int type;

    private static boolean[] visited;
    private static long[] factorial;
    private static int[] arr;

    private static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        factorial = new long[21];
        factorial[0] = 1;

        for(int i=1; i<=20; i++)
            factorial[i] = i * factorial[i-1];

        N = Integer.parseInt(br.readLine());

        visited = new boolean[N+1];
        arr = new int[N+1];
        list = new ArrayList<>();

        st = new StringTokenizer(br.readLine(), " ");

        type = Integer.parseInt(st.nextToken());

        if(type == 1) {
            k = Long.parseLong(st.nextToken());

            for(int i=0; i<N; i++) {
                for(int j=1; j<=N; j++) {
                    if(visited[j])
                        continue;

                    if(k - factorial[N-1-i] > 0)
                        k -= factorial[N-1-i];
                    else {
                        list.add(j);
                        visited[j] = true;
                        break;
                    }
                }
            }

            for (Integer i : list)
                System.out.print(i + " ");
        }
        else {
            long partSum = 1;

            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            for(int i=0; i<N; i++) {
                for(int j=1; j<arr[i]; j++) {
                    if(!visited[j])
                        partSum += factorial[N-i-1];
                }

                visited[arr[i]] = true;
            }

            System.out.println(partSum);
        }
    }
}
