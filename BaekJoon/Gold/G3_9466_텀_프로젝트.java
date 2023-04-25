package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G3_9466_텀_프로젝트 {
    static int n;
    static int firstNum;
    static int cnt;

    static int[] students;
    static boolean[] checked;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            n = Integer.parseInt(br.readLine());

            students = new int[n+1];

            st = new StringTokenizer(br.readLine(), " ");
            for(int i=1; i<students.length; i++)
                students[i] = Integer.parseInt(st.nextToken());

            checked = new boolean[n+1];
            visited = new boolean[n+1];

            cnt = 0;

            for(int i=1; i<students.length; i++) {
                if(!checked[i])
                    DFS(i);
            }

            System.out.println(n - cnt);
        }
    }

    static void DFS(int now) {
        if(!visited[now]) {
            visited[now] = true;

            if(!visited[students[now]])
                DFS(students[now]);
            else {
                if(!checked[students[now]]) {
                    cnt++;

                    for(int i=students[now]; i!=now; i=students[i]) {
                        checked[i] = true;
                        cnt++;
                    }
                }
            }

            checked[now] = true;
        }
    }
}
