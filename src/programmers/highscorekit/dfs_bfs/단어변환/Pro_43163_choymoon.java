package com.ssafy.algo;

// 단어 변환
public class Pro_43163_choymoon {

	public static void main(String[] args) {
		Pro_43163_choymoon pro = new Pro_43163_choymoon();
		System.out.println(pro.solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log", "cog"}));
	}

	// 정답 저장을 위한 변수
	static int answer;
	
	public int solution(String begin, String target, String[] words) {
		boolean[] selected = new boolean[words.length];
		answer = Integer.MAX_VALUE; // 최소값을 찾기위해 가장 큰 수 대입.
		dfs(begin, target, words, selected, 0); // 정답 찾기
        return answer == Integer.MAX_VALUE ? 0 : answer; // 가장 큰수가 나온 경우 -> 단어 변환 불가 : 0 출력, 이외 정답 출력
    }
	
	public void dfs(String begin, String target, String[] words, boolean[] selected, int count) {
		if (begin.equals(target)) { // 시작단어와 타겟 단어가 같은 경우 (탐색이 완료된 경우)
			answer = Math.min(answer, count); // 최소 결과값을 저장
			return;
		}
		
		// 단어 탐색
		for (int i = 0; i < words.length; i++) {
			if (selected[i]) // 지금 경로 안에 탐색이 이미 된 단어인 경우
				continue;
			if (getDiffCount(begin, words[i]) == 1) { // 탐색이 진행된 단어가 아니며, 시작 단어와 알파벳 하나가 다른 경우
				selected[i] = true; // 경로상 탐색이 되었음을 표시
				dfs(words[i], target, words, selected, count + 1); // 다음 단어 탐색 시작
				selected[i] = false; // 경로를 빠져나와 다시 탐색이 가능함을 표시
			}
		}
	}
	
	// 단어 내부에 다른 알파벳의 개수를 반환하는 메소드
	public int getDiffCount(String a, String b) {
		int count = 0;
		char[] ac = a.toCharArray();
		char[] bc = b.toCharArray();
		
		for (int i = 0; i < ac.length; i++) {
			if (ac[i] != bc[i]) {
				count += 1;
			}
		}
		
		return count;
	}
}
