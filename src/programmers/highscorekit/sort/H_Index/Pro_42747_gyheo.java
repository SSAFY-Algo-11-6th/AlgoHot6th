package programmers.highscorekit.sort.H_Index;

import java.util.Arrays;

public class Pro_42747_gyheo {
    static int[] citations = { 3, 0, 6, 1, 5 };

    public static void main(String[] args) {
        System.out.println(solution(citations));
    }

    public static int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        // 출판된 논문수에서 차감하면서 h 탐색
        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;

            if (citations[i] >= h) {
                answer = h; // 탐색 후 반복 종료
                break;
            }
        }
        return answer;
    }
}
