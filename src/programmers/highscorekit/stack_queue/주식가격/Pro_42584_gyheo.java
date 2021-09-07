package programmers.highscorekit.stack_queue.주식가격;

import java.util.*;

public class Pro_42584_gyheo {
    static int[] prices = { 1, 2, 3, 2, 3 };

    public static void main(String[] args) {
        solution(prices);
    }

    private static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(prices[i]);

            int j = i + 1;
            while (j < prices.length) {
                if (queue.peek() <= prices[j]) {
                    queue.offer(prices[j]);
                } else {
                    queue.offer(prices[j]);
                    break;
                }
                j++;
            }

            answer[i] = queue.size() - 1;
        } // 데이터 입력
        System.out.println(Arrays.toString(answer));

        return answer;
    }
}
