/*
* Memory : 19044 KB
* Time : 204 ms
* */

package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G5_21608_상어_초등학교 {

    static int N;

    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    static int[][] map;
    static int[][] studentArr;

    static class Student implements Comparable<Student> {
        int r;
        int c;
        int likeCnt;
        int emptyCnt;

        public Student(int r, int c, int likeCnt, int emptyCnt) {
            this.r = r;
            this.c = c;
            this.likeCnt = likeCnt;
            this.emptyCnt = emptyCnt;
        }

        @Override
        public int compareTo(Student o) {
            if(this.likeCnt == o.likeCnt) {
                if(this.emptyCnt == o.emptyCnt) {
                    if(this.r == o.r)
                        return this.c - o.c;

                    return this.r - o.r;
                }

                return o.emptyCnt - this.emptyCnt;
            }

            return o.likeCnt - this.likeCnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        studentArr = new int[(int) Math.pow(N, 2)+1][5];

        for(int i=1; i<=(int) Math.pow(N, 2); i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<5; j++)
                studentArr[i][j] = Integer.parseInt(st.nextToken());
        }

        setUp();
        getSatisfaction();
    }

    static void setUp() {
        for(int st=1; st<studentArr.length; st++) {
            PriorityQueue<Student> pq = new PriorityQueue<>();

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(map[i][j] == 0)
                        pq.offer(checkSeat(st, i, j));
                }
            }
            
            Student fitSeat = pq.peek();
            map[fitSeat.r][fitSeat.c] = studentArr[st][0];
        }
    }

    static Student checkSeat(int st, int r, int c) {
        int likeCnt = 0;
        int emptyCnt = 0;

        for(int d=0; d<4; d++) {
            int nextR = r + dr[d];
            int nextC = c + dc[d];

            if(outOfMapCheck(nextR, nextC))
                continue;

            if(map[nextR][nextC] == 0)
                emptyCnt++;

            for(int i=1; i<studentArr[st].length; i++) {
                if(map[nextR][nextC] == studentArr[st][i]) {
                    likeCnt++;
                    break;
                }
            }
        }

        return new Student(r, c, likeCnt, emptyCnt);
    }

    static void getSatisfaction() {
        int sum = 0;

        for(int r=0; r<N; r++) {
            for(int c=0; c<N; c++) {
                int cnt = 0;

                for(int d=0; d<4; d++) {
                    int nextR = r + dr[d];
                    int nextC = c + dc[d];

                    if(outOfMapCheck(nextR, nextC))
                        continue;

                    outer : for(int i=0; i<studentArr.length; i++) {
                        if(studentArr[i][0] == map[r][c]) {
                            for(int j=0; j<studentArr[i].length; j++) {
                                if(studentArr[i][j] == map[nextR][nextC]) {
                                    cnt++;
                                    break outer;
                                }
                            }
                        }
                    }
                }

                if(cnt > 0)
                    sum += (int) Math.pow(10, cnt-1);
            }
        }

        System.out.println(sum);
    }

    static boolean outOfMapCheck(int r, int c) {
        return r<0 || c<0 || r>=N || c>=N;
    }
}
