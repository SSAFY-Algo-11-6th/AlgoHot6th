import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Pro_42586_eye1228 {
	public static void main(String[] args) {
		
		int[] progresses = {93, 30, 55};
		int[] speeds = {1, 30 ,5};
		int[] answer = solution(progresses, speeds);
		
		System.out.println(Arrays.toString(answer));
	}
	
	
	
	public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        
        int len = progresses.length;
        
        for(int i = 0; i < len; i++){
            int day = 1;
            int pro = progresses[i];
            while(pro < 100){
                pro += speeds[i];
                day++;
            }
            
            if(!q.isEmpty() && q.peek() < day){//q가 비어있지 않거나, 이전까지 들어온 것들보다 크면
                result.add(q.size());//같은 시간이 걸리는 것들 작업들의 수를 넣는다.
                q.clear();//다 썼으니까 클리어
            }
            
            q.offer(day);//암것도 아니면 추가
        }
        
        result.add(q.size());//마지막 작업들
        
        int[] answer = new int[result.size()];//ArrayList그대로 못 return하니까
        
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}
