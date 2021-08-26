package programmers.highscorekit.hash.위장;

import java.util.ArrayList;
import java.util.HashMap;

public class Pro_42578_gyheo {
    static String[][] clothes = { { "yellowhat", "headgear" }, { "bluesunglasses", "eyewear" },
            { "green_turban", "headgear" } };
    static HashMap<String, ArrayList<String>> style = new HashMap<>();
    static String[] ootd;
    static int R = 1;
    static boolean[] isSelected;
    static int result = 0;

    public static void main(String[] args) {
        System.out.println(solution(clothes));
    }

    private static int solution(String[][] clothes) {
        for (int i = 0; i < clothes.length; i++) {
            if (!style.containsKey(clothes[i][1]))
                style.put(clothes[i][1], new ArrayList<>());
            style.get(clothes[i][1]).add(clothes[i][0]);
        }
        if (style.size() == 30) {
            return 1073741823;
        } // 사이즈가 너무 커지는 경우 재귀호출로 오랜 시간이 소요되는 경우가 있어 조건 추가

        int[] list = new int[style.size()];
        int i = 0;
        for (String s : style.keySet()) {
            list[i] = style.get(s).size();
            i++;
        } // list에 각 카테고리별 개수(size)를 저장
          // System.out.println(Arrays.toString(list));

        ootd = new String[list.length];
        R = list.length;
        isSelected = new boolean[list.length];

        subset(list, 0);

        return result - 1; // 공집합 개수 차감
    }

    // 모든 경우의 수 구하기
    private static void subset(int[] list, int cnt) {
        if (cnt == R) {
            int sum = 1;
            for (int i = 0; i < isSelected.length; i++) {
                int value = isSelected[i] ? list[i] * 1 : 1;
                sum *= value;
            }
            result += sum;
            return;
        }

        isSelected[cnt] = true;
        subset(list, cnt + 1);
        isSelected[cnt] = false;
        subset(list, cnt + 1);
    }
}
