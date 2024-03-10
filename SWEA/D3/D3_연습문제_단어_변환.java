package SWEA.D3;

class D3_연습문제_단어_변환 {
    static int answer;
    static boolean[] visited;

    public int solution(String begin, String target, String[] words) {

        answer = 0;

        visited = new boolean[words.length];

        DFS(begin, target, words, 0);

        return answer;
    }

    static void DFS(String now, String target, String[] words, int temp) {
        if(now.equals(target)) {
            answer = temp;
            return;
        }

        for(int i=0; i<words.length; i++) {
            if(visited[i])
                continue;

            int cnt = 0;

            for(int j=0; j<now.length(); j++) {
                if(words[i].charAt(j) == now.charAt(j))
                    cnt++;
            }

            if(cnt == now.length()-1) {
                visited[i] = true;
                DFS(words[i], target, words, temp+1);
                visited[i] = false;
            }
        }
    }
}