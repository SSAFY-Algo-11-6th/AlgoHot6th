import java.util.HashMap;

public class Pro_42577_eye1228 {
	public static void main(String[] args) {
		String[] phone_book = {"119", "97674223", "1195524421"};
		System.out.println();
		System.out.println(solution(phone_book)); 
	}
	
	public static boolean solution(String[] phone_book) {
        boolean answer = true;
        
        HashMap<String, Integer> h = new HashMap<>();
        
        for(int i = 0; i < phone_book.length; i++)
            h.put(phone_book[i], i);
        
        for(int i = 0; i < phone_book.length; i++){
            for(int j = 1; j < phone_book[i].length(); j++){
                if(h.containsKey(phone_book[i].substring(0,j))){
                    return false;
                }
            }
        }
        
        return answer;
    }
}
