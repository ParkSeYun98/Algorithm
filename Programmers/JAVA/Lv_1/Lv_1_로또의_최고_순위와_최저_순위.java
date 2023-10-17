package Programmers.JAVA.Lv_1;

public class Lv_1_로또의_최고_순위와_최저_순위 {

    class Solution {
        public int[] solution(int[] lottos, int[] win_nums) {
            int[] answer = new int[2];

            int cnt = 0;
            int zeroCnt = 0;

            for(int i=0; i<lottos.length; i++) {
                if(lottos[i] == 0) {
                    zeroCnt++;
                    continue;
                }

                for(int j=0; j<win_nums.length; j++) {
                    if(lottos[i] == win_nums[j])
                        cnt++;
                }
            }

            if(cnt + zeroCnt == 0)
                answer[0] = 6;
            else
                answer[0] = 7 - (cnt + zeroCnt);

            if(cnt == 0)
                answer[1] = 6;
            else
                answer[1] = 7 - cnt;

            return answer;
        }
    }
}
