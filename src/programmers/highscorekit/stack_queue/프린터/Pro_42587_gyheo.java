package programmers.highscorekit.stack_queue.프린터;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Pro_42587_gyheo {
    static int[] priorites = { 1, 2, 3, 1 };
    static int location = 2;
    static List<Document> list = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(solution(priorites, location));
    }

    private static int solution(int[] priorities, int location) {
        int answer = 0;
        for (int i = 0; i < priorities.length; i++) {
            list.add(new Document(i, priorities[i]));
        }

        while (list.size() != 0) {
            boolean flag = false;
            int size = list.size();

            for (int i = 1; i < size; i++) {
                if (list.get(0).priority < list.get(i).priority) {
                    Document doc = list.get(0);
                    list.remove(0); // 첫번째를 빼서
                    list.add(doc); // 마지막에 넣는다
                    flag = true;
                    break;
                }
            }

            if (flag)
                continue;

            answer++;
            if (list.get(0).location == location) {
                break;
            }
            list.remove(0);
        }

        return answer;
    }

    static class Document {
        int location; // 위치
        int priority; // 우선순위

        public Document(int location, int priority) {
            this.location = location;
            this.priority = priority;
        }
    }
}
