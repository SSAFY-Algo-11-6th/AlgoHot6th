package com.week3.gyheo;

public class Pro_43105_gyheo {
    static int[][] data = { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };

    public static void main(String[] args) {
        solution(data);
    }

    // 이항계수 삼각형 관련
    private static int solution(int[][] triangle) {
        int[][] B = new int[triangle.length][triangle.length];

        // D에 해당하는 배열, 초기화.
        B[0][0] = triangle[0][0];

        for (int i = 1; i < triangle.length; i++) {
            B[i][0] = B[i - 1][0] + triangle[i][0]; // 제일 왼쪽
            for (int j = 1; j < i + 1; j++) {
                B[i][j] = Math.max(B[i - 1][j - 1], B[i - 1][j]) + triangle[i][j];
            } // 사잇값, 제일 오른쪽
        }

        int max = 0;
        for (int i = 0; i < B.length - 1; i++) {
            if (max < B[triangle.length - 1][i]) {
                max = B[triangle.length - 1][i];
            }
        } // 제일 바닥에서 큰 값 찾기
          // System.out.println(max);

        return max;
    }
}
