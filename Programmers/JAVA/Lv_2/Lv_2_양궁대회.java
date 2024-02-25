package Programmers.JAVA.Lv_2;

class Lv_2_양궁대회 {
    int max;
    int[] lionInfo;
    int[] answer;

    public int[] solution(int n, int[] info) {
        max = -1;
        lionInfo = new int[11];
        answer = new int[]{-1};

        Backtracking(info, 0, 0, n);

        return answer;
    }

    //idx는 점수 0~10까지 접근, cnt는 사용한 화살 수
    void Backtracking(int[] apeachInfo, int idx, int cnt, int n) {
        if(idx == 11) {
            if(idx == 11 && cnt == n) {
                int apeachScore = 0;
                int lionScore = 0;

                for(int i=0; i<11; i++) {
                    if(apeachInfo[i] == 0 && lionInfo[i] == 0)
                        continue;

                    if(apeachInfo[i]>=lionInfo[i])
                        apeachScore += 10-i;
                    else
                        lionScore += 10-i;
                }

                if(lionScore>apeachScore) {
                    int diff = lionScore - apeachScore;

                    if(diff > max) {
                        max = diff;
                        answer = lionInfo.clone();
                    }
                    else if(diff == max) {
                        for(int i=10; i>=0; i--) {
                            if(answer[i] < lionInfo[i]) {
                                answer = lionInfo.clone();
                                return;
                            }
                            else if(answer[i] > lionInfo[i])
                                return;
                        }
                    }
                }
            }

            return;
        }

        if(apeachInfo[idx] == 0)
            Backtracking(apeachInfo, idx+1, cnt, n);

        if(cnt+1+apeachInfo[idx] <= n) {
            lionInfo[idx] = apeachInfo[idx]+1;
            Backtracking(apeachInfo, idx+1, cnt+1+apeachInfo[idx], n);
            lionInfo[idx] = 0;
        }

        if(apeachInfo[idx] != 0) {
            for(int i = 0; i<=apeachInfo[idx]; i++) {
                lionInfo[idx] = i;
                Backtracking(apeachInfo, idx+1, cnt+i, n);
                lionInfo[idx] = 0;
            }
        }

    }
}