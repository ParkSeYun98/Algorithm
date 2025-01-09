package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_11004_K번째_수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        quickSort(arr, 0, N-1, K-1);

        System.out.println(arr[K-1]);
    }

    public static void quickSort(int[] arr,int start, int end, int K) {
        if(start < end) {
            int pivot = partition(arr, start, end);

            if(pivot == K)
                return;
            else if(K < pivot)
                quickSort(arr, start,pivot-1, K);
            else
                quickSort(arr,pivot+1, end, K);
        }
    }

    public static int partition(int[] arr, int start, int end) {
        if(start+1 == end) {
            if(arr[start] > arr[end])
                swap(arr, start, end);

            return end;
        }
        int mid = (start+end) / 2;

        swap(arr, start, mid);

        int pivot = arr[start];
        int left = start+1;
        int right = end;

        while(left <= right) {
            while(pivot<arr[right] && right>0)
                right--;

            while(pivot>arr[left] && left<arr.length-1)
                left++;

            if(left <= right)
                swap(arr, left++, right--);
        }

        arr[start] = arr[right];
        arr[right] = pivot;

        return right;
    }

    public static void swap(int[] A, int start, int end) {
        int temp = A[end];
        A[end] = A[start];
        A[start] = temp;
    }
}
