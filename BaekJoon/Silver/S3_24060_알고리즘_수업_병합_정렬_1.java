package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_24060_알고리즘_수업_병합_정렬_1 {

    static int N, K, result, cnt;

    static int[] A, tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        result = -1;
        cnt = 0;

        A = new int[N];
        tmp = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        mergeSort(A, 0, N-1);

        System.out.println(result);
    }

    static void mergeSort(int A[], int p, int r) {
        if(cnt > K)
            return;

        if(p < r) {
            int q = (p + r) / 2;

            mergeSort(A, p, q);
            mergeSort(A, q+1, r);
            merge(A, p, q, r);
        }
    }

    static void merge(int[] A, int p, int q, int r) {
        int i = p;
        int j = q+1;
        int t = 0;

        while(i<=q && j<=r) {
            if(A[i] < A[j])
                tmp[t++] = A[i++];
            else
                tmp[t++] = A[j++];
        }

        while(i<=q)
            tmp[t++] = A[i++];

        while(j<=r)
            tmp[t++] = A[j++];

        i=p;
        t=0;

        while(i<=r) {
            cnt++;

            if(cnt == K) {
                result = tmp[t];
                break;
            }

            A[i++] = tmp[t++];
        }
    }
}
