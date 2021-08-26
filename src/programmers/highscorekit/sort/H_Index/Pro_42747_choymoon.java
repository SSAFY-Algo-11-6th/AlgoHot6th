package com.ssafy.algo;

import java.util.Arrays;

// H-Index
// 해설 참고
public class Pro_42747_choymoon {

	public static void main(String[] args) {
		Pro_42747_choymoon pro = new Pro_42747_choymoon();
		System.out.println(pro.solution(new int[] {3, 0, 6, 1, 5}));
	}
	
	public int solution(int[] citations) {
        int answer = 0;
        int n = citations.length;
        
        Arrays.sort(citations);
        for (int i = 0; i < n; i++) {
        	int temp = n - i;
        	if (temp <= citations[i]) {
        		answer = temp;
        		break;
        	}
        }
        
        return answer;
    }
}
