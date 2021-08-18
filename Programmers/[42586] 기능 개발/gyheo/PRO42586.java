package com.programmers;

import java.util.*;

public class PRO42586 {
    static Stack<Integer> stack = new Stack<>();
    static final int GOAL = 100;
    static int[] progresses = {93, 30, 55};
    static int[] speeds = {1, 30, 5};

    public static void main(String[] args) {
        int[] res = solution(progresses, speeds);
        System.out.println(Arrays.toString(res));
    }

    private static int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> days = new ArrayList<>();
        for (int i = 0, size = progresses.length; i < size; i++) {
            int dayCount = 0;
            for (int j = progresses[i]; j < GOAL; j += speeds[i]) {
                dayCount++;
            }
            days.add(dayCount);
        } // 작업 속도 계산

        ArrayList<Integer> dList = new ArrayList<>();

        while (days.size() != 0) {
            int releaseCnt = 0;
            if (stack.isEmpty()) { // 맨 처음 작업 속도 push
                stack.push(days.get(0));
                days.remove(0);
                releaseCnt++;
            }

            // stack.peek()을 사용했을 때 TC 오류 발생
            while (!stack.isEmpty() &&  days.size() != 0 && stack.get(0) >= days.get(0)) {
                stack.push(days.get(0));
                days.remove(0);
                releaseCnt++;
            } // 맨 처음 작업속도보다 이전에 끝난 작업들을 계속해서 push

            int cnt = 0;
            while (releaseCnt-- != 0) { // 릴리즈 가능한 개수만큼 pop
                stack.pop();
                cnt++;
            }

            dList.add(cnt);
        } // 작업속도를 저장한 days의 ArrayList를 Stack에 옮기면서 반복

        // ArrayList를 배열로
        int[] answer = new int[dList.size()];

        int idx = 0;
        for (int day : dList) {
            answer[idx++] = day;
        }

        return answer;
    }
}
