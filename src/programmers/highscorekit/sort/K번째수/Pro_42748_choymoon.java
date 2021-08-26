package com.ssafy.algo;

import java.util.Arrays;

// K번째 수
public class Pro_42748_choymoon {

	public static void main(String[] args) {
		Pro_42748_choymoon pro = new Pro_42748_choymoon();
		int[] ans = pro.solution(new int[] {1, 5, 2, 6, 3, 7, 4}, new int[][] {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
		System.out.println(Arrays.toString(ans));
	}
	
	public int[] solution(int[] array, int[][] commands) {
		int N = commands.length;
        int[] answer = new int[N]; // 각 명령마다 정답이 생기기에 명령 개수만큼 배열 생성
        
        // 모든 명령에 대한 탐색
        for (int i = 0; i < N; i++) {
        	int from = commands[i][0]; // 시작 인덱스
        	int to = commands[i][1];   // 끝 인덱스
        	int k = commands[i][2];    // 잘라낸 부분에서 원하는 인덱스
        	
        	int[] temp = new int[to - from + 1]; // 잘라낸 부분을 담을 배열 생성
        	int index = 0; // 잘라낸 배열에 담을 때 필요한 인덱스
        	for (int j = from - 1; j < to; j++) { // 시작 인덱스부터 끝 인덱스까지의 값 탐색
        		temp[index++] = array[j]; // 잘라서 담기
        	}
        	// Arrays.copyOfRange(array, from - 1, to); 이거 쓰면 더 간단.
        	Arrays.sort(temp); // 정렬
        	answer[i] = temp[k - 1]; // k 인덱스에 있는 원소 정답에 추가
        }
        
        return answer;
    }
}
