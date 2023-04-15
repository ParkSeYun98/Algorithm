package BaekJoon.Platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P5_5373_큐빙 {

    static char[][] top;
    static char[][] bottom;
    static char[][] front;
    static char[][] back;
    static char[][] left;
    static char[][] right;

    static StringBuilder sb;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc=1;tc<=T;tc++) {
            int n = Integer.parseInt(br.readLine());
            String[] order = br.readLine().split(" ");

            top = new char[][]{{'w', 'w', 'w'}, {'w', 'w', 'w'}, {'w', 'w', 'w'}};
            bottom = new char[][]{{'y', 'y', 'y'}, {'y', 'y', 'y'}, {'y', 'y', 'y'}};
            front = new char[][]{{'r', 'r', 'r'}, {'r', 'r', 'r'}, {'r', 'r', 'r'}};
            back = new char[][]{{'o', 'o', 'o'}, {'o', 'o', 'o'}, {'o', 'o', 'o'}};
            left = new char[][]{{'g', 'g', 'g'}, {'g', 'g', 'g'}, {'g', 'g', 'g'}};
            right = new char[][]{{'b', 'b', 'b'}, {'b', 'b', 'b'}, {'b', 'b', 'b'}};

            for(int i=0; i<n; i++) {
                String str = order[i];

                char move = str.charAt(0);
                char dir = str.charAt(1);

                if(move == 'U')
                    rotateTop(dir);
                else if(move == 'D')
                    rotateBottom(dir);
                else if(move == 'F')
                    rotateFront(dir);
                else if(move == 'B')
                    rotateBack(dir);
                else if(move == 'L')
                    rotateLeft(dir);
                else if(move == 'R')
                    rotateRight(dir);
            }

            print();
        }

        System.out.println(sb.toString());
    }

    static void rotateTop(char dir) {

        if(dir == '+') {
            top = Clockwise(top);

            char[] temp = back[0].clone();

            back[0] = left[0].clone();
            left[0] = front[0].clone();
            front[0] = right[0].clone();
            right[0] = temp;

            // 뒷 - 오 - 앞 - 왼 - 뒷

        } else {

            top = counterClockwise(top);

            // 뒷 - 왼 - 앞 - 오 - 뒷
            char[] temp = back[0].clone();

            back[0] = right[0].clone();
            right[0] = front[0].clone();
            front[0] = left[0].clone();
            left[0] = temp;
        }
    }

    static void rotateBottom(char dir) {
        if(dir == '+') {
            bottom = Clockwise(bottom);

            // 뒷 - 왼 - 앞 - 오 - 뒷
            char[] temp = back[2].clone();

            back[2] = right[2].clone();
            right[2] = front[2].clone();
            front[2] = left[2].clone();
            left[2] = temp;
        } else {
            bottom = counterClockwise(bottom);

            // 뒷 - 오 - 앞 - 왼 - 뒷
            char[] temp = back[2].clone();

            back[2] = left[2].clone();
            left[2] = front[2].clone();
            front[2] = right[2].clone();
            right[2] = temp;
        }
    }

    static void rotateFront(char dir) {
        if(dir == '+') {
            front = Clockwise(front);

            // 윗 - 오 - 바 - 왼 - 윗
            char[] temp = new char[3];

            for(int i=0; i<3; i++)
                temp[i] = top[2][i];

            for(int i=0; i<3; i++)
                top[2][i] = left[2-i][2];

            for(int i=0; i<3; i++)
                left[i][2] = bottom[2][2-i];

            for(int i=0; i<3; i++)
                bottom[2][i] = right[i][0];

            for(int i=0; i<3; i++)
                right[i][0] = temp[i];

        } else {
            front = counterClockwise(front);

            // 윗 - 왼 - 바 - 오 - 윗
            char[] temp = new char[3];

            for(int i=0; i<3; i++)
                temp[i] = top[2][2-i];

            for(int i=0; i<3; i++)
                top[2][i] = right[i][0];

            for(int i=0; i<3; i++)
                right[i][0] = bottom[2][i];

            for(int i=0; i<3; i++)
                bottom[2][i] = left[2-i][2];

            for(int i=0; i<3; i++)
                left[i][2] = temp[i];
        }
    }

    static void rotateBack(char dir) {
        if(dir == '+') {
            back = Clockwise(back);
            // 윗 - 왼 - 바 - 오 - 윗
            char[] temp = new char[3];
            for(int i=0; i<3; i++)
                temp[i] = top[0][2-i];

            for(int i=0; i<3; i++)
                top[0][i] = right[i][2];

            for(int i=0; i<3; i++)
                right[i][2] = bottom[0][i];

            for(int i=0; i<3; i++)
                bottom[0][i] = left[2-i][0];

            for(int i=0; i<3; i++)
                left[i][0] = temp[i];

        } else {
            back = counterClockwise(back);

            // 윗 - 오 - 바 - 왼 - 윗
            char[] temp = new char[3];

            for(int i=0; i<3; i++)
                temp[i] = top[0][i];

            for(int i=0; i<3; i++)
                top[0][i] = left[2-i][0];

            for(int i=0; i<3; i++)
                left[i][0] = bottom[0][2-i];

            for(int i=0; i<3; i++)
                bottom[0][i] = right[i][2];

            for(int i=0; i<3; i++)
                right[i][2] = temp[i];
        }
    }

    static void rotateLeft(char dir) {
        if(dir == '+') {
            left = Clockwise(left);

            // 윗 - 앞 - 바 - 뒷 - 윗
            char[] temp = new char[3];

            for(int i=0; i<3; i++)
                temp[i] = top[i][0];

            for(int i=0; i<3; i++)
                top[i][0] = back[2-i][2];

            for(int i=0; i<3; i++)
                back[i][2] = bottom[i][2];

            for(int i=0; i<3; i++)
                bottom[i][2] = front[2-i][0];

            for(int i=0; i<3; i++)
                front[i][0] = temp[i];

        } else {
            left = counterClockwise(left);

            // 윗 - 뒷 - 바 - 앞  - 윗
            char[] temp = new char[3];

            for(int i=0; i<3; i++)
                temp[i] = top[2-i][0];

            for(int i=0; i<3; i++)
                top[i][0] = front[i][0];

            for(int i=0; i<3; i++)
                front[i][0] = bottom[2-i][2];

            for(int i=0; i<3; i++)
                bottom[i][2] = back[i][2];

            for(int i=0; i<3; i++)
                back[i][2] = temp[i];
        }
    }

    static void rotateRight(char dir) {
        if(dir == '+') {
            right = Clockwise(right);

            // 윗 - 뒷 - 바 - 앞  - 윗
            char[] temp = new char[3];

            for(int i=0; i<3; i++)
                temp[i] = top[2-i][2];

            for(int i=0; i<3; i++)
                top[i][2] = front[i][2];

            for(int i=0; i<3; i++)
                front[i][2] = bottom[2-i][0];

            for(int i=0; i<3; i++)
                bottom[i][0] = back[i][0];

            for(int i=0; i<3; i++)
                back[i][0] = temp[i];

        } else {
            right = counterClockwise(right);

            // 윗 - 앞 - 바 - 뒷 - 윗
            char[] temp = new char[3];

            for(int i=0; i<3; i++)
                temp[i] = top[i][2];

            for(int i=0; i<3; i++)
                top[i][2] = back[2-i][0];

            for(int i=0; i<3; i++)
                back[i][0] = bottom[i][0];

            for(int i=0; i<3; i++)
                bottom[i][0] = front[2-i][2];

            for(int i=0; i<3; i++)
                front[i][2] = temp[i];

        }
    }

    // 시계방향으로 90도 회전
    static char[][] Clockwise(char[][] arr) {
        char[][] rotate = new char[3][3];

        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++)
                rotate[i][j] = arr[3-1-j][i];
        }

        return rotate;
    }

    // 반시계 방향으로 90도 회전
    static char[][] counterClockwise(char[][] arr) {
        char[][] rotate = new char[3][3];

        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++)
                rotate[i][j] = arr[j][3-1-i];
        }

        return rotate;
    }

    static void print() {
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++)
                sb.append(top[i][j]);
            sb.append("\n");
        }
    }
}