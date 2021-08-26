
public class Pro_43165_eye1228 {
	public static void main(String[] args) {
		int[] numbers = {1, 1, 1, 1, 1};
		int target = 3;
		
		System.out.println(solution(numbers, target));
	}
	
	public static int solution(int[] numbers, int target) {
        int answer = 0;
        
        answer = search(numbers, target, 0, 0);// + search(numbers, target, -numbers[0], 1);
        
        
        return answer;
    }
    
    public static int search(int[] numbers, int target, int sum, int i){
        if(i == numbers.length){
            if(sum == target){
                return 1;
            }else{
                return 0;
            }
        }else{
            
            int result = 0;
            result += search(numbers, target, sum + numbers[i], i+1);
            result += search(numbers, target, sum - numbers[i], i+1);
            return result;
        }
    }
}
