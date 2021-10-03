package programmers.highscorekit.dfs_bfs.네트워크;

import java.util.Arrays;
import java.util.HashSet;

public class Pro_43162_gyheo {
    static int n = 3;
    static int[] parents;
    static int[][] data = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static boolean[][] visited;

    public static void main(String[] args) {
        System.out.println(solution(n, data));
    }

    private static int solution(int n, int[][] computers) {
        make();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (data[i][j] == 1 && data[j][j] == 1) {
                    union(i + 1, j + 1);
                }
            }
        }
        HashSet<Integer> set = new HashSet<>();
        System.out.println(Arrays.toString(parents));
        for (int i = 1; i <= n; i++) {
            set.add(parents[i]);
        }

        return set.size();
    }

    private static void make() {
        parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i; // 모든 원소를 자신을 대표자로 만듦
        }
    }

    private static int find(int a) {
        if (a == parents[a])
            return a;
        return parents[a] = find(parents[a]);
    }

    private static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot == bRoot) {
            return false;
        }

        parents[bRoot] = aRoot;
        return true;
    }
}
