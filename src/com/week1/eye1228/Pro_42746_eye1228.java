import java.util.Arrays;

public class Pro_42746_eye1228 {
	public static void main(String[] args) {
		
		int[] numbers = {6, 10, 2};
		
		String result = solution(numbers);
		System.out.println(result);
	}
	
	
	public static String solution(int[] numbers) {
		StringBuffer sb = new StringBuffer();
        String answer = "";
        int len = numbers.length;
        
        String[] num = new String[len];
        
        //정렬해서 가장 큰 수를 만든다.
        //가장 큰 수 란? 가장 앞자리가 클 수록 큰 수다.
        //그 다음 자리 수를 또 비교하고 또 비교하고 이렇게 해서 정렬한다.
        
        for(int i = 0; i < len; i++) {
        	String result = Integer.toString(numbers[i]);
        	while(result.length() < 4) {//자릿수를 맞춘다.
        		result = result.concat(result);
        	}
        	num[i] = result;
        }
        
        Arrays.sort(num);//오름차순인데.....역순으로 넣어야지
        
        for(int i = len - 1; i >= 0; i--) {//되돌리기 시작
        	cout : for(int j = 0; j < num[i].length(); j++) {
        		if(j == 0) {//첫째자리일 때
        			sb.append(num[i].charAt(0));//sb에 추가
        		}else if(num[i].charAt(0) != num[i].charAt(j)) {//첫째자리랑 다른 수 일 때
        			sb.append(num[i].charAt(j));//추가
        		}else {//j=0이 아니고, 첫번째 자리랑 같으면
        			break cout;
        		}
        	}
        }
        answer = sb.toString();
        
        return answer;
    }
}