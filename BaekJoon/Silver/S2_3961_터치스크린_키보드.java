package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S2_3961_터치스크린_키보드 {

    static int l;
    static String input;

    static Point[] inputPoint;

    static char[][] keyboard = {
            {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'},
            {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'X'},
            {'z', 'x', 'c', 'v', 'b', 'n', 'm', 'X', 'X', 'X'}
    };

    static Map<String, Integer> wordMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=t; tc++) {
            st = new StringTokenizer(br.readLine(), " ");

            input = st.nextToken();
            l = Integer.parseInt(st.nextToken());

            inputPoint = new Point[input.length()];
            outer : for(int k=0; k<input.length(); k++) {
                for(int i=0; i<keyboard.length; i++) {
                    for(int j=0; j<keyboard[i].length; j++) {
                        if(input.charAt(k) == keyboard[i][j]) {
                            inputPoint[k] = new Point(i, j, 0);
                            continue outer;
                        }
                    }
                }
            }

            wordMap = new HashMap<>();
            for(int i=0; i<l; i++)
                wordMap.put(br.readLine(), 0);

            for (Map.Entry<String, Integer> word : wordMap.entrySet()) {
                String temp = word.getKey();
                int cnt = 0;

                for(int i=0; i<temp.length(); i++) {
                    char tempCh = temp.charAt(i);
                    Point tempPoint = null;

                    if(tempCh != input.charAt(i)) {
                        outer : for(int a=0; a<keyboard.length; a++) {
                            for(int b=0; b<keyboard[a].length; b++) {
                                if(keyboard[a][b] == tempCh) {
                                    tempPoint = new Point(a, b, 0);
                                    break outer;
                                }
                            }
                        }

                        cnt += getDistance(i, tempPoint);
                    }
                }

                wordMap.put(word.getKey(), cnt);
            }

            List<String> keyList = new ArrayList<>(wordMap.keySet());

            keyList.sort(Comparator.comparing((String key) -> wordMap.get(key))
                    .thenComparing(Comparator.naturalOrder()));

            for (String key : keyList)
                System.out.println(key + " " + wordMap.get(key));
        }
    }

    static int getDistance(int idx, Point tempPoint) {
        Point start = inputPoint[idx];

        return Math.abs(start.r - tempPoint.r) + Math.abs(start.c - tempPoint.c);
    }

    static class Point {
        int r;
        int c;
        int cnt;

        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
}