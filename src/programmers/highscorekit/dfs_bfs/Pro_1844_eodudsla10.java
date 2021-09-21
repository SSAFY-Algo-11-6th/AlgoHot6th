import java.util.LinkedList;
import java.util.Queue;

public class Pro_1844_eodudsla10 {
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,1,-1,0};
	static boolean[][] visit;
	static int n, m;
    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        System.out.println(solution(maps));
    }

    public static int solution(int[][] maps){
        n = maps.length;
        m = maps[0].length;
        visit = new boolean[n][m];
        return bfs(0,0,maps);
    }

    public static int bfs(int x,int y, int[][] maps){
        Queue<Node> q = new LinkedList<>();
        //현재 노드를 방문처리
        q.offer(new Node(x,y,1));
        visit[x][y] = true;

        //큐가 빌때까지 반복
        while(!q.isEmpty()){
            Node node = q.poll();
            if(node.x == n-1 && node.y == m-1)	//도착했을때
            	return node.meter;
            
            for(int i = 0; i<4;i++){	//사방탐색
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if(nx>=0 && ny>=0 && nx<n && ny<m){	//아래 , 오른쪽
                    if(maps[nx][ny]==1 &&!visit[nx][ny]){
                        visit[nx][ny] = true;
                        q.offer(new Node(nx,ny, node.meter+1));
                    }
                }
            }
        }
        return -1;	//큐가 순회할때까지 목적지에 도착하지 못한경우 갈수 없음 -> -1 반환
    }

    public static class Node{
        int x;
        int y;
        int meter;

        public Node(int x, int y, int meter){
            this.x = x;
            this.y = y;
            this.meter = meter;
        }
    }
}