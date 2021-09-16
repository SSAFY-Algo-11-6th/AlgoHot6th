package programmers.highscorekit.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Pro_1844_jhj960918 {
	public static void main(String[] args) {
		int[][] maps = { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 1 },
				{ 0, 0, 0, 0, 1 } };

		System.out.println(solution(maps));
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static int solution(int[][] maps) {
		int n = maps.length;
		int m = maps[0].length;//row 구하는 공식
		
		boolean[][] visit = new boolean[n][m];
		Queue<Dot> q = new LinkedList<Dot>();
		int[][] dist = new int[n][m];
		dist[0][0] = 1;
		visit[0][0] = true;
		q.offer(new Dot(0, 0));
		while (!q.isEmpty()) {
			Dot dot = q.poll();
			for (int i = 0; i < 4; i++) {
				int px = dot.x + dx[i];
				int py = dot.y + dy[i];
				if (px >= 0 && px < n && py >= 0 && py < m && maps[px][py] == 1 && !visit[px][py]) {
					visit[px][py] = true;
					dist[px][py] = dist[dot.x][dot.y] + 1;
					if (px == n-1 && py == m-1) {
						break;
					}
					q.offer(new Dot(px, py));
				}
			}
		}

		return dist[n-1][m-1] > 0 ? dist[n-1][m-1] : -1;
	}

	static class Dot {
		int x;
		int y;

		public Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
