package com.ssafy.algo;

// 전화번호 목록
// 효율성 4개중 2개 통과 못함.
public class Pro_42577_choymoon {

	public static void main(String[] args) {
		Pro_42577_choymoon pro = new Pro_42577_choymoon();
		System.out.println(pro.solution(new String[] {"119", "97674223", "1195524421"}));
	}

	public boolean solution(String[] phone_book) {
		// 처음부터 끝까지 그냥 다 깡그리 비교하기.
		// 시간복잡도가 N^2 이지만 중간에 같은경우 바로 빠지기 때문에 풀 수 있음.
        for (int i = 0; i < phone_book.length; i++) {
        	// 모든 단어중에 접두어로 쓰일 단어
        	char[] first = phone_book[i].toCharArray();
        	for (int  j = 0; j < phone_book.length; j++) {
        		// 모든 단어중에 접두어를 포함하는지 검사할 단어
        		char[] second = phone_book[j].toCharArray();
        		// 접두어가 모든 문장의 길이보다 길 수 없음으로, 통과.
        		// 같은 문장이 아니어야 함으로 통과.
        		if (first.length > second.length || i == j) {
        			continue;
        		}
        		// 접두어 판별
        		int count = 0;
        		for (int k = 0; k < first.length; k++) {
        			if (first[k] != second[k]) { // 문자가 같지 않으면
        				break; // 중간에 마무리
        			}
        			count += 1;
        		}
        		if (count == first.length) { // count 와 접두어 문자의 개수가 같다면 접두어 포함
         			return false; // false 리턴
        		}
        	}
        }
        return true; // 접두어 포함이 안되어있는 경우, true 리턴.
    }
}
