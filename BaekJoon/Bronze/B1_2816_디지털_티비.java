/*
* Memory : 11500 KB
* Time : 80ms
* */

package BaekJoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1_2816_디지털_티비 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] listArr = new String[N];

        for(int i=0; i<N; i++)
            listArr[i] = br.readLine();

        for(int i=0; i<N; i++) {
            if(listArr[i].equals("KBS1")) {
                for(int j=i; j>0; j--) {
                    System.out.print(4);

                    String temp = listArr[j];
                    listArr[j] = listArr[j-1];
                    listArr[j-1] = temp;
                }

                break;
            }
            else
                System.out.print(1);
        }

        for(int i=0; i<N; i++) {
            if(listArr[i].equals("KBS2")) {
                for(int j=i; j>1; j--) {
                    System.out.print(4);

                    String temp = listArr[j];
                    listArr[j] = listArr[j-1];
                    listArr[j-1] = temp;
                }

                break;
            }
            else
                System.out.print(1);
        }
    }
}
