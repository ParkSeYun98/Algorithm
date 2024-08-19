package Programmers.JAVA.Lv_2;

import java.util.*;

public class Lv_2_점프와_순간_이동 {
    public int solution(int n) {
        int battery = 0;

        while(n > 0) {
            if(n%2 == 0)
                n /= 2;
            else {
                battery++;
                n--;
            }

        }

        return battery;
    }
}
