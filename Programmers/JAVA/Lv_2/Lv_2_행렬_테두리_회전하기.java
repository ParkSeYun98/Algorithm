package Programmers.JAVA.Lv_2;

public class Lv_2_행렬_테두리_회전하기 {
    class Solution {
        public int[] solution(int rows, int columns, int[][] queries) {
            int[] answer = new int[queries.length];

            int[][] map = new int[rows][columns];

            int cnt = 1;

            for(int i=0; i<rows; i++) {
                for(int j=0; j<columns; j++)
                    map[i][j] = cnt++;
            }

            for(int i=0; i<queries.length; i++) {
                int startX = queries[i][0];
                int startY = queries[i][1];
                int endX = queries[i][2];
                int endY = queries[i][3];
                int temp = 0;

                answer[i] = move(map, startX - 1, startY - 1, endX - 1, endY - 1);
            }

            return answer;
        }

        public int move(int[][] map, int startX, int startY, int endX, int endY) {
            int temp = map[startX][endY];
            int temp2 = map[endX][endY];
            int temp3 = map[endX][startY];

            for(int i=endY; i>=startY+1; i--)
                map[startX][i] = map[startX][i-1];

            for(int i=endX; i>=startX+2; i--)
                map[i][endY] = map[i-1][endY];

            for(int i=startY; i<=endY-2; i++)
                map[endX][i] = map[endX][i+1];

            for(int i=startX; i<=endX-2; i++)
                map[i][startY] = map[i+1][startY];

            map[startX+1][endY] = temp;
            map[endX][endY-1] = temp2;
            map[endX-1][startY] = temp3;

            int min = Integer.MAX_VALUE;

            for(int i=startX; i<=endX; i++) {
                for(int j=startY; j<=endY; j++) {
                    if(i != startX && j != startY && i != endX && j != endY)
                        continue;

                    min = Math.min(min, map[i][j]);
                }
            }

            return min;
        }
    }
}
