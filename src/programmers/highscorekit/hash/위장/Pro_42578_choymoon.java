package com.ssafy.algo;

import java.util.HashMap;

// 위장
// 테케 1번 빼고 다 맞음. 1번은 뭔가 문제가 있나봄.
// 안입는 경우까지 1 더해서 그냥 경우의수 다 구한다음 다 안입은 경우 하나 뺌.
public class Pro_42578_choymoon {

	public static void main(String[] args) {
		Pro_42578_choymoon pro = new Pro_42578_choymoon();
		System.out.println(pro.solution(new String[][] {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}}));
	}
	
	static int answer;
	
	public int solution(String[][] clothes) {
		HashMap<String, Integer> hashMap = new HashMap<>();
		
		// 의상 종류에 따른 각 종류의 의상 개수 저장
		for (String[] cloth : clothes) {
			Integer temp = hashMap.get(cloth[1]);
			if (temp != null) {
				hashMap.put(cloth[1], temp + 1);
			} else {
				hashMap.put(cloth[1], 1);
			}
		}
		// 의상 종류마다의 의상 개수를 가지는 배열
		int[] nums = new int[hashMap.size()];
		
		// 배열에 각 종류에 따른 의상 개수 저장
		int count = 0;
		for (String key : hashMap.keySet()) {
			nums[count++] = hashMap.get(key);
		}
		
		// 한가지 옷을 입는 경우를 계산 (모든 의류의 개수를 정답에 더함)
		for (int num : nums) {
			answer += num;
		}
		
		// 각 의상을 종류별로 입는데 2종류 입는 날 부터 총 N종류 입는 날 까지의 모든 경우의수를 구함
		for (int i = 2; i <= nums.length; i++) {
			combi(nums.length, i, 0, 0, nums, new int[i]);
		}
		
        return answer;
    }
	
	// 총 N개의 의상 종류 중 R개의 의상 종류를 입는 조합을 찾아서 경우의 수를 정답에 더하는 메소드
	public void combi(int N, int R, int count, int start, int[] nums, int[] selectedNums) {
		if (R == count) { // R개의 종류를 다 골라낸 경우
			int mul = 1;
			for (int num : selectedNums) {
				mul *= num; // 골라진 옷 종류의 의상 개수를 다 곱해준다 (경우의 수)
			}
			answer += mul; // 정답에 경우의 수를 더해준다.
			return;
		}
		
		// 조합 구하기
		for (int i = start; i < N; i++) {
			selectedNums[count] = nums[i];
			combi(N, R, count + 1, i + 1, nums, selectedNums);
		}
	}
}
