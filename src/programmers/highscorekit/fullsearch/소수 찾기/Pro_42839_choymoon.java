package com.ssafy.algo;

import java.util.HashSet;
import java.util.Set;

// 소수 찾기
public class Pro_42839_choymoon {

	public static void main(String[] args) {
		Pro_42839_choymoon pro = new Pro_42839_choymoon();
		System.out.println(pro.solution("17"));
	}
	
	public int solution(String numbers) {
		int N = numbers.length();
		// 같은 결과가 나올 경우를  대비해 HashSet에 정답들 저장. 011, 11
		Set<Integer> set = new HashSet<>();
		// 1개부터 N개 까지의 순열을 생성해 소수가 맞는지 판단 (N은 숫자의 개수)
		for (int i = 0; i < N; i++) {
			permutation(N, i + 1, 0, numbers.toCharArray(), new int[i + 1], new boolean[N], set);
		}
        return set.size();
    }
	
	public void permutation(int N, int R, int count, char[] nums, int[] selectedNums, boolean[] selected, Set<Integer> set) {
		if (count == R) {
			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < R; i++) {
				sb.append(selectedNums[i]);
			}
			// 선택된 수들로 만들어진 숫자가 소수인지 판별한다.
			int num = Integer.parseInt(sb.toString());
			if (isPrime(num))
				set.add(num); // 소수가 맞다면 결과값을 가지는 HashSet에 숫자를 넣어준다.
			return;
		}
		
		// 문자열에 포함된 숫자로 만들 수 있는 경우의 수를 순열로 뽑는다.
		for (int i = 0; i < N; i++) {
			if (selected[i])
				continue;
			selectedNums[count] = nums[i] - '0';
			selected[i] = true;
			permutation(N, R, count + 1, nums, selectedNums, selected, set);
			selected[i] = false;
		}
	}
	
	// 소수 찾는 방법
	public boolean isPrime(int a) {
		if (a == 1 || a == 0) // 0, 1은 소수가 아니기에
			return false;     // false 리턴
		
		int sqrt = (int) Math.sqrt(a); // 제곱근 구하기
		
		// 2 부터 자신의 제곱근까지의 어떤수로 나누어도 나누어 떨어지면 안됨
		for (int i = 2; i < sqrt + 1; i++) {
			if (a % i == 0) { // 나누어 떨어진다면 소수가 아니다.
				return false;
			}
		}
		return true;
	}
}
