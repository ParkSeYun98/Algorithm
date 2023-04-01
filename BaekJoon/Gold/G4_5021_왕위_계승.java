package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G4_5021_왕위_계승 {
    private static HashMap<String, List<String>> familyMap;
    private static HashMap<String, Double> bloodMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        familyMap = new HashMap<>();
        bloodMap = new HashMap<>();

        String builder = br.readLine();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String child = st.nextToken();
            String parentA = st.nextToken();
            String parentB = st.nextToken();

            familyMap.put(child, new ArrayList<>());
            familyMap.get(child).add(parentA);
            familyMap.get(child).add(parentB);

            bloodMap.put(child, -1d);
            bloodMap.put(parentA, -1d);
            bloodMap.put(parentB, -1d);
        }

        bloodMap.put(builder, 1d);

        String[] candidate = new String[M];

        for(int i=0; i<M; i++)
            candidate[i] = br.readLine();

        TopologicalSort();

        double max = -2d;
        String successor = "";
        Set<String> keySet2 = bloodMap.keySet();

        for(String key : keySet2) {
            for(int i = 0; i< candidate.length; i++)
                if(Objects.equals(candidate[i], key)) {
                    if(max <= bloodMap.get(key)) {
                        max = bloodMap.get(key);
                        successor = key;
                    }
                }
        }

        System.out.println(successor);
    }

    public static void TopologicalSort() {
        for(String name : bloodMap.keySet())
            DFS(name);
    }

    public static double DFS(String name) {
        if(bloodMap.get(name) != -1)
            return bloodMap.get(name);

        if(familyMap.get(name) == null) {
            bloodMap.put(name, 0d);
            return bloodMap.get(name);
        }

        double parentA = DFS(familyMap.get(name).get(0));
        double parentB = DFS(familyMap.get(name).get(1));

        bloodMap.put(name, (parentA + parentB) / 2);

        return bloodMap.get(name);
    }
}
