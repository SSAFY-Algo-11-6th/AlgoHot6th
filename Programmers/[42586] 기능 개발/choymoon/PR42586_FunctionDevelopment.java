package com.ssafy.study;

import java.util.ArrayList;
import java.util.Arrays;

public class PR42586_FunctionDevelopment {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1})));
	}

	static public int[] solution(int[] progresses, int[] speeds) {
		int size = progresses.length;
		boolean allDone = false;
		boolean[] done = new boolean[size];
		boolean[] checkedBefore = new boolean[size];
		ArrayList<Integer> tmp = new ArrayList<>();
		
		int count = 0;
		while (!allDone) {
			count = 0;
			for (int i = 0; i < size; i++) {
				progresses[i] += speeds[i];
			}
			
			if (progresses[0] >= 100)
				done[0] = true;
			
			for (int i = 1; i < size; i++) {
				if (progresses[i] >= 100 && progresses[i - 1] >= 100 && done[i - 1]) {
					done[i] = true;
				}
			}
			
			for (int i = 0; i < size; i++) {
				if (done[i] && !checkedBefore[i]) {
					count += 1;
					checkedBefore[i] = true;
				}
			}
			
			if (count != 0) {
				tmp.add(count);
			}
			
			for (boolean b : checkedBefore) {
				if (!b) {
					allDone = false;
					break;
				}
				allDone = true;
			}
		}
		
		
		int[] result = new int[tmp.size()];
		for (int i = 0; i < tmp.size(); i++) {
			result[i] = tmp.get(i);
		}

        return result;
    }
	
}
