package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G2_21609_상어_중학교 {

    static int N, M, score;

    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    static int[][] board, blockInfo;
    static boolean[][] visited;

    static Map<Integer, Block> blockMap;

    static Map<Integer, List<Point>> updateMap;

    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static class Block {
        int leaderR;
        int leaderC;
        int size;

        public Block(int leaderR, int leaderC, int size) {
            this.leaderR = leaderR;
            this.leaderC = leaderC;
            this.size = size;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        score = 0;
        board = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<N; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }

        autoPlay();

        System.out.println(score);
    }

    static void autoPlay() {
        
        while(true) {
            int biggestKey = findBiggestBlock();

            if(biggestKey == -1)
                break;

            removeBiggestBlock(biggestKey);

            getScore(biggestKey);

            gravityOn();

            rotate();

            gravityOn();
        }
    }

    static int findBiggestBlock() {
        visited = new boolean[N][N];
        blockInfo = new int[N][N];
        blockMap = new HashMap<>();
        updateMap = new HashMap<>();

        int idx = 1;

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(blackCheck(i, j))
                    continue;

                if(rainbowCheck(i, j))
                    continue;

                if(visitCheck(i, j))
                    continue;
                
                if(emptyCheck(i, j))
                    continue;

                if(visited[i][j])
                    continue;

                BFS(new Point(i, j), idx++, board[i][j]);
            }
        }

        update();

        int maxValue = -1;
        int maxKey = -1;
        int maxLeaderR = -1;
        int maxLeaderC = -1;

        for (Map.Entry<Integer, Block> entry : blockMap.entrySet()) {
            if(entry.getValue().size == 1)
                continue;


            if(maxValue < entry.getValue().size) {
                maxValue = entry.getValue().size;
                maxKey = entry.getKey();
                maxLeaderR = entry.getValue().leaderR;
                maxLeaderC = entry.getValue().leaderC;
            }
            else if(maxValue == entry.getValue().size) {
                int rainbowCntA = rainbowCount(maxKey);
                int rainbowCntB = rainbowCount(entry.getKey());

                if(rainbowCntA < rainbowCntB) {
                    maxValue = entry.getValue().size;
                    maxKey = entry.getKey();
                    maxLeaderR = entry.getValue().leaderR;
                    maxLeaderC = entry.getValue().leaderC;
                }
                else if(rainbowCntA == rainbowCntB) {
                    if(maxLeaderR < entry.getValue().leaderR) {
                        maxValue = entry.getValue().size;
                        maxKey = entry.getKey();
                        maxLeaderR = entry.getValue().leaderR;
                        maxLeaderC = entry.getValue().leaderC;
                    }
                    else if(maxLeaderR == entry.getValue().leaderR) {
                        if(maxLeaderC < entry.getValue().leaderC) {
                            maxValue = entry.getValue().size;
                            maxKey = entry.getKey();
                            maxLeaderR = entry.getValue().leaderR;
                            maxLeaderC = entry.getValue().leaderC;
                        }
                    }
                }
            }
        }
        
        return maxKey;
    }
    
    static void removeBiggestBlock(int biggestKey) {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(blockInfo[i][j] == biggestKey)
                    board[i][j] = -2;
            }
        }
    }
    
    static void getScore(int biggestKey) {
        score += (int) Math.pow(blockMap.get(biggestKey).size, 2);
    }

    static void gravityOn() {
        for(int i=0; i<N; i++) {
            List<Point> dropList = new ArrayList<>();

            for(int j=N-1; j>=0; j--) {
                if(board[j][i] == -1 || board[j][i] == -2)
                    continue;

                dropList.add(new Point(j, i));
            }
            
            for (Point now : dropList) {
                if(now.r == N-1)
                    continue;

                for(int j=now.r+1; j<N; j++) {
                    if(board[j][i] == -2) {
                        board[j][i] = board[j-1][i];
                        board[j-1][i] = -2;
                    }
                    else
                        break;
                }
            }
        }
    }

    static void rotate() {
        int[][] rotateArr = new int[N][N];

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                rotateArr[i][j] = board[j][N-1-i];
            }
        }

        for(int i=0; i<N; i++)
            board[i] = rotateArr[i].clone();
    }

    static void BFS(Point start, int idx, int color) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(start);

        boolean[][] tempVisited = new boolean[N][N];
        tempVisited[start.r][start.c] = true;
        visited[start.r][start.c] = true;

        blockInfo[start.r][start.c] = idx;
        int cnt = 1;

        List<Point> tempList = new ArrayList<>();
        tempList.add(start);

        while(!queue.isEmpty()) {
            Point now = queue.poll();

            for(int d=0; d<4; d++) {
                int nextR = now.r + dr[d];
                int nextC = now.c + dc[d];

                if(outOfMapCheck(nextR, nextC))
                    continue;

                if(blackCheck(nextR, nextC))
                    continue;

                if(!singleColorCheck(nextR, nextC, color))
                    continue;

                if(tempVisited[nextR][nextC])
                    continue;
                
                if(emptyCheck(nextR, nextC))
                    continue;

                queue.offer(new Point(nextR, nextC));
                tempList.add(new Point(nextR, nextC));
                cnt++;

                tempVisited[nextR][nextC] = true;

                if(board[nextR][nextC] > 0)
                    visited[nextR][nextC] = true;
            }

            if(tempList.size() > 1)
                updateMap.put(idx, tempList);
        }

        findLeaderBlock(cnt, idx);
        blockMap.put(idx, findLeaderBlock(cnt, idx));
    }

    static void update() {
        while(!updateMap.isEmpty()) {
            int min = Integer.MAX_VALUE;
            int idx = -1;

            for (Map.Entry<Integer, List<Point>> entry : updateMap.entrySet()) {
                if(min > entry.getValue().size()) {
                    min = entry.getValue().size();
                    idx = entry.getKey();
                }
            }

            for (Point point : updateMap.get(idx)) {
                blockInfo[point.r][point.c] = idx;
            }

            updateMap.remove(idx);
        }
    }

    static int rainbowCount(int key) {
        int rainbowCnt = 0;

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(blockInfo[i][j] == key && board[i][j] == 0)
                    rainbowCnt++;
            }
        }

        return rainbowCnt;
    }

    static Block findLeaderBlock(int max, int idx) {
        int leaderR = Integer.MAX_VALUE;
        int leaderC = Integer.MAX_VALUE;

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(blockInfo[i][j] == idx) {
                    if(rainbowCheck(i, j))
                        continue;

                    if(leaderR > i) {
                        leaderR = i;
                        leaderC = j;
                    }
                    else if(leaderR == i) {
                        if(leaderC > j) {
                            leaderR = i;
                            leaderC = j;
                        }
                    }
                }
            }
        }

        return new Block(leaderR, leaderC, max);
    }

    static boolean outOfMapCheck(int r, int c) {
        return r<0 || c<0 || r>=N || c>=N;
    }

    static boolean blackCheck(int r, int c) {
        return board[r][c] == -1;
    }

    static boolean rainbowCheck(int r, int c) {
        return board[r][c] == 0;
    }

    static boolean singleColorCheck(int r, int c, int color) {
        return board[r][c] == color || board[r][c] == 0;
    }
    
    static boolean emptyCheck(int r, int c) {
        return board[r][c] == -2;
    }

    static boolean visitCheck(int r, int c) {
        return blockInfo[r][c] > 0;
    }
}
