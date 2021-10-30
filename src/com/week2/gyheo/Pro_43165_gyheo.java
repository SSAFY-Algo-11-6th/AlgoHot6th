package com.week2.gyheo;

public class Pro_43165_gyheo {
    static int[] numbers = { 1, 1, 1, 1, 1 };
    static boolean[] isSelected = new boolean[numbers.length];
    static int target = 3;
    static int result = 0;

    public static void main(String[] args) {
        System.out.println(solution(numbers, target));
    }

    private static int solution(int[] numbers, int target) {
        subset(0, numbers, target); // 부분집합 사용

        return result;
    }

    static void subset(int cnt, int[] numbers, int target) { // 부분집합 사용
        if (cnt == numbers.length) {
            int sum = 0;
            for (int i = 0; i < isSelected.length; i++) {
                int num = isSelected[i] ? numbers[i] : -numbers[i]; // 부호 사용 여부 결정
                sum += num;
            }

            // System.out.println((sum));
            if (sum == target) { // 합이 target과 같은 경우 result값 증가
                result++;
            }
            return;
        }

        isSelected[cnt] = true;
        subset(cnt + 1, numbers, target);
        isSelected[cnt] = false;
        subset(cnt + 1, numbers, target);
    }

}
