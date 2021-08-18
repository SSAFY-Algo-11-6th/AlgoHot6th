package com.day12;

import java.util.Arrays;
import java.util.Comparator;

//처음에는 조합으로 풀어서 나올 수 있는 수를 구하고 최대값을 구하는 식으로 접근 =런타임
//정렬로 풀어야 한다.
class PRO_가장큰수 {
	static String answer = "";
	public static void main(String[] args) {
		int[] numbers = new int[] {3,30,34,5,9};
		solution(numbers);
		System.out.println(answer);
	}
	
	public static String solution(int[] numbers) {
//		String answer = "";

		String str_numbers[] = new String[numbers.length];	//int[] numbers를 받기위한 String 배열 생성

		for (int i = 0; i < str_numbers.length; i++) {
			str_numbers[i] = String.valueOf(numbers[i]);	//int를 String로 변환하여 String 배열안에 넣는다.
		}

		Arrays.sort(str_numbers, new Comparator<String>() {	//내림차순으로 분류작업	(Comparator)

			@Override
			public int compare(String o1, String o2) {	
				return (o2 + o1).compareTo(o1 + o2);	//compareTo 함수: 비교 정렬할 때 사용한다. 숫자가 작을수록(음수일수록)
														//우선순위가 높아진다(왼쪽으로 간다).
			}
		});
		if (str_numbers[0].startsWith("0")) {	//정렬을 한 후 0000이여서 첫번째 큰수가 0일때는 0을 리턴한다.
			answer += "0";
		} else {
			for (int j = 0; j < str_numbers.length; j++) {	//문자열 answer에 정렬된 수를 더한다.
				answer += str_numbers[j];
			}
		}

		return answer;
	}
}