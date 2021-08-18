package com.day12;

import java.util.LinkedList;
import java.util.Queue;

public class PRO_다리를지나는트럭 {
	
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		Queue<Integer> queue = new LinkedList<>();
		int truck_num =0;	//truck_weights 배열에 수 참조 = 다리에 올라간 트럭의 수 
		int temp =0;	//다리위에 있는 트럭 무게
		int answer =0;	//걸린 시간
		while(true) {
			if(truck_num == truck_weights.length)	//종료조건 : 트럭이 다리에 다 올라가면 종료
				break;
			
			if(queue.size() == bridge_length)	//큐에 들어있는수가 다리에 올라갈수 있는 트럭수와 같아졌을때
				temp -= queue.poll();	//다리위에 있는 무게에서 먼저 들어온 순서대로 빼서 다리를 건너게 한다.
			else if(truck_weights[truck_num] + temp > weight) {	//다리위에 있는 트럭무게 + 다리에 올릴 트럭 무게가 다리가 견딜 수 잇는 무게보다 클 경우
				queue.offer(0);	// 큐에 0을 넣는다(무게 0을 추가(형식적인 수)
				answer++;	//시간을 추가한다.
			}else {		//위에 2가지 경우가 아닐 때
				queue.offer(truck_weights[truck_num]);	//큐에 다리위에 올릴 트럭의 무게를 더한다.
				temp +=truck_weights[truck_num];	//다리위에 있는 트럭의 무게를 더한다.
				answer++;		//시간 추가
				truck_num++;	//다리위에 트럭을 올렸으니 값 추가
			}
				
		}
		return answer + bridge_length;	//마지막 트럭이 다리에 올라간 상태에서 다리의 길이를 더해준다
										//모든 트럭이 통과하는데 걸린 시간.
		
	}
}