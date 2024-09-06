package Programmers.JAVA.Lv_2;

import java.util.*;

public class Lv_2_파일명_정렬 {

    public class File {
        String name;
        String head;
        int number;

        public File(String name, String head, int number) {
            this.name = name;
            this.head = head;
            this.number = number;
        }
    }

    public String[] solution(String[] files) {
        File[] fileArr = new File[files.length];

        for (int i=0; i<files.length; i++) {
            String[] splitStr = splitFileName(files[i]);

            fileArr[i] = new File(files[i], splitStr[0], Integer.parseInt(splitStr[1]));
        }

        Arrays.sort(fileArr, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                if ((o1.head).equals(o2.head))
                    return o1.number-o2.number;
                else
                    return (o1.head).compareTo(o2.head);
            }
        });

        String[] answer = new String[files.length];

        for (int i = 0; i < files.length; i++)
            answer[i] = fileArr[i].name;

        return answer;
    }

    public String[] splitFileName(String file) {
        String str[] = new String[3];

        for(int i=0; i<str.length; i++)
            str[i] = "";

        int idx = 0;

        for(int i=0; i<file.length(); i++) {
            char ch = file.charAt(i);

            if(idx==0) {
                if(Character.isDigit(ch))
                    idx++;
                else {
                    str[idx] += ch;
                    continue;
                }
            }
            else if(idx==1) {
                if(Character.isDigit(ch)) {
                    str[idx] += ch;
                    continue;
                }
                else
                    idx++;
            }

            str[idx] += ch;
        }

        str[0] = str[0].toLowerCase();

        return str;
    }
}
