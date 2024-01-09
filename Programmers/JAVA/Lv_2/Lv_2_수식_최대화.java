package Programmers.JAVA.Lv_2;

import java.util.*;

class Lv_2_수식_최대화 {
    private long max = 0;

    private char[] operator = {'+', '-', '*'};
    private char[] order = new char[3];
    private boolean[] visited = new boolean[3];

    private List<Character> operatorList = new ArrayList<>();
    private List<Long> numberList = new ArrayList<>();

    public long solution(String expression) {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<expression.length(); i++) {
            char temp = expression.charAt(i);

            boolean flag = false;

            for(int j=0; j<operator.length; j++) {
                if(operator[j] == temp) {
                    flag = true;
                    break;
                }
            }

            if(flag) {
                numberList.add(Long.parseLong(sb.toString()));
                sb = new StringBuilder();
                operatorList.add(temp);
            }
            else {
                sb.append(temp);
            }
        }

        numberList.add(Long.parseLong(sb.toString()));

        DFS(0);

        return max;
    }

    public void DFS(int depth) {
        if(depth == 3) {
            max = Math.max(max, Math.abs(calculate()));
            return;
        }

        for(int i=0; i<operator.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                order[depth] = operator[i];
                DFS(depth+1);
                visited[i] = false;
            }
        }
    }

    public long calculate() {
        List<Character> copyOperatorList = new ArrayList<>(operatorList);
        List<Long> copyNumberList = new ArrayList<>(numberList);

        int i=0;

        outer: while(copyOperatorList.size() > 0) {
            if(i >= 3)
                break;

            char now = order[i];

            for(int j=0; j<copyOperatorList.size(); j++) {
                if(copyOperatorList.get(j) == now) {
                    long partSum = calc(now, copyNumberList.get(j), copyNumberList.get(j+1));

                    copyOperatorList.remove(j);
                    copyNumberList.remove(j+1);
                    copyNumberList.set(j, partSum);

                    continue outer;
                }
            }

            i++;
        }

        return copyNumberList.get(0);
    }

    public long calc(char expression, long num1, long num2) {
        if(expression == '+')
            return num1 + num2;
        else if(expression == '-')
            return num1 - num2;
        else
            return num1 * num2;
    }
}