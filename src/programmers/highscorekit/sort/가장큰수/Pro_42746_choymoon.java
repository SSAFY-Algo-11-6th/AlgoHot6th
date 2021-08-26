package com.ssafy.algo;

import java.util.Arrays;

// 가장 큰 수
// 해설 참고
public class Pro_42746_choymoon {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {6, 10, 2}));
	}

	static public String solution(int[] numbers) {
		String[] temp = new String[numbers.length];
		
		for (int i = 0; i < numbers.length; i++) {
			temp[i] = String.valueOf(numbers[i]);
		}
		
		Arrays.sort(temp, (s1, s2) -> ( (s2 + s1).compareTo(s1 + s2) ));
		
		if(temp[0].equals("0"))
			return "0";
		
		StringBuilder result = new StringBuilder();
		
		for (String s : temp) {
			result.append(s);
		}
		
		return result.toString();
    }
}
