/*
* Memory : 11540 KB
* Time : 76 ms
* */

package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S3_16165_걸그룹_마스터_준석이 {

    static int N, M;

    static Map<String, List<String>> group;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        group = new HashMap<>();

        for(int i=0; i<N; i++) {
            String groupName = br.readLine();

            int memberSize = Integer.parseInt(br.readLine());

            List<String> memberList = new ArrayList<>();

            for(int j=0; j<memberSize; j++)
                memberList.add(br.readLine());

            group.put(groupName, memberList);
        }

        for(int i=0; i<M; i++) {
            String input = br.readLine();
            int quizNum = Integer.parseInt(br.readLine());

            solveQuiz(input, quizNum);
        }
    }

    static void solveQuiz(String input, int quizNum) {
        if(quizNum == 0) {
            List<String> memberList = group.get(input);

            Collections.sort(memberList);

            for (String member : memberList)
                System.out.println(member);
        }
        else {
            for (Map.Entry<String, List<String>> memberEntry : group.entrySet()) {
                if(memberEntry.getValue().contains(input))
                    System.out.println(memberEntry.getKey());
            }
        }
    }
}
