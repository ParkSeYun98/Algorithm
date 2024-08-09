package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G4_1963_소수_경로 {

    static boolean[] primeArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        primeArr = new boolean[10000];

        getPrime();

        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            int numA = Integer.parseInt(st.nextToken());
            int numB = Integer.parseInt(st.nextToken());

            changeToPrime(numA, numB);
        }
    }

    static void changeToPrime(int numA, int numB) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(numA);

        boolean[] visited = new boolean[10000];
        visited[numA] = true;

        int[] cntArr = new int[10000];

        while(!queue.isEmpty()) {
            int now = queue.poll();

            for(int i=0; i<4; i++) {
                for(int j=0; j<10; j++) {
                    if(i==0 && j==0)
                        continue;

                    int temp = change(now, i, j);

                    if(primeArr[temp])
                        continue;

                    if(visited[temp])
                        continue;

                    queue.offer(temp);
                    visited[temp] = true;
                    cntArr[temp] = cntArr[now] + 1;
                }
            }
        }

        System.out.println(cntArr[numB]);
    }

    static int change(int num, int i, int j) {
        String str = String.valueOf(num);

        int sum = 0;

        for(int a=0; a<str.length(); a++) {
            int idx = (int) Math.pow(10, 3-a);

            if(a == i)
                sum += idx * j;
            else
                sum += idx * (str.charAt(a) - '0');
        }

        return sum;
    }

    static void getPrime() {
        primeArr[0] = true;
        primeArr[1] = true;

        for(int i=2; Math.pow(i, 2)<primeArr.length; i++) {
            if(!primeArr[i]) {
                for(int j=2*i; j<primeArr.length; j+=i)
                    primeArr[j] = true;
            }
        }
    }
}
