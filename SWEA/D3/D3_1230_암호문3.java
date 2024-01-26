/*
* Memory : 31440 KB
* Time : 159 ms
* */

package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class D3_1230_암호문3 {

    static int N;
    static int M;

    static List<Integer> passwordList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int tc=1; tc<=10; tc++) {
            N = Integer.parseInt(br.readLine());

            passwordList = new ArrayList<>();

            st = new StringTokenizer(br.readLine(), " ");
            for(int i=0; i<N; i++)
                passwordList.add(Integer.parseInt(st.nextToken()));

            M = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine(), " ");
            for(int i=0; i<M; i++) {
                String alphabet = st.nextToken();

                if(alphabet.equals("I")) {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());

                    for(int j=x; j<x+y; j++)
                        passwordList.add(j, Integer.parseInt(st.nextToken()));
                }
                else if(alphabet.equals("D")) {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());

                    for(int j=0; j<y; j++)
                        passwordList.remove(x);
                }
                else {
                    int y = Integer.parseInt(st.nextToken());

                    for(int j=0; j<y; j++)
                        passwordList.add(Integer.parseInt(st.nextToken()));
                }
            }

            System.out.print("#" + tc + " ");
            for(int i=0; i<10; i++)
                System.out.print(passwordList.get(i) + " ");
            System.out.println();
        }
    }
}
