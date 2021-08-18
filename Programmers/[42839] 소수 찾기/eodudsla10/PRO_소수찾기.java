package com.day12;

import java.util.LinkedList;

public class PRO_소수찾기 {
	static int answer =0;		//소수의 개수
	static boolean[] check = new boolean[7];	//numbers의 몇 번째 인덱스에 방문했는지 여부를 체크하는 배열.
	static LinkedList<Integer> arr = new LinkedList<>();	//만들어진 조합을 저장 
	static String numbers;
	public static void main(String[] args) {
		numbers = "17";
		solution(numbers);
		System.out.println(answer);
	}
	
	public static void permu(String str,String temp, int idx) {	//순열로 모든 경우의 수 탐색
		if(temp.length() == idx) {
			if(!arr.contains(Integer.parseInt(temp)))
				arr.add(Integer.parseInt(temp));
			return;
		}
		
		// 4. n으로 전달 된 numbers를 탐색.
        for(int j =0;j<str.length();j++){
            
            if(check[j]) // 5. 이미 방문했으면 pass
            	continue;
            
            temp += str.charAt(j); // 6. temp에 저장하며 숫자를 조합
            check[j] = true;
            permu(str,temp,idx);
            check[j] = false; // 9. 조합이 완료되면  인덱스를 false로 변경하여 다음 숫자를 조합
            
            
            temp = temp.substring(0,temp.length()-1); //temp 변수에서 마지막 자리의 숫자를 제외하고 갱신.

        }                      
    }
	
	public static void find(int n) {	//소수 찾기
		if(n ==0)
			return;
		if(n ==1)
			return;
		for (int i = 2; i <= Math.sqrt(n); i++) {	//나누어 떨어지면 소수이므로 종료
			if(n%i ==0)
				return;
		}
		answer++;	//나누어 안 떨어지면 소수가 아니므로 카운트 세기
	}

	public static int solution(String numbers) {
        String temp="";
        
        
        for(int i = 1;i<=numbers.length();i++){ // 몇 자리의 수를 만들 지에 대한 반복(순열)
            permu(numbers,temp,i);
        }
        
      
        for(int x : arr){         // 만든 수가 담긴 리스트 탐색.      
           
        	find(x); //소수인지 판별.
        }
        
        return answer;
	}
}
