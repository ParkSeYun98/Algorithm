package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G3_16235_나무_재테크 {
    static int N;
    static int M;
    static int K;

    static final int[] dr = {0, 0, 1, -1, 1, 1, -1, -1};
    static final int[] dc = {1, -1, 0, 0, -1, 1, -1, 1};

    static int[][] nutrient;
    static int[][] tempNutrient;

    static List<Tree>[][] soil;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        soil = new ArrayList[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++)
                soil[i][j] = new ArrayList<>();
        }

        nutrient = new int[N][N];
        tempNutrient = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<N; j++) {
                tempNutrient[i][j] = Integer.parseInt(st.nextToken());
                nutrient[i][j] = 5;
            }
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int age = Integer.parseInt(st.nextToken());

            soil[x][y].add(new Tree(x, y, age, false));
        }

        timeGoesOn();

        Print();
    }

    static void timeGoesOn() {
        int year = 0;

        while (year < K) {
            for (int season = 0; season < 4; season++) {
                switch (season) {
                    case 0:
                        spring();
                        break;
                    case 1:
                        summer();
                        break;
                    case 2:
                        autumn();
                        break;
                    case 3:
                        winter();
                        break;
                }
            }

            year++;
        }
    }

    static void spring() {
        for(int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                Collections.sort(soil[i][j]);

                for(int k=0; k<soil[i][j].size(); k++) {
                    if(soil[i][j].get(k).age <= nutrient[i][j]) {
                        nutrient[i][j] -= soil[i][j].get(k).age;
                        soil[i][j].get(k).age++;
                    }
                    else
                        soil[i][j].get(k).death = true;
                }
            }
        }
    }

    static void summer() {
        for(int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                for(int k=soil[i][j].size()-1; k>=0; k--) {
                    if(soil[i][j].get(k).death) {
                        nutrient[i][j] += (soil[i][j].get(k).age/2);
                        soil[i][j].remove(k);
                    }
                }
            }
        }
    }

    static void autumn() {
        for(int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                for(int k=0; k<soil[i][j].size(); k++) {
                    if(soil[i][j].get(k).age % 5 == 0) {
                        for(int d=0; d<8; d++) {
                            int nextR = i + dr[d];
                            int nextC = j + dc[d];

                            if(outofmapCheck(nextR, nextC))
                                continue;

                            soil[nextR][nextC].add(new Tree(nextR, nextC, 1, false));
                        }
                    }
                }
            }
        }
    }

    static void winter() {
        for(int i=0; i<N; i++) {
            for (int j=0; j<N; j++)
                nutrient[i][j] += tempNutrient[i][j];
        }
    }

    static void Print() {
        int sum = 0;

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++)
                sum += soil[i][j].size();
        }

        System.out.println(sum);
    }

    static boolean outofmapCheck(int r, int c) {
        return r<0 || c<0 || r>=N || c>=N;
    }

    static class Tree implements Comparable<Tree> {
        int r;
        int c;
        int age;
        boolean death;

        public Tree(int r, int c, int age, boolean death) {
            this.r = r;
            this.c = c;
            this.age = age;
            this.death = death;
        }

        @Override
        public int compareTo(Tree o) {
            return this.age - o.age;
        }
    }
}