package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class G5_23796_2147483648_게임 {

    static String input;

    static long[][] board, newBoard;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        board = new long[8][8];
        newBoard = new long[8][8];

        for(int i=0; i<8; i++) {
            st = new StringTokenizer(br.readLine()," ");

            for(int j=0; j<8; j++)
                board[i][j] = Long.parseLong(st.nextToken());
        }

        input = br.readLine();

        game();

        print();
    }

    static void game() {
        Queue<Long> queue = new LinkedList<>();
        Stack<Long> stack = new Stack<>();

        switch(input) {
            case "U" :
                for(int i=0; i<8; i++) {
                    for(int j=0; j<8; j++) {
                        if(board[j][i] == 0)
                            continue;

                        queue.offer(board[j][i]);
                    }

                    int idx = 0;

                    while(!queue.isEmpty()) {
                        long now = queue.poll();

                        if(queue.isEmpty())
                            newBoard[idx][i] = now;
                        else {
                            if(now == queue.peek())
                                newBoard[idx][i] = 2 * queue.poll();
                            else
                                newBoard[idx][i] = now;
                        }

                        idx++;
                    }
                }

                break;
            case "D" :
                for(int i=0; i<8; i++) {
                    for(int j=0; j<8; j++) {
                        if(board[j][i] == 0)
                            continue;

                        stack.push(board[j][i]);
                    }

                    int idx = 7;

                    while(!stack.isEmpty()) {
                        long now = stack.pop();

                        if(stack.isEmpty())
                            newBoard[idx][i] = now;
                        else {
                            if(now == stack.peek())
                                newBoard[idx][i] = 2 * stack.pop();
                            else
                                newBoard[idx][i] = now;
                        }

                        idx--;
                    }
                }

                break;
            case "L" :
                for(int i=0; i<8; i++) {
                    for(int j=0; j<8; j++) {
                        if(board[i][j] == 0)
                            continue;

                        queue.offer(board[i][j]);
                    }

                    int idx = 0;

                    while(!queue.isEmpty()) {
                        long now = queue.poll();

                        if(queue.isEmpty())
                            newBoard[i][idx] = now;
                        else {
                            if(now == queue.peek())
                                newBoard[i][idx] = 2 * queue.poll();
                            else
                                newBoard[i][idx] = now;
                        }

                        idx++;
                    }
                }

                break;
            case "R" :
                for(int i=0; i<8; i++) {
                    for(int j=0; j<8; j++) {
                        if(board[i][j] == 0)
                            continue;

                        stack.push(board[i][j]);
                    }

                    int idx = 7;

                    while(!stack.isEmpty()) {
                        long now = stack.pop();

                        if(stack.isEmpty())
                            newBoard[i][idx] = now;
                        else {
                            if(now == stack.peek())
                                newBoard[i][idx] = 2 * stack.pop();
                            else
                                newBoard[i][idx] = now;
                        }

                        idx--;
                    }
                }
                break;
        }
    }

    static void print() {
        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++)
                System.out.print(newBoard[i][j] + " ");

            System.out.println();
        }
    }
}
