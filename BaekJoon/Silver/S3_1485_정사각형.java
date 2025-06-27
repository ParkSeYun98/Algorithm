package BaekJoon.Silver;

import java.io.*;
import java.util.*;

public class S3_1485_정사각형 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for (int i=0; i<tc; i++) {

            ArrayList<Point> pointList = new ArrayList<>();

            for (int j=0; j<4; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y =Integer.parseInt(st.nextToken());

                pointList.add(new Point(x, y));
            }


            double[] len = new double[6];
            int count=0;

            for (int j=0; j<3; j++) {
                for (int k=j+1; k<4; k++) {
                    if (j==0 && k==1)
                        len[count++] = calculateDistance(pointList.get(j), pointList.get(k));
                    else
                        len[count++] = calculateDistance(pointList.get(j), pointList.get(k));
                }
            }

            boolean isSquare = true;

            Arrays.sort(len);

            for (int j=1; j<4; j++)
                if (len[0] != len[j])
                    isSquare = false;

            if (len[4] != len[5])
                isSquare = false;

            if (isSquare)
                bw.write(1 + "\n");
            else
                bw.write(0 + "\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }

    static double calculateDistance(Point point1, Point point2) {
        int dx = point1.x - point2.x;
        int dy = point1.y - point2.y;

        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }
}

class Point {
    int x;
    int y;

    public Point (int x, int y) {
        this.x = x;
        this.y = y;
    }
}