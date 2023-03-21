package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G4_9019_DSLR {
    private static int A;
    private static int B;
    private static String result;

    private static char[] order = {'D', 'S', 'L', 'R'};
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            result = "";
            visited = new boolean[10000];

            BFS();

            System.out.println(result);
        }
    }

    public static void BFS() {
        Queue<history> queue = new LinkedList<>();
        queue.offer(new history(A, ""));
        visited[A] = true;

        while(!queue.isEmpty()) {
            history now = queue.poll();

            for(int d=0; d<4; d++) {
                int next = process(d, now.point);

                if(next == B) {
                    result = now.hist + order[d];
                    return;
                }

                if(!visited[next]) {
//				System.out.println(now.hist + order[d]);
                    queue.offer(new history(next, now.hist + order[d]));
                    visited[next] = true;
                }
            }
        }
    }

    public static int process(int order, int now) {
        if(order == 0) {
            int target = 2 * now;

            if(target > 9999)
                return target %= 10000;
            return target;
        }
        else if(order == 1) {
            int target = now - 1;

            if(target == -1)
                return 9999;
            return target;
        }
        else if(order == 2) {
            int arr[] = new int[4];

            for(int i=arr.length-1; i>=0; i--) {
                arr[i] = now % 10;
                now /= 10;
            }

            int temp = arr[0];
            for(int i=0; i<arr.length-1; i++)
                arr[i] = arr[i+1];
            arr[arr.length-1] = temp;

            int target = 0;

            for(int i=0; i<arr.length; i++)
                target += arr[i] * Math.pow(10, arr.length-1-i);

            return target;
        }
        else {
            int arr[] = new int[4];

            for(int i=arr.length-1; i>=0; i--) {
                arr[i] = now % 10;
                now /= 10;
            }

            int temp = arr[arr.length-1];
            for(int i=arr.length-1; i>0; i--)
                arr[i] = arr[i-1];
            arr[0] = temp;

            int target = 0;

            for(int i=0; i<arr.length; i++)
                target += arr[i] * Math.pow(10, arr.length-1-i);

            return target;
        }
    }

    public static class history {
        int point;
        String hist;

        public history(int point, String hist) {
            this.point = point;
            this.hist = hist;
        }
    }
}