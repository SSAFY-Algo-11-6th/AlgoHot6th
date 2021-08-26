import java.util.ArrayList;

public class Pro_42839_eye1228 {
	
	static int total = 0;
	
	public static void main(String[] args) {
		String numbers = "17";
		System.out.println(solution(numbers));
	}
	
	public static int solution(String numbers) {
        int answer = 0;

		String[] num = numbers.split("");
		boolean[] isSelected = new boolean[num.length];

		ArrayList<Integer> result = new ArrayList<>();

		subset(0, num.length, isSelected, num, result);

		for (Integer i : result) {
			System.out.print(i + " ");
		}

		answer = result.size();
		System.out.println(answer);

		return answer;
    }
    
    public static void subset(int cnt, int leng, boolean[] isSelected, String[] num, ArrayList<Integer> result) {
		if (cnt == leng) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < leng; i++) {
				if (isSelected[i]) {
					sb.append(num[i]);
				}
			}
			if(!sb.toString().equals("")) {
				boolean[] isSelected2 = new boolean[sb.toString().length()];
				char[] per = new char[sb.toString().length()];
				permutation(0, 0, sb.toString(), isSelected2, result, per);
			}
			return;
		}
		isSelected[cnt] = true;
		subset(cnt + 1, leng, isSelected, num, result);

		isSelected[cnt] = false;
		subset(cnt + 1, leng, isSelected, num, result);
	}
    
    public static void permutation(int cnt, int start, String num, boolean[] isSelected, ArrayList<Integer> result,	char[] per) {
		if (cnt == num.length()) {
			if(per[0] == '0')
				return;
			StringBuffer sb = new StringBuffer();
			for(int i = 0; i < cnt; i++) {
				sb.append(per[i]);
			}
			int re = Integer.parseInt(sb.toString());
			for(int i = 2; i < re; i++) {
				if(re % i == 0)
					return;
			}
			cout : if(re != 1) {
				for (Integer i : result) {
					if(re == i)
						break cout;
				}
				result.add(re);
			}
			return;
		}

		for (int i = 0; i < num.length(); i++) {
			if (isSelected[i])
				continue;
			else {
				per[cnt] = num.charAt(i);
				isSelected[i] = true;

				permutation(cnt + 1, i + 1, num, isSelected, result, per);
				isSelected[i] = false;
			}
		}

	}
}
