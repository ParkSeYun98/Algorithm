/*
* Memory : 74772 KB
* Time : 724 ms
* */

package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G5_11000_강의실_배정 {

    static int N;

    static PriorityQueue<Lecture> lectureList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        lectureList = new PriorityQueue<>();

        for(int i=0; i<N; i++) {
            st= new StringTokenizer(br.readLine(), " ");
            int S = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());

            lectureList.offer(new Lecture(S, T));
        }

        allocateRoom();
    }

    static void allocateRoom() {
        PriorityQueue<Integer> endTimeList = new PriorityQueue<>();
        endTimeList.offer(lectureList.poll().end);

        while(!lectureList.isEmpty()) {
            Lecture lecture = lectureList.poll();
            int endTime = endTimeList.peek();

            if(lecture.start >= endTime)
                endTimeList.poll();

            endTimeList.offer(lecture.end);
        }

        System.out.println(endTimeList.size());
    }

    static class Lecture implements Comparable<Lecture> {
        int start;
        int end;

        public Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lecture o) {
            if(this.start == o.start) {
                if(this.end >= o.end)
                    return this.end - o.end;
                else
                    return o.end - this.end;
            }

            return this.start - o.start;
        }
    }
}
