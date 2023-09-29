package bfs;

import java.util.*;
public class BFSExample {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public int solution(int[][] maps) {
        int n = maps[0].length; //가로 길이
        int m = maps.length;    //세로 길이
        boolean[][] visited = new boolean[n][m]; //방문여부 확인
        Queue<int[]> queue = new LinkedList<>(); //BFS 구현을 위한 Queue 선언
        queue.offer(new int[]{0, 0}); //시작점 지정
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            //상하좌우 구현.
            for(int k=0; k<4; k++){
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                //유효성 검사
                if(x >= 0 && y >= 0 && x<n && y<m){
                    if(maps[x][y] != 0 && !visited[x][y]){
                        visited[x][y] = true;
                        maps[x][y] = maps[now[0]][now[1]] + 1;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }
        return (maps[n-1][m-1] == 1)? -1 : maps[n-1][m-1];
    }

    public static void main(String[] args){
        BFSExample example = new BFSExample();
        int[][] param = new int[5][5];
        param[0] = new int[]{1,0,1,1,1};
        param[1] = new int[]{1,0,1,0,1};
        param[2] = new int[]{1,0,1,1,1};
        param[3] = new int[]{1,1,1,0,0};
        param[4] = new int[]{0,0,0,0,1};
        System.out.println(example.solution(param));

        boolean[] booleans = new boolean[6];
        for(boolean b: booleans){
            System.out.println(b);
        }
    }
}
