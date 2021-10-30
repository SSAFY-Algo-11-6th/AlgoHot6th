package com.week2.gyheo;

import java.util.Arrays;
import java.util.HashMap;

// 해쉬맵 - 완주하지못한선수 (level 1)
public class Pro_42576_gyheo {
    static HashMap<String, Integer> player = new HashMap<>();

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[] p = new String[] { "leo", "kiki", "eden" };
        String[] c = new String[] { "eden", "kiki" };
        String answer = solution(p, c);

        System.out.println(answer);
    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        // 1st. 완주한 선수를 HashMap 으로 구성
        for (int i = 0, size = completion.length; i < size; i++) {
            player.put(completion[i], 0);
        }

        // 동명이인이 있을 수 있으므로 counting
        for (int i = 0, size = completion.length; i < size; i++) {
            player.put(completion[i], player.get(completion[i]) + 1);
        }

        // 2st. HashMap에 참가자 목록이 없으면 완주하지 못한 선수를 answer에 저장
        for (int i = 0, size = participant.length; i < size; i++) {
            if (player.get(participant[i]) == null || player.get(participant[i]) == 0) { // 없는 선수 ||
                answer = participant[i]; // null이거나 선수 count가 없는 경우 바로 리턴
                return answer;
            }

            player.put(participant[i], player.get(participant[i]) - 1); // 선수가 있는 경우 HashMap에서 차감

        }

        return answer; // 결과 출력
    }

}
