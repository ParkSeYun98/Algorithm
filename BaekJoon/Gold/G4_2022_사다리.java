package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_2022_사다리 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        double x = Double.parseDouble(st.nextToken());
        double y = Double.parseDouble(st.nextToken());
        double c = Double.parseDouble(st.nextToken());

        BinarySearch(x, y, c);
    }

    static void BinarySearch(double x, double y, double c) {
        double left = 0;
        double right = Math.min(x, y);

        while((right - left) >= Math.pow(10, -3)) {
            double mid = (left + right) / 2;
            double h1 = Math.sqrt(Math.pow(x, 2) - Math.pow(mid, 2));
            double h2 = Math.sqrt(Math.pow(y, 2) - Math.pow(mid, 2));

            double realC = (h1*h2) / (h1+h2);

            if(realC >= c)
                left = mid;
            else
                right = mid;
        }

        System.out.printf("%.3f%n", right);
    }
}
