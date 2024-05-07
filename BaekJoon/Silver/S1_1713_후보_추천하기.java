package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S1_1713_후보_추천하기 {

    static int N, M;

    static Student[] recommendNum;

    static List<Student> list;

    static class Student implements Comparable<Student> {
        int num;
        int cnt;
        int time;
        boolean in;

        public Student(int num, int cnt, int time, boolean in) {
            this.num = num;
            this.cnt = cnt;
            this.time = time;
            this.in = in;
        }


        @Override
        public int compareTo(Student o) {
            if(this.cnt < o.cnt)
                return -1;
            else if(this.cnt == o.cnt) {
                if(this.time < o.time)
                    return -1;

                return 1;
            }
            else
                return 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        recommendNum = new Student[101];
        list = new ArrayList<>();

        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<M; i++) {
            int now = Integer.parseInt(st.nextToken());

            if(recommendNum[now] == null)
                recommendNum[now] = new Student(now, 0, 0, false);

            if(recommendNum[now].in)
                recommendNum[now].cnt++;
            else {
                if(list.size() == N) {
                    Collections.sort(list);

                    Student student = list.remove(0);
                    student.in = false;
                    student.cnt = 0;
                }

                recommendNum[now].cnt++;
                recommendNum[now].in = true;
                recommendNum[now].time = i;

                list.add(recommendNum[now]);
            }
        }

        Collections.sort(list, new Comparator<Student>() {

            @Override
            public int compare(Student o1, Student o2) {
                return Integer.compare(o1.num, o2.num);
            }
        });

        for (Student student : list)
            System.out.print(student.num + " ");
    }
}
