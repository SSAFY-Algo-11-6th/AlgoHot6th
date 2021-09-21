
public class Pro_42883_eodudsla10 {

	static String number = "4177252841";
	static int k = 4;

	public static void main(String[] args) {

		System.out.println(solution(number, k));

	}

	public static String solution(String number, int k) {
		int idx = 0;
		char max;
		StringBuilder answer = new StringBuilder();
//		#만약 리턴해야하는 값이 4자리의 수라면, 입력값에서 맨뒤의 3자리를 제외한 문자열 부분에서 가장 큰 수를 찾는다.
//		그리고나서 큰 수를 찾은 자리 이후 부터 마지막 2자리를 제외한 곳에서 큰값을 찾는다.
//		이 과정을 반복하면 된다. 
//		ex) 5678543 => 5,6,7,8중 가장 큰 수 8 
		for (int i = 0; i < number.length() - k; i++) {
			max = '0';	//초기화
			for (int j = idx; j <= k + i; j++) {
				if (max < number.charAt(j)) {
					max = number.charAt(j);
					idx = j + 1;
				}
			}
			answer.append(max);
		}
		return answer.toString();
	}

}
