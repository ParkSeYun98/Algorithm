package Programmers.JAVA.Lv_1;

public class Lv_1_최소직사각형 {
    class Solution {
        public int solution(int[][] sizes) {
            int answer = 0;

            for(int i=0; i<sizes.length; i++) {
                if(sizes[i][0] < sizes[i][1])
                    switching(i, sizes);
            }

            answer = calc(sizes);

            return answer;
        }

        void switching(int idx, int[][] sizes) {
            int temp = sizes[idx][0];
            sizes[idx][0] = sizes[idx][1];
            sizes[idx][1] = temp;
        }

        int calc(int[][] sizes) {
            int maxWidth = -1;
            int maxHeight = -1;

            for(int i=0; i<sizes.length; i++) {
                maxWidth = Math.max(maxWidth, sizes[i][0]);
                maxHeight = Math.max(maxHeight, sizes[i][1]);
            }

            return maxWidth*maxHeight;
        }
    }
}
