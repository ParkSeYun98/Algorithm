package Programmers.JAVA.Lv_1;

class Lv_1_PCCP_기출문제_1번 {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int nowHP = health;
        int t = 0;
        int attackIdx = 0;
        int healCnt = 0;

        while(true) {
            if(nowHP <= 0)
                return -1;

            if(attackIdx == attacks.length)
                break;

            if(t == attacks[attackIdx][0]) {
                nowHP -= attacks[attackIdx][1];
                attackIdx++;
                healCnt = 0;
            } else {
                healCnt++;

                if(nowHP + bandage[1] > health)
                    nowHP = health;
                else
                    nowHP += bandage[1];

                if(healCnt == bandage[0]) {
                    if(nowHP + bandage[2] > health)
                        nowHP = health;
                    else
                        nowHP += bandage[2];

                    healCnt = 0;
                }
            }

            t++;
        }

        return nowHP;
    }
}