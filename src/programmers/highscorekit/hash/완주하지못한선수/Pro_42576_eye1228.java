import java.util.HashMap;
import java.util.Map.Entry;

public class Pro_42576_eye1228 {
	public static void main(String[] args) {
		String[] participant = { "leo", "kiki", "eden" };
		String[] completion = { "eden", "kiki" };
		
		System.out.println(solution(participant, completion));
	}

	public static String solution(String[] participant, String[] completion) {
		String answer = "";

		HashMap<String, Integer> map = new HashMap<>();

		for (String human : participant) {
			map.put(human, map.getOrDefault(human, 0) + 1);
		}

		for (String comp : completion) {

			// 같은 문자열을 찾아 value의 값을 -1해줌
			map.put(comp, map.get(comp) - 1);
		}

		for (Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() > 0) {
				answer = entry.getKey();
				break;
			}
		}

		return answer;
	}
}
