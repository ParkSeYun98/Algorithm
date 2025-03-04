package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class G3_1644_소수의_연속합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean[] prime = new boolean[N+1];
        prime[0] = true;
        prime[1] = true;

        for(int i=2; i*i<=N; i++) {
            if(!prime[i]) {
                for(int j=i*i; j<=N; j+=i)
                    prime[j] = true;
            }
        }

        List<Integer> list = new ArrayList<>();

        for(int i=1; i<=N; i++) {
            if(!prime[i])
                list.add(i);
        }

        solve(list, N);
    }

    static void solve(List<Integer> list, int N) {
        int left = 0;
        int right = 0;
        int cnt = 0;
        int sum = 0;

        while(true) {
            if (sum >= N)
                sum -= list.get(left++);
            else if (right == list.size())
                break;
            else
                sum += list.get(right++);

            if (sum == N)
                cnt++;
        }

        System.out.println(cnt);
    }
}
