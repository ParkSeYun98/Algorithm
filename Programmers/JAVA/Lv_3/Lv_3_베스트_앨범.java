package Programmers.JAVA.Lv_3;

import java.util.*;

public class Lv_3_베스트_앨범 {

    class Solution {

        class Genre implements Comparable<Genre> {

            String name;
            int playCnt;

            public Genre(String name, int playCnt) {
                this.name = name;
                this.playCnt = playCnt;
            }

            @Override
            public int compareTo(Genre g) {
                return this.playCnt - g.playCnt;
            }
        }

        class Song implements Comparable<Song> {

            int id;
            int plays;

            public Song(int id, int plays) {
                this.id = id;
                this.plays = plays;
            }

            @Override
            public int compareTo(Song s) {
                return this.plays - s.plays;
            }
        }

        public int[] solution(String[] genres, int[] plays) {

            HashMap<String, List<Song>> hashMap = new HashMap<>();

            for(int i=0; i<genres.length; i++) {
                if(hashMap.get(genres[i]) == null)
                    hashMap.put(genres[i], new ArrayList<>());

                hashMap.get(genres[i]).add(new Song(i, plays[i]));
            }

            List<Genre> totalPlayCntList = new ArrayList<>();

            for(String name : hashMap.keySet()) {

                int sum = 0;

                for(int i=0; i<hashMap.get(name).size(); i++)
                    sum += hashMap.get(name).get(i).plays;

                totalPlayCntList.add(new Genre(name, sum));
            }

            Collections.sort(totalPlayCntList, Collections.reverseOrder());

            List<Integer> album = new ArrayList<>();

            for(int i=0; i<totalPlayCntList.size(); i++) {
                String name = totalPlayCntList.get(i).name;
                int songCnt = hashMap.get(name).size();

                Collections.sort(hashMap.get(name), Collections.reverseOrder());

                for(int j=0; j<songCnt; j++) {
                    if(j >= 2)
                        break;
                    else
                        album.add(hashMap.get(name).get(j).id);
                }
            }

            int[] answer = new int[album.size()];

            for(int i=0; i<album.size(); i++)
                answer[i] = album.get(i);

            return answer;
        }
    }
}
