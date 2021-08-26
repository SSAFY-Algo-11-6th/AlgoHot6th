package com.ssafy.algo;

import java.util.HashMap;
import java.util.HashSet;

// 완주하지 못한 선수
// 효율성 한개 통과 못함 (맨 마지막)
public class Pro_42576_choymoon {

	public static void main(String[] args) {
		Pro_42576_choymoon pro = new Pro_42576_choymoon();
		System.out.println(pro.solution(new String[] {"leo", "kiki", "eden"}, new String[] {"eden", "kiki"}));
	}
	
	// 배열 정렬로 가능
	// 해시맵 하나 쓰는것도 통과 가능
	public String solution(String[] participant, String[] completion) {
        HashSet<String> comp = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> pmap = new HashMap<>();
        
        // HashSet에 끝마친 선수 명단 넣음.
        // HashSet은 중복을 허락하지 않기 때문에, 동명의 선수를 판별할 수 없음 -> HashMap 이용
        for (String c : completion) {
        	comp.add(c);
        	if (map.get(c) != null)
        		map.put(c, map.get(c) + 1);
        	else
        		map.put(c, 1);
        }
        
        // HashSet안에 포함되어있는 경우를 대비 참가자의 HashMap 생성
        for (String p : participant) {
        	if (pmap.get(p) != null)
        		pmap.put(p, pmap.get(p) + 1);
        	else
        		pmap.put(p, 1);
        	if (!comp.contains(p)) // 끝마친 선수 명단에 없다면 그 선수 이름 리턴
        		return p;
        }
        
        for (String c : completion) {
        	if (map.get(c) != pmap.get(c)) // 참가자와 끝마친 선수의 수가 다른 경우 -> 동명의 선수 한명이 못들어옴
        		return c; // 그 선수 이름 리턴
        }
        
        // 테스트 케이스가 잘못 들어온 경우 아니면 리턴 안되지만 메소드 구성을 위한 리턴.
        return "";
    }
}
