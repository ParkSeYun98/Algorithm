package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G3_4386_별자리_만들기 {
    static int n;
    static double cost = 0;

    static int[] parent;
    static Point[] point;

    static double[][] constellation;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        parent = new int[n+1];
        point = new Point[n];
        constellation = new double[n*(n-1)/2][3];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());

            point[i] = new Point(x, y, i);
        }

        int idx = 0;

        for(int i=0; i<n-1; i++) {
            for(int j=i+1; j<n; j++) {
                constellation[idx][0] = point[i].idx;
                constellation[idx][1] = point[j].idx;
                constellation[idx][2] = getDistance(point[i], point[j]);

                idx++;
            }
        }

        Arrays.sort(constellation, (o1, o2) -> Double.compare(o1[2], o2[2]));

        makeSet();
        Kruskal();

        System.out.println(cost);
    }

    static void makeSet() {
        for(int i=0; i<n; i++)
            parent[i] = i;
    }

    static double findSet(double x) {
        if(parent[(int) x] == x)
            return x;
        return findSet(parent[(int) x]);
    }

    static void union(double x, double y) {
        x = findSet(x);
        y = findSet(y);

        if(x > y)
            parent[(int) x] = (int) y;
        else
            parent[(int) y] = (int) x;
    }

    static void Kruskal() {
        int cnt = 0;

        for(int i=0; i<constellation.length; i++) {
            if(findSet(constellation[i][0]) != findSet(constellation[i][1])) {
                union(constellation[i][0], constellation[i][1]);
                cost += constellation[i][2];
                cnt++;
            }

            if(cnt == n-1)
                break;
        }
    }

    static double getDistance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(Math.abs(p1.r - p2.r), 2) + Math.pow(Math.abs(p1.c - p2.c), 2));
    }

    static class Point {
        double r;
        double c;
        int idx;

        public Point(double r, double c, int idx) {
            this.r = r;
            this.c = c;
            this.idx = idx;
        }
    }
}
