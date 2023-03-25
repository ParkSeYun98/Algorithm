package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D2_14229_백만_개의_정수_정렬_QuickSort {
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[1000000];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<1000000; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        QuickSort(0, arr.length-1);

        System.out.println(arr[500000]);
    }

    public static void QuickSort(int left, int right) {
        // 초기에 left가 right보다 크거나 같다 : 정렬할 원소가 1개 이하이므로, 정렬할 필요가 없다.
        if(left >= right)
            return;

        // pivot 설정
        int pivot = Hoare_Partition(left, right);
        // pivot 기준 좌측 배열
        QuickSort(left, pivot-1);
        // pivot 기준 우측 배열
        QuickSort(pivot+1, right);
    }

    public static int Hoare_Partition(int left, int right) {
        // pivot은 주어진 part 배열의 가장 좌측
        int pivot = arr[left];

        // leftPoint는 pivot을 제외한 가장 좌측 부터 시작하여 본인보다 큰 수를 찾는다.
        int leftPoint = left + 1;
        // rightPoint는 가장 우측부터 시작하여 본인보다 작은 수를 찾는다.
        int rightPoint = right;

        // leftPoint와 rightPoint가 교차하면 종료
        while(leftPoint <= rightPoint) {
            // leftPointer가 위치하는 곳의 값이 pivot보다 크면 stop (leftPivot이 무한으로 나갈 수 있으므로 leftPoint가 arr 밖으로 벗어나지 않게 막아주기)
            while(leftPoint <= rightPoint && arr[leftPoint] <= pivot)
                leftPoint++;

            // rightPointer가 위치하는 곳의 값이 pivot보다 작으면 stop
            while(arr[rightPoint] > pivot)
                rightPoint--;
            
            // 두 포인터가 교차하지 않은 상태에서 두 Pointer가 stop 했다면 두 pointer 위치의 값 swap
            if(leftPoint < rightPoint)
                Swap(leftPoint, rightPoint);
        }
        
        // 두 Pointer가 교차했을 때, pivot과 Pointer 둘 중 rightPointer와 교체
        Swap(left, rightPoint);

        // 현재 rightPoint가 위치한 곳이 pivot의 위치이므로 return
        return rightPoint;
    }

    public static void Swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
