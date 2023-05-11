package Programmers.JAVA.Lv_2;

import java.util.*;

public class Lv_2_소수_찾기 {
    class Solution {
        public int solution(String numbers) {
            int answer = 0;

            char[] papers = numbers.toCharArray();

            List<Character> str = new ArrayList<>();
            List<Integer> result = new ArrayList<>();

            for(int i=1; i<=numbers.length(); i++) {
                boolean[] visited = new boolean[numbers.length()+1];
                DFS(0, i, str, result, visited, papers);
            }

            System.out.println("result : " + result);

            for(int i=result.size()-1; i>=0; i--) {
                if(!isPrime(result.get(i)))
                    result.remove(i);
            }

            System.out.println("result : " + result);

            answer = result.size();

            return answer;
        }

        void DFS(int depth, int max, List<Character> strList, List<Integer> result, boolean[] visited, char[] papers) {
            if(depth == max) {
                String str = "";

                for(int i=0; i<strList.size(); i++) {
                    if(i == 0 && strList.get(i) == '0')
                        return;

                    str += strList.get(i);
                }

                if(str != "" && !result.contains(Integer.parseInt(str)))
                    result.add(Integer.parseInt(str));

                return;
            }

            for(int i=0; i<papers.length; i++) {
                if(!visited[i]) {
                    visited[i] = true;
                    strList.add(papers[i]);
                    DFS(depth+1, max, strList, result, visited, papers);
                    strList.remove(strList.size()-1);
                    visited[i] = false;
                }
            }
        }

        boolean isPrime(int n) {
            if(n == 1)
                return false;

            for (int i = 2; i<=(int)Math.sqrt(n); i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
