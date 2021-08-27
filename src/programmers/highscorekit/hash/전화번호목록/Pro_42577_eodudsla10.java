package com.day16;

import java.util.HashMap;
//Hash로 푸는게 익숙하지 않아서 코드를 참고했다.

public class Pro_42577_eodudsla10 {

	public static void main(String[] args) {
		String[] phone = new String[] {"119", "97674223", "1195524421"};
		System.out.println(solution(phone));
	}

	public static boolean solution(String[] phone) {
		boolean answer = true;
		//HashMap 만들기
		HashMap<String, Integer> map = new HashMap<>();
		
		//모든 전화번호 추가
		for (int i = 0; i < phone.length; i++) {
			map.put(phone[i], i);
		}
		
		//한바퀴 돌며 접두어의 존재 유무를 파악
		for (int i = 0; i < phone.length; i++) {
			for (int j = 1; j < phone[i].length(); j++) {
				//1~부터 전체길이 -1까지의 범위를 비교해서 해당되는 hash key값이 있다면
				// answer를 false처리해서 리턴한다.
				if(map.containsKey(phone[i].substring(0,j))) {
					answer = false;
					return answer;
				}
			}
		}
		return answer;
	}

}

//일반 반복문으로 풀었을 때 => 효율성 테스트에서 오류가 뜬다.
//public static boolean solution(String[] phone) {
//	boolean answer = true;
//	for (int i = 0; i < phone.length - 1; i++) {
//		for (int j = i + 1; j < phone.length; j++) {
//			//2가지 경우를 다 고려해야한다.
//			if (phone[i].startsWith(phone[j]))
//				answer = false;
//			else if (phone[j].startsWith(phone[i]))
//				answer = false;
//		}
//	}
//	return answer;
