package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 2178
public class Maze {
    static int N;   //행 수
    static int M;   //열 수
    static int[][] maze;
    static boolean[][] visited; //방문여부
    static Queue<int[]> queue;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};    //우상좌하

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maze = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];
        queue = new LinkedList<>();
        //미로 초기화
        for(int i=1; i<N+1; i++){
            String[] s = br.readLine().split("");
            for(int j=1; j<M+1; j++){
                maze[i][j] = Integer.parseInt(s[j-1]);
            }
        }
        FINDWAY(new int[]{1,1});
    }

    static void FINDWAY(int[] position){
        queue.offer(position);
        while(!queue.isEmpty()){
            int[] prev = queue.poll();
            for(int k=0; k<4; k++){
                int nowX = prev[0] + dx[k];
                int nowY = prev[1] + dy[k];     //상하좌우로 이동시켜본다.
                //유효성 검사
                //x,y좌표가 1이상이고 각각 N/M이하이며, 해당 칸이 0이 아니며 방문 전인 경우..
                if(nowX>=1 && nowY >= 1 && nowX<N+1 && nowY<M+1){   //좌표 유효성 검사
                    if(maze[nowX][nowY] != 0 && !visited[nowX][nowY]){ //이동가능 & 방문 여부 검사
                        maze[nowX][nowY] = maze[prev[0]][prev[1]]+1;
                        visited[nowX][nowY] = true;
                        if(nowX == N && nowY == M){
                            System.out.print(maze[nowX][nowY]);
                            break;
                        }
                        queue.offer(new int[]{nowX, nowY});
                    }
                }
            }
        }

    }
}
