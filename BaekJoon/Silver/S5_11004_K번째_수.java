package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_11004_K번째_수 {

    static int N, K;

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        quickSort(0, N-1, K-1);
        System.out.println(arr[K-1]);
    }

    static void quickSort(int L, int R, int K) {
        if(L >= R)
            return;

        int pivot = partition(L, R);

        // 최초의 pivot은 0으로 두었다.
        // pivot을 기준으로 왼쪽은 무조건 작은 수가 존재하고, 오른쪽은 큰 수가 존재한다.
        // pivot이 우리가 구해야 하는 K값일 때는 더 이상 알고리즘을 진행하지 않아도 된다는 뜻이다.
        // pivot이 구해야하는 수 K값보다 큰 경우, 즉 K가 왼쪽에 있기에 오른쪽은 더 이상 정렬하지 않아도 된다.
        // pivot이 구해야 하는 수 K값보다 작은 경우, K가 오른쪽에 위치하므로, 왼쪽은 더 이상 정렬하지 않아도 된다.
        if(pivot == K)
            return;
        else if(pivot > K)
            quickSort(L, pivot-1, K);
        else
            quickSort(pivot+1, R, K);
    }

    static int partition(int L, int R) {
        int mid = (L+R) / 2;

        swap(mid, L);

        int pivot = arr[L];
        int i = L;
        int j = R;

        while(i<j) {
            while(pivot < arr[j])
                j--;

            while(i<j && pivot>=arr[i])
                i++;

            swap(i, j);
        }

        arr[L] = arr[i];
        arr[i] = pivot;

        int newPivot = i;

        return i;
    }

    static void swap(int L, int R) {
        int temp = arr[L];
        arr[L] = arr[R];
        arr[R] = temp;
    }
}
