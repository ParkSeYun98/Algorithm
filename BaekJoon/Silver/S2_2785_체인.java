/*
* Memory : 99332 KB
* Time : 1008 ms
* */

package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S2_2785_체인 {

    private static int N;

    private static List<Integer> chains;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        chains = new ArrayList<>();

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++)
            chains.add(Integer.parseInt(st.nextToken()));

        getMinRing();
    }

    public static void getMinRing() {
        int cnt = 0;
        Collections.sort(chains);

        while(chains.size() > 1) {
            int temp = chains.get(0);

            if(chains.size() > 2) {
                int main = chains.get(chains.size()-2);
                int sub = chains.get(chains.size()-1);

                for(int i=0; i<2; i++)
                    chains.remove(chains.size()-1);

                chains.add(main+sub);

                temp--;

                if(temp > 0)
                    chains.set(0, temp);
                else if(temp == 0)
                    chains.remove(0);

                cnt++;
            }
            else if(chains.size() == 2) {
                cnt++;
                break;
            }
        }

        System.out.println(cnt);
    }
}
