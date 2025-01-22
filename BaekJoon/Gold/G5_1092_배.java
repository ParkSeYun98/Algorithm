package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G5_1092_배 {

    static int N, M;

    static List<Integer> crain;
    static List<Integer> box;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        crain = new ArrayList<>();
        box = new ArrayList<>();

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++)
            crain.add(Integer.parseInt(st.nextToken()));

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<M; i++)
            box.add(Integer.parseInt(st.nextToken()));

        crain.sort(Collections.reverseOrder());
        box.sort(Collections.reverseOrder());

        if(crain.get(0) < box.get(0)) {
            System.out.println(-1);
            return;
        }

        int cnt = 0;

        while(!box.isEmpty()) {
            int crainIdx = 0;
            int boxIdx = 0;

            while(crainIdx < N) {
                if(boxIdx == box.size())
                    break;

                if(crain.get(crainIdx) >= box.get(boxIdx)) {
                    box.remove(boxIdx);
                    crainIdx++;
                }
                else
                    boxIdx++;
            }

            cnt++;
        }

        System.out.println(cnt);
    }
}
