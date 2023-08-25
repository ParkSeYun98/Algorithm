package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S5_7785_회사에_있는_사람 {

    private static int N;

    private static Map<String, String> commutationLogMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            String name = st.nextToken();
            String status = st.nextToken();

            if(commutationLogMap.containsKey(name))
                commutationLogMap.remove(name);
            else
                commutationLogMap.put(name, status);
        }

        List<String> commutationLogList = new ArrayList<>(commutationLogMap.keySet());

        Collections.sort(commutationLogList, Collections.reverseOrder());

        for (String commutationLog : commutationLogList)
            System.out.println(commutationLog);
    }
}
