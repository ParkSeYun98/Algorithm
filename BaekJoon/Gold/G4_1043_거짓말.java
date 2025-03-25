package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class G4_1043_거짓말 {

    static int N, M, partyNum;

    static int[] parent;

    static List<Integer> truthList;

    static List<Integer>[] partyList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        truthList = new ArrayList<>();

        st = new StringTokenizer(br.readLine(), " ");
        partyNum = Integer.parseInt(st.nextToken());

        if(partyNum == 0) {
            System.out.println(M);
            return;
        }
        else {
            for(int i=0; i<partyNum; i++)
                truthList.add(Integer.parseInt(st.nextToken()));
        }

        parent = new int[N+1];
        init();

        partyList = new ArrayList[M];
        for(int i=0; i<M; i++)
            partyList[i] = new ArrayList<>();

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int guestNum = Integer.parseInt(st.nextToken());

            int tempA = Integer.parseInt(st.nextToken());
            partyList[i].add(tempA);

            for(int j=0; j<guestNum-1; j++) {
                int tempB = Integer.parseInt(st.nextToken());

                union(tempA, tempB);
                partyList[i].add(tempB);
            }
        }

        int cnt = 0;

        for(int i=0; i<M; i++) {
            boolean flag = true;

            for(int num : partyList[i]) {
                if(truthList.contains(find(parent[num]))) {
                    flag = false;
                    break;
                }
            }

            if(flag)
                cnt++;
        }

        System.out.println(cnt);
    }

    static void init() {
        for(int i=1; i<N+1; i++)
            parent[i] = i;
    }

    static int find(int x) {
        if(parent[x] == x)
            return x;

        return find(parent[x]);
    }

    static void union(int x, int y) {
        int X = find(x);
        int Y = find(y);

        // 항상 진실을 하는 사람을 파티의 루트 노드로 만들기 위함
        // => 추후 거짓말을 할 수 있는 파티인지 구분할 때 루트노드만 확인하면 되기에 편리하다
        if(truthList.contains(Y)) {
            int temp = X;
            X = Y;
            Y = temp;
        }

        parent[Y] = X;
    }
}
