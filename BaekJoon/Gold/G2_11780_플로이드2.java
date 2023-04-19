package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class G2_11780_플로이드2 {
    static final int INF = 999_999_999;

    static int n;
    static int m;

    static int[][] info;
    static int[][] next;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        info = new int[n+1][n+1];
        next = new int[n+1][n+1];

        for(int i=1; i<info.length; i++) {
            for(int j=1; j<info[i].length; j++) {
                info[i][j] = INF;
                next[i][j] = -1;

                if(i == j)
                    info[i][j] = 0;
            }
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            info[a][b] = Math.min(info[a][b], c);
            next[a][b] = a;
        }

        Floyd_Warshall();

        Print();
    }

    static void Floyd_Warshall() {
        for(int k=1; k<=n; k++) {
            for(int i=1; i<=n; i++) {
                for(int j=1; j<=n; j++) {
                    if (info[i][j] > info[i][k] + info[k][j]) {
                        info[i][j] = info[i][k] + info[k][j];
                        next[i][j] = next[k][j];
                    }
                }
            }
        }
    }

    static void Print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // 갈 수 없는 곳은 0으로 초기화
                if (info[i][j] == INF) {
                    info[i][j] = 0;
                }

                sb.append(info[i][j] + " ");
            }
            sb.append("\n");
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(next[i][j] == -1)
                    sb.append("0").append("\n");
                else {
                    Stack path = new Stack<Integer>();
                    int pre = j;

                    path.push(pre);

                    while(true) {
                        if(next[i][pre] == i)
                            break;

                        pre = next[i][pre];
                        path.push(pre);
                    }

                    sb.append(path.size()+1).append(" ").append(i).append(" ");

                    while(!path.isEmpty())
                        sb.append(path.pop()).append(" ");

                    sb.append("\n");
                }
            }
        }

        System.out.println(sb.toString());
    }
}
