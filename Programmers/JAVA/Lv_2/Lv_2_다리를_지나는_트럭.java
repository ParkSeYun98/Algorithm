package Programmers.JAVA.Lv_2;

import java.util.LinkedList;
import java.util.Queue;

class Lv_2_다리를_지나는_트럭 {
    class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            int answer = 0;

            Queue<Truck> road = new LinkedList<>();

            int t = 0;
            int idx = 0;
            int weightSum = 0;
            boolean[] check = new boolean[truck_weights.length];

            while(true) {
                t++;

                if(road.size()>0 && road.peek().outRoadTime == t) {
                    weightSum -= road.peek().weight;
                    check[road.poll().idx] = true;
                }

                if(check[check.length-1])
                    break;

                if(idx < truck_weights.length && road.size() <= bridge_length && weightSum+truck_weights[idx] <= weight) {
                    road.offer(new Truck(idx, truck_weights[idx], t+bridge_length));
                    weightSum += truck_weights[idx];
                    idx++;
                }
            }

            answer = t;

            return answer;
        }

        class Truck {
            int idx;
            int weight;
            int outRoadTime;

            public Truck(int idx, int weight, int outRoadTime) {
                this.idx = idx;
                this.weight = weight;
                this.outRoadTime = outRoadTime;
            }
        }
    }
}