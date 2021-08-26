package programmers.highscorekit.hash.위장;

import java.util.HashMap;

public class Pro_42578_jhj960918 {

	public static void main(String[] args) {
		String[][] clothes = { { "yellowhat", "headgear" }, { "bluesunglasses", "eyewear" },
				{ "green_turban", "headgear" } };

		String[][] clothes2 = { { "yellowhat", "face" }, { "bluesunglasses", "face" }, { "green_turban", "face" },
				{ "zz", "zz" } };

		solution(clothes);
		solution(clothes2);
	}

	public static int solution(String[][] clothes) {
		int answer = 1;
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < clothes.length; i++) {
			System.out.println(clothes[i][1]);
			map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
		}
		System.out.println(map);
		for (int i : map.values()) {
			answer *= (i + 1);
			
		}

		System.out.println(answer-1);
		return answer-1;
	}
}
