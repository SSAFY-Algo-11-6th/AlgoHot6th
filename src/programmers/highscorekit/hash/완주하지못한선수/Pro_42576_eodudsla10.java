package com.day16;

import java.util.Arrays;

public class Pro_42576_eodudsla10 {

	public static void main(String[] args) {
		String[] participant = new String[] { "leo", "kiki", "eden" };
		String[] completion = new String[] { "eden", "kiki" };
		String answer = solution(participant, completion);
		System.out.println(answer);
	}

	public static String solution(String[] participant, String[] completion) {
		String answer = "";
		//sort문으로 정렬 한 다음 앞에서부터 탐색을 해서 다른 값이 나왔을 때 다른 값을 출력하고 빠져 나온다.
		Arrays.sort(participant);
		Arrays.sort(completion);

		for (int j = 0; j < completion.length; j++) {
			if (!participant[j].equals(completion[j])) {
				answer = participant[j];
				return answer;
			}
		}
		//만약 탐색이 완료 됐는데 다른 값이 없으면 paricipant의 마지막 값을 출력한다.
		answer += participant[participant.length - 1];
		return answer;
	}

}
