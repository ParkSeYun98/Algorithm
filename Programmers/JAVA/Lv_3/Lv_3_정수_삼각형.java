package Programmers.JAVA.Lv_3;

class Lv_3_정수_삼각형 {
    public int solution(int[][] triangle) {
        int answer = 0;

        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];

        for(int i=1; i<triangle.length; i++) {
            dp[i][0] = dp[i-1][0] + triangle[i][0];
            dp[i][i] = dp[i-1][i-1] + triangle[i][i];

            for(int j=1; j<=i-1; j++)
                dp[i][j] = triangle[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);
        }

        for(int i=0; i<triangle.length; i++)
            answer = Math.max(answer, dp[triangle.length-1][i]);

        return answer;
    }
}
