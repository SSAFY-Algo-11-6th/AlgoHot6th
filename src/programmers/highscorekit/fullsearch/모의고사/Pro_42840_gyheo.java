package programmers.highscorekit.fullsearch.모의고사;

import java.util.ArrayList;
import java.util.Collections;

public class Pro_42840_gyheo {
    static int[] answers = { 1, 3, 2, 4, 2 };
    static final int SIZE = 10000;

    public static void main(String[] args) {
        solution(answers);
    }

    private static int[] solution(int[] answers) {
        int[][] pattern = { { 1, 2, 3, 4, 5 }, { 2, 1, 2, 3, 2, 4, 2, 5 }, { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 } };

        int cnt1 = 0, cnt2 = 0, cnt3 = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == pattern[0][i % 5]) {
                cnt1++;
            }
            if (answers[i] == pattern[1][i % 8]) {
                cnt2++;
            }
            if (answers[i] == pattern[2][i % 10]) {
                cnt3++;
            }
        } // 각 학생별 맞은 개수 비교

        ArrayList<Integer> list = new ArrayList<>(); // 정답을 위한 ArrayList
        if (cnt1 == cnt2 && cnt2 == cnt3) { // 3명 다 맞춘 개수가 같은 경우
            list.add(1);
            list.add(2);
            list.add(3);
        } else if (cnt1 == cnt2 && cnt1 > cnt3) { // 2명이 최대로 같은 경우
            list.add(1);
            list.add(2);
        } else if (cnt2 == cnt3 && cnt2 > cnt1) {
            list.add(2);
            list.add(3);
        } else if (cnt1 == cnt3 && cnt1 > cnt2) {
            list.add(1);
            list.add(3);
        } else {
            if (cnt1 > cnt2 && cnt1 > cnt3) { // 1명만 최대인 경우
                list.add(1);
            } else if (cnt2 > cnt1 && cnt2 > cnt3) {
                list.add(2);
            } else {
                list.add(3);
            }
        }

        int[] answer = new int[list.size()]; // ArrayList to Array
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        // System.out.println(list);
        return answer;
    }
}
