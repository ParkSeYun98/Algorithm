package Programmers.JAVA.Lv_3;

class Lv_3_PCCP_기출문제_3번_아날로그_시계 {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        // 0 ~ 24에서 0 ~ t1, t2 ~ 24를 빼줌

        int answer = getCount(h2, m2, s2) - getCount(h1, m1, s1);

        // 위 경우에서 초를 카운트 하는 0.0.0과 12.0.0은 예외처리가 필요.
        if((h1 == 0 || h1 == 12) && m1 == 0 && s1 == 0)
            answer++;

        return answer;
    }

    public int getCount(int h, int m, int s) {
        double sDegree = getSDegree(s);
        double mDegree = getMDegree(m, s);
        double hDegree = getHDegree(h, m, s);

        int cnt = 0;

        if(sDegree >= mDegree)
            cnt++;

        if(sDegree >= hDegree)
            cnt++;

        // 분당 2회 만남
        cnt += 2*(60*h + m);
        // 59 -> 0일 때는 만나지 않음
        cnt -= h;

        // 11.59.59 -> 12 제외
        if(h >= 12)
            cnt -= 2;

        // 0.0.0은 범위에 포함 X (시작 시간)
        return --cnt;
    }

    public double getSDegree(int s) {
        return (6*s);
    }

    public double getMDegree(int m, int s) {
        return ((6*m + 0.1*s)%360);
    }

    public double getHDegree(int h, int m, int s) {
        return ((30*h + 0.5*m + 0.5*s/60)%360);
    }
}