package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class S3_2621_카드게임 {

    static List<Card> list;

    static class Card implements Comparable<Card> {
        int num;
        String color;

        public Card(int num, String color) {
            this.num = num;
            this.color = color;
        }

        @Override
        public int compareTo(Card o) {
            return this.num - o.num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        list = new ArrayList<>();

        for(int i=0; i<5; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            String color = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            list.add(new Card(num, color));
        }

        Collections.sort(list);

        System.out.println(getScore());
    }

    static int getScore() {
        int firstNum = list.get(0).num;
        String firstColor = list.get(0).color;

        boolean continuousNumFlag = true;
        boolean allSameColorFlag = true;

        for(int i=0; i<list.size(); i++) {
            if(list.get(i).num != firstNum++)
                continuousNumFlag = false;

            if(!list.get(i).color.equals(firstColor))
                allSameColorFlag = false;
        }

        if(continuousNumFlag && allSameColorFlag)
            return list.get(4).num + 900;

        if(!continuousNumFlag && allSameColorFlag)
            return list.get(4).num + 600;

        if(continuousNumFlag && !allSameColorFlag)
            return list.get(4).num + 500;

        int[] scoreArr = new int[10];

        for(int i=0; i<list.size(); i++)
            scoreArr[list.get(i).num]++;

        int threeIdx = -1;
        List<Integer> twoIdxList = new ArrayList<>();

        for(int i=0; i<scoreArr.length; i++) {
            if(scoreArr[i] == 4)
                return list.get(i).num + 800;
            else if(scoreArr[i] == 3)
                threeIdx = i;
            else if(scoreArr[i] == 2)
                twoIdxList.add(i);
        }

        if(threeIdx != -1 && !twoIdxList.isEmpty())
            return threeIdx * 10 + twoIdxList.get(0) + 700;

        if(threeIdx != -1 && twoIdxList.isEmpty())
            return threeIdx + 400;

        Collections.sort(twoIdxList);

        if(twoIdxList.size() == 2)
            return 10 * twoIdxList.get(1) + twoIdxList.get(0) + 300;

        if(threeIdx == -1 && twoIdxList.size() == 1)
            return twoIdxList.get(0) + 200;

        return list.get(4).num + 100;
    }
}
