package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS {
    //상하좌우로 이동시킬 수 있는 x,y좌표 배열 설정
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static int[][] A;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for(int j=0; j<M; j++){
                //지도 배열 세팅
                A[i][j] = Integer.parseInt(line.substring(j, j+1));
            }
        }
        BFS(0, 0);
        System.out.println(A[N][M]);
    }

    private static void BFS(int i, int j){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        while(!queue.isEmpty()){
            int now[] = queue.poll(); //현재의 자리를 뽑음.
            visited[i][j] = true;
            //상하좌우 구현.
            for(int k=0; k<4; k++){
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                //유효성 검사...
                if(x >= 0 && y >= 0 && x<N && y<M){
                    if(A[x][y]!=0 && !visited[x][y]){ //0이여서 갈 수 없거나 이미 방문한 칸이면 안 됨.
                        visited[x][y] = true;
                        A[x][y] = A[now[0]][now[1]] + 1; //depth를 입력한다.
                        queue.add(new int[]{x,y});
                    }
                }
            }
        }
    }
}
