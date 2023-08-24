package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S5_7785_회사에_있는_사람 {

    private static int N;

    private static Map<Integer, String> commutationLogMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            String temp = st.nextToken();

            if(st.nextToken().equals("enter")) {
                commutationLogMap.put(i, temp);
            }
            else {
                for (int k=commutationLogMap.size()-1; k>=0; k--) {
                    if(commutationLogMap.get(k).equals(temp))
                        commutationLogMap.remove(k);
                }
            }
        }

        List<Map.Entry<Integer, String>> entryList = new LinkedList<>(commutationLogMap.entrySet());

        entryList.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));

        for(Map.Entry<Integer, String> entry : entryList)
            System.out.println(entry.getValue());

    }
}
