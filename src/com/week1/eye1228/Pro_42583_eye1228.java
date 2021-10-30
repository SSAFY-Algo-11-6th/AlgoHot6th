import java.util.LinkedList;
import java.util.Queue;

public class Pro_42583_eye1228 {
	public static void main(String[] args) {
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = {7,4,5,6};
		
		
		System.out.println(solution(bridge_length, weight, truck_weights));
	}
	
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;

		Queue<Integer> q = new LinkedList<>();//도로를 나타내는 queue

		int w = 0;//다리에 있는 무게
		int idx = 0;//인덱스
		while(true) {
			if(idx == truck_weights.length)//마지막 차가 출발하면 끝.
				break;
			
			if(q.size() == bridge_length) {//다리 끝에 차가 도달하면
				w -= q.poll();//무게에서 해당 차 무게 빼기.
			}else if(w + truck_weights[idx] > weight){//다리가 버틸수 있는 무게를 벗어나면
				q.offer(0);//0을 넣는다(차 진행은 해야하니까)
				answer++;//시간 ++
			}else {//다리가 버틸 수 있는 무게라면
				q.offer(truck_weights[idx]);//해당 차를 도로로 넣기.
				w += truck_weights[idx];//무게에 해당 차의 무게를 넣는다.
				answer++;//시간 ++
				idx++;//다음 차를 확인
			}
		}
		
		return answer + bridge_length;//마지막 차가 다리를 건너는 시간까지 추가 해서 리턴
	}
}
