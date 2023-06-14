package Programmers.JAVA.Lv_2;

public class Lv_2_타겟_넘버 {
    class Solution {
        static int cnt = 0;

        static int[] repository;

        public int solution(int[] numbers, int target) {
            repository = new int[numbers.length];

            DFS(numbers, target, 0);

            return cnt;
        }

        void DFS(int[] numbers, int target, int depth) {
            if(depth == numbers.length) {
                int sum = 0;

                for(int i=0; i<repository.length; i++)
                    sum += repository[i];

                if(sum == target)
                    cnt++;

                return;
            }

            repository[depth] = numbers[depth];
            DFS(numbers, target, depth+1);

            repository[depth] = -numbers[depth];
            DFS(numbers, target, depth+1);
        }
    }
}
