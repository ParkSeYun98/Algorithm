package Programmers.JAVA.Lv_2;

class Lv_2_땅따먹기 {
    int solution(int[][] land) {
        for(int i=1; i<land.length; i++) {
            for(int j=0; j<land[0].length; j++) {
                int tempMax = 0;

                for(int k=0; k<4; k++) {
                    if(j == k)
                        continue;

                    tempMax = Math.max(tempMax, land[i-1][k]);
                }

                land[i][j] += tempMax;
            }
        }

        int answer = 0;

        for(int i=0; i<4; i++)
            answer = Math.max(answer, land[land.length-1][i]);

        return answer;
    }
}