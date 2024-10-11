package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G4_7662_이중_우선순위_큐 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc=1; tc<=T; tc++) {
            int k = Integer.parseInt(br.readLine());

            Map<Integer, Integer> map = new HashMap<>();
            PriorityQueue<Integer> minQueue = new PriorityQueue<>();
            PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());

            for (int i=0; i<k; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                String str = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (str.equals("I")) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                    minQueue.add(num);
                    maxQueue.add(num);
                }
                else {
                    if (map.isEmpty())
                        continue;

                    PriorityQueue<Integer> queue = num == 1 ? maxQueue : minQueue;
                    removeMap(queue, map);
                }
            }

            if (map.isEmpty())
                System.out.println("EMPTY");
            else {
                int n = removeMap(maxQueue, map);

                System.out.println(n + " " + (!map.isEmpty() ? removeMap(minQueue, map) : n));
            }

        }

    }

    static int removeMap(PriorityQueue<Integer> queue, Map<Integer, Integer> map) {
        int num;

        while (true) {
            num = queue.poll();

            int cnt = map.getOrDefault(num, 0);

            if (cnt == 0)
                continue;
            else if (cnt == 1)
                map.remove(num);
            else
                map.put(num, cnt - 1);

            break;
        }

        return num;
    }

}