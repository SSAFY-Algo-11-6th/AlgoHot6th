package com.week2.gyheo;

import java.util.Arrays;

public class Pro_42748_gyheo {
    static int[] array = { 1, 5, 2, 6, 3, 7, 4 };
    static int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(array, commands)));
    }

    private static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length]; // 정답 배열 생성

        for (int i = 0; i < commands.length; i++) {
            int[] arr = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]); // 배열 복사
            Arrays.sort(arr); // 정렬

            if (arr.length == 1) { // 길이가 1인 경우 첫번째 원소 출력
                answer[i] = arr[0];
            } else { // commands[i][2] 위치 출력 (배열은 0부터 시작하므로 -1)
                answer[i] = arr[commands[i][2] - 1];
            } // command.length만큼 반복
        }

        return answer;
    }
}
