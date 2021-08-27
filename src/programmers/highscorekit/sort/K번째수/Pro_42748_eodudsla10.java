package com.day16;

import java.util.Arrays;

public class Pro_42748_eodudsla10 {
	public static void main(String[] args) {
		int[] array = new int[] { 1, 5, 2, 6, 3, 7, 4 };
		int[][] commands = new int[][] { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };
		int[] num = solution(array, commands);
		System.out.println(Arrays.toString(num));
	}

	private static int[] solution(int[] array, int[][] commands) {
		int[] answer= new int[commands.length];
		for (int i = 0; i < commands.length; i++) {
			//commands[i][0]-1 :인덱스가 0부터 시작하기 때문에 -1을 한다.
			int[]arr1 = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
			Arrays.sort(arr1);
			answer[i] = arr1[commands[i][2]-1];
		}
		return answer;
	}

}
