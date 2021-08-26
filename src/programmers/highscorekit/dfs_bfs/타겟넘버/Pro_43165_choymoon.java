package com.ssafy.algo;

// Target Number
public class Pro_43165_choymoon {

	public static void main(String[] args) {
		Pro_43165_choymoon pro = new Pro_43165_choymoon();
		System.out.println(pro.solution(new int[] {1, 1, 1, 1, 1}, 3));
	}
	
	static int ans;
	
	public int solution(int[] numbers, int target) {
        find(numbers.length, 0, 0, numbers, target);
        return ans;
    }
	
	// 모든 경우의 수를 탐색하는 메소드
	public void find(int N, int count, int result, int[] numbers, int target) {
		// count == N 인 경우 모든 원소에 대한 탐색을 마친 상황
		if (count == N) {
			if (result == target) // 목표로 하는 숫자와 결과가 같다면
				ans += 1; // 정답 개수 하나 추가
			return;
		}
		// 지금 들어온 수를 더하는 경우, 빼는 경우 둘 다 탐색
		find(N, count + 1, result + numbers[count], numbers, target);
		find(N, count + 1, result - numbers[count], numbers, target);
	}
}
