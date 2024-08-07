package BaekJoon.Silver;

import java.util.*;
import java.io.*;

public class S4_3048_개미 {
    static class Ant {
        char ch;
        int idx;

        public Ant(char value, int direction){
            this.ch = value;
            this.idx = direction;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N1 = Integer.parseInt(st.nextToken());
        int N2 = Integer.parseInt(st.nextToken());

        Ant[] antArr1 = new Ant[N1+1];
        Ant[] antArr2 = new Ant[N2+1];

        String input = br.readLine();

        for(int i=N1-1; i>=0; i--){
            antArr1[i] = new Ant(input.charAt(N1-i-1), 1);
        }

        input = br.readLine();

        for(int i=0; i<N2; i++){
            antArr2[i] = new Ant(input.charAt(i), -1);
        }

        Ant[] start = new Ant[N1+N2];

        for(int i=0; i<N1; i++)
            start[i] = antArr1[i];
        for(int i=N1; i<N1+N2; i++)
            start[i] = antArr2[i-N1];

        int T = Integer.parseInt(br.readLine());

        Ant[] end = start;

        for(int i=0; i<T; i++){
            Ant[] now = end.clone();

            for(int j=0; j<N1+N2-1; j++){
                if(now[j].idx == 1 && now[j+1].idx == -1){
                    Ant tmp = now[j];
                    end[j] = now[j+1];
                    end[j+1] = tmp;
                }
                else
                    continue;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N1+N2; i++)
            sb.append(end[i].ch);

        bw.write(sb.toString());
        bw.close();
    }
}