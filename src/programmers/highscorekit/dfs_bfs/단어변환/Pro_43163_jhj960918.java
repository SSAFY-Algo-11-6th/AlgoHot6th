package programmers.highscorekit.dfs_bfs.단어변환;

public class Pro_43163_jhj960918 {
	static boolean[] transferIdx;
	static int count = 0;

	public static void main(String[] args) {
		String[] words = { "hot", "dot", "dog", "lot", "loo", "cog" };
		System.out.println(solution("hit", "cog", words));
		String[] wordss = { "hot", "dot", "dog", "lot", "log" };
		System.out.println(solution("hit", "cog", wordss));
	}

	public static int solution(String begin, String target, String[] words) {
		transferIdx = new boolean[begin.length()];
		int answer = 0;
		
		for (int i = 0; i < words.length; i++) {

			begin = dfs(begin, words[i], target);

			if (begin.equals(target)) {
				System.out.println("Zzz");
				answer = count ;
				break;
			}

		}
		return answer;
	}

	private static String dfs(String begin, String word, String target) {
		for (int i = 0; i < target.length(); i++) {
			if (target.charAt(i) != word.charAt(i) && !transferIdx[i]) {
				transferIdx[i] = true;
				begin = begin.substring(0, i) + word.charAt(i) + begin.substring(i + 1);
				System.out.println(word);
				count++;
				return begin;
			}
		}

		return begin;
	}

}
