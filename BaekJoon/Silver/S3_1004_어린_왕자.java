package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S3_1004_어린_왕자 {

    static class Planet {
        int x;
        int y;
        int r;

        public Planet(int x, int y, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int n = Integer.parseInt(br.readLine());

            List<Planet> list = new ArrayList<>();

            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int cx = Integer.parseInt(st.nextToken());
                int cy = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                list.add(new Planet(cx, cy, r));
            }

            int cnt = 0;

            for(int i=0; i<list.size(); i++) {
                Planet now = list.get(i);

                double distance1 = getDistance(x1, y1, now);
                double distance2 = getDistance(x2, y2, now);

                if(distance1 < now.r && distance2 >= now.r)
                    cnt++;

                if(distance2 < now.r && distance1 >= now.r)
                    cnt++;
            }

            System.out.println(cnt);
        }
    }

    static double getDistance(int x, int y, Planet now) {
        double temp = Math.pow(x - now.x, 2) + Math.pow(y - now.y, 2);

        return Math.pow(temp, 0.5);
    }
}
