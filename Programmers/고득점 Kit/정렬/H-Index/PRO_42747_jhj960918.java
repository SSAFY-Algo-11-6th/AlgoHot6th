package programmers.sort;

import java.util.Arrays;

public class PRO_H_Index {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] citations = { 3, 0, 6, 1, 5 };
	
		System.out.println(solution(citations));
	}

	static public int solution(int[] citations) {
		int answer = 0;
		Arrays.sort(citations);
		//정렬 후 앞에서부터 검사하여 처음 h-index가 성립한 순간을 리턴
		for (int i = 0; i < citations.length; i++) {
			// h를 줄여가면서 검사
			int h = citations.length - i;
			System.out.println(h);
			if (citations[i] >= h) {
				answer = h;
				break;
			}
		}
		return answer;

	}

}
