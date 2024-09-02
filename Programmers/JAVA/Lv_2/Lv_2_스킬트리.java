package Programmers.JAVA.Lv_2;

public class Lv_2_스킬트리 {

    public int solution(String skill, String[] skill_trees) {
        int cnt = 0;
        boolean[] st = new boolean[skill.length()];

        for(int i=0; i<skill_trees.length; i++) {
            String str = skill_trees[i];
            boolean flag = false;
            String temp = "";

            for(int j=0; j<str.length(); j++) {
                for(int k=0; k<skill.length(); k++) {
                    if(str.charAt(j) == skill.charAt(k))
                        temp += String.valueOf(str.charAt(j));
                }
            }

            for(int j=0; j<temp.length(); j++) {
                if(temp.charAt(j) != skill.charAt(j)) {
                    flag = true;
                    break;
                }
            }

            if(!flag)
                cnt++;
        }

        return cnt;
    }
}
