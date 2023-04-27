package Programmers.Lv_2;

import java.util.ArrayList;
import java.util.List;

public class Lv_2_카펫 {
    class Solution {
        public int[] solution(int brown, int yellow) {
            int[] answer = new int[2];

            List<Point> candidate = new ArrayList<>();

            getCases(candidate, brown + yellow);

            findResult(candidate, yellow, answer);

            return answer;
        }

        void getCases(List<Point> candidate, int all) {
            for(int i=1; i<=all; i++) {
                if(all % i == 0)
                    candidate.add(new Point(all/i, i));
            }
        }

        void findResult(List<Point> candidate, int yellow, int[] answer) {
            for(int i=0; i<candidate.size(); i++) {
                if(((candidate.get(i).a-2) * (candidate.get(i).b-2)) == yellow) {
                    answer[0] = candidate.get(i).a;
                    answer[1] = candidate.get(i).b;
                    break;
                }
            }
        }

        public class Point {
            int a;
            int b;

            public Point(int a, int b) {
                this.a = a;
                this.b = b;
            }
        }
    }
}
