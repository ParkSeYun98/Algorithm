package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D3_6808_규영이와_인영이의_카드게임 {
    private static int winA;
    private static int winB;

    private static int[] cardA;
    private static int[] cardB;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            cardA = new int[10];
            boolean[] splitCard = new boolean[19];

            st = new StringTokenizer(br.readLine(), " ");
            for(int i=1; i<=9; i++) {
                int input = Integer.parseInt(st.nextToken());
                cardA[i] = input;
                splitCard[input] = true;
            }

            cardB = new int[10];
            int idx = 1;

            for(int i=1; i<=18; i++) {
                if(!splitCard[i])
                    cardB[idx++] = i;
            }

            visited = new boolean[10];
            winA = 0;
            winB = 0;

            DFS(0, 0, 0);

            System.out.println("#" + tc + " " + winA + " " + winB);
        }
    }

    public static void DFS(int depth, int partSumA, int partSumB) {
        if(depth == 9) {
            if(partSumA > partSumB)
                winA++;
            else if(partSumA < partSumB)
                winB++;

            return;
        }

        for(int i=1; i<=9; i++) {
            if(!visited[i]) {
                if(cardA[depth+1] > cardB[i]) {
                    visited[i] = true;
                    DFS(depth+1,partSumA + cardA[depth+1] + cardB[i], partSumB);
                    visited[i] = false;
                }
                else if(cardA[depth+1] < cardB[i]) {
                    visited[i] = true;
                    DFS(depth+1, partSumA, partSumB + cardA[depth+1] + cardB[i]);
                    visited[i] = false;
                }
            }
        }
    }
}
