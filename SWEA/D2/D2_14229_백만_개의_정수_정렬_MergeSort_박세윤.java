package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D2_14229_백만_개의_정수_정렬_MergeSort_박세윤 {
    private static int[] arr;
    private static int[] sortedArr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[1000000];
        sortedArr = new int[1000000];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<1000000; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        MergeSort(arr, 0, arr.length-1);

        System.out.println(arr[500000]);
    }

    public static void MergeSort(int[] arr, int left, int right) {
        if(left < right) {
            int mid = (left + right) / 2;

            // 중앙 기준으로 좌 우로 계속 나누고
            MergeSort(arr, left, mid);
            MergeSort(arr, mid+1, right);
            // 분할한 것들을 각각 정렬한 후 합침.
            Merge(arr, left, mid, right);
        }
    }

    public static void Merge(int[] arr, int left, int mid, int right) {
        // 새 배열의 포인터
        int idx = left;

        // 중앙 기준 좌측 배열의 첫 번째
        int leftPointer = left;
        // 중앙 기준 우측 배열의 첫 번째
        int rightPointer = mid + 1;

        while(leftPointer <= mid && rightPointer <= right) {
            // 두 포인터가 가리키는 곳 중 작은 원소를 가진 쪽을 새 배열에 저장 한 후 인덱스 증가
            if(arr[leftPointer] <= arr[rightPointer])
                sortedArr[idx++] = arr[leftPointer++];
            else
                sortedArr[idx++] = arr[rightPointer++];
        }

        // 한쪽이 모두 끝나면 남는 쪽을 그대로 새 배열에 옮겨준다.
        if(leftPointer <= mid) {
            for(int i=leftPointer; i<=mid; i++)
                sortedArr[idx++] = arr[i];
        }
        else {
            for(int i=rightPointer; i<=right; i++)
                sortedArr[idx++] = arr[i];
        }

        // 새 배열의 것을 기존 배열에 덮어쓰기
        for(int i=left; i<=right; i++)
            arr[i] = sortedArr[i];
    }
}
