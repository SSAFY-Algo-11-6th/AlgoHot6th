package com.week1.gyheo;

import java.util.Arrays;
import java.util.Comparator;

public class PRO42746 {
    static int[] numbers = { 3, 30, 34, 5, 9 };

    public static void main(String[] args) {
        System.out.println(solution(numbers));
    }

    static String solution(int[] numbers) {
        String answer = "";
        String[] str = new String[numbers.length]; // 문자열 리턴을 위한 문자열 배열
        StringBuilder sb = new StringBuilder(); // 문자열 + 연산 속도를 위해 StringBuilder 사용

        for (int i = 0; i < numbers.length; i++) {
            str[i] = String.valueOf(numbers[i]); // 문자열 배열에 각각 할당
        }

        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s2 + s1).compareTo(s1 + s2);
            } // 내림차순 정렬
        });

        String num = String.join("", str);
        if (num.startsWith("0")) {
            return "0";
        }

        for (String s : str) {
            sb.append(s);
        }

        answer = sb.toString();

        return answer;
    }
}
