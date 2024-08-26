package Programmers.JAVA.Lv_2;

import java.util.*;

public class Lv_2_1차_뉴스_클러스터링 {

    public int solution(String str1, String str2) {
        List<String> listA = new ArrayList<>();
        List<String> listB = new ArrayList<>();
        List<String> intersection = new ArrayList<>();
        List<String> union = new ArrayList<>();

        for(int i=0; i<str1.length()-1; i++) {
            char A = str1.charAt(i);
            char B = str1.charAt(i+1);

            if(A >= 65 && A <= 90)
                A += 32;
            if(B >= 65 && B <= 90)
                B += 32;

            String str = "";

            if(A>=97 && A<=122 && B>=97 && B<=122) {
                str = String.valueOf(A) + String.valueOf(B);
                listA.add(str);
            }
        }

        for(int i=0; i<str2.length()-1; i++) {
            char A = str2.charAt(i);
            char B = str2.charAt(i+1);

            if(A >= 65 && A <= 90)
                A += 32;
            if(B >= 65 && B <= 90)
                B += 32;

            String str = "";

            if(A>=97 && A<=122 && B>=97 && B<=122) {
                str = String.valueOf(A) + String.valueOf(B);
                listB.add(str);
            }
        }

        for(String strA : listA) {
            if(listB.remove(strA))
                intersection.add(strA);

            union.add(strA);
        }

        for(String strB : listB)
            union.add(strB);

        if(union.isEmpty())
            return 65536;
        else
            return (65536 * intersection.size()) / (union.size());
    }
}
