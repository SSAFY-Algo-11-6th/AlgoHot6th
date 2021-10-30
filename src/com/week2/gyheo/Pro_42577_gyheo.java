package com.week2.gyheo;

import java.util.Arrays;
import java.util.HashMap;

public class Pro_42577_gyheo {
	static String[] phone_book = { "119", "97674223", "11955244421" };

	public static void main(String[] args) {
		Arrays.sort(phone_book); // 전화번호 정렬
		// System.out.println(Arrays.toString(phone_book));
		System.out.println(solution(phone_book));
	}

	private static boolean solution(String[] phone_book) {
		HashMap<Integer, String> phone = new HashMap<>();

		for (int i = 0, len = phone_book.length; i < len; i++) {
			phone.put(i, phone_book[i]);
		}

		for (int i = 0, size = phone.size(); i < size - 1; i++) { // 정렬되어있으므로 이웃한 두 경우만 비교하면 된다
			if (phone.get(i + 1).substring(0, phone.get(i).length()).equals(phone.get(i))) {
				return false;
			}
		}

		return true;
	}
}
