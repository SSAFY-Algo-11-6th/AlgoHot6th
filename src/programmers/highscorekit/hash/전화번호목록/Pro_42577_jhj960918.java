package programmers.highscorekit.hash.전화번호목록;

import java.util.Arrays;

public class Pro_42577_jhj960918 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] phone_book = { "123", "456", "789" };

		System.out.println(solution(phone_book));
	}

	public static boolean solution(String[] phone_book) {
		boolean answer = true;
		Arrays.sort(phone_book);
		for (int i = 0; i < phone_book.length - 1; i++) {
			if (phone_book[i + 1].startsWith(phone_book[i])) {
				answer = false;
				break;
			}
		}
		return answer;

	}
}
