package SWEA.모의_SW_역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 모의_역량_테스트_보물상자_비밀번호 {
    private static int N;
    private static int K;
    private static int result = 0;

    private static char[] password;
    private static char[] copy;
    private static int[] arr;

    private static List<String> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            String input = br.readLine();
            password = new char[input.length()];
            copy = new char[input.length()];

            for(int i=0; i<input.length(); i++)
                password[i] = input.charAt(i);

            copy = password.clone();
            list = new ArrayList<>();

            result = 0;

            boolean flag = false;
            for(int i=0; i<password.length-1; i++) {
                if(password[i] != password[i+1]) {
                    flag = true;
                    break;
                }
            }

            if(!flag) {
                int special = 0;
                for(int i=0; i<N/4; i++) {
                    if(password[0] == 'F'|| password[0] == 'E'|| password[0] == 'D'|| password[0] == 'C'|| password[0] == 'B'|| password[0] == 'A')
                        special += (password[0] - 55)*Math.pow(16, N/4 - 1 - i);
                    else
                        special += (password[0] - 48)*Math.pow(16, N/4 - 1 - i);
                }
            }
            else {
                getNums();

                getResult();

                System.out.println("#" + tc + " " + result);
            }
        }
    }

    public static void getNums() {
        while(true) {
            divide();

            rotate();

            if(check())
                break;
        }
    }

    public static void rotate() {
        char temp = password[password.length-1];

        for(int i=password.length-1; i>0; i--) {
            password[i] = password[i-1];
        }

        password[0] = temp;
    }

    public static void divide() {
        String temp = "";

        for(int i=0; i<password.length; i+=N/4) {
            for(int j=i; j<i+N/4; j++)
                temp += String.valueOf(password[j]);

            if(!list.contains(temp))
                list.add(temp);

            temp = "";
        }
    }

    public static boolean check() {
        String temp1[] = new String[4];
        Arrays.fill(temp1, "");
        int cnt1 = 0;
        for(int i=0; i<password.length; i+=N/4) {
            for(int j=i; j<i+N/4; j++) {
                temp1[cnt1] += String.valueOf(password[j]);
            }

            cnt1++;
        }

        String temp2[] = new String[4];
        Arrays.fill(temp2, "");
        int cnt2 = 0;
        for(int i=0; i<copy.length; i+=N/4) {
            for(int j=i; j<i+N/4; j++) {
                temp2[cnt2] += copy[j];
            }

            cnt2++;
        }

        boolean flag[] = new boolean[temp1.length];

        for(int i=0; i<temp1.length; i++) {
            for(int j=0; j<temp2.length; j++) {
                if(temp1[i].equals(temp2[j])) {
                    flag[i] = true;
                    continue;
                }
            }
        }

        for(int i=0; i<flag.length; i++) {
            if(!flag[i])
                return false;
        }

        return true;
    }

    public static void getResult() {
        arr = new int[list.size()];

        for(int j=0; j<arr.length; j++) {
            for(int i=0; i<N/4; i++) {
                if(list.get(j).charAt(i) == 'F'|| list.get(j).charAt(i) == 'E'|| list.get(j).charAt(i) == 'D'|| list.get(j).charAt(i) == 'C'|| list.get(j).charAt(i) == 'B'|| list.get(j).charAt(i) == 'A')
                    arr[j] += (list.get(j).charAt(i) - 55)*Math.pow(16, N/4 - 1 - i);
                else
                    arr[j] += (list.get(j).charAt(i) - 48)*Math.pow(16, N/4 - 1 - i);
            }
        }

        for(int i=0; i<arr.length-1; i++) {
            for(int j=1; j<arr.length-i; j++) {
                if(arr[j] > arr[j-1])
                    swap(j);
            }
        }

        result = arr[K-1];
    }

    public static void swap(int j) {
        int temp = arr[j-1];
        arr[j-1] = arr[j];
        arr[j] = temp;
    }
}