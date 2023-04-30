package Programmers.Lv_1;

import java.util.HashSet;

public class Lv_1_폰켓몬 {
    class Solution {
        public int solution(int[] nums) {
            int answer = 0;

            HashSet<Integer> hashSet = new HashSet<>();

            for(int i=0; i<nums.length; i++)
                hashSet.add(nums[i]);

            if(hashSet.size() >= nums.length/2)
                answer = nums.length/2;
            else
                answer = hashSet.size();

            return answer;
        }
    }
}
