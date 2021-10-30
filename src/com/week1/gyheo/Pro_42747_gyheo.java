package com.week1.gyheo;

import java.util.Arrays;

public class Pro_42747_gyheo {
    static int[] citations = { 3, 0, 6, 1, 5 };

    public static void main(String[] args) {
        System.out.println(solution(citations));
    }

    public static int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;

            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }
        return answer;
    }
}
