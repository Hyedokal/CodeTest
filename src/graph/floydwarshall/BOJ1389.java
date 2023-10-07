package graph.floydwarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1389 {
    static int N;  //노드 수
    static int M;   //에지 수
    static int MAX = 99999;
    static int[][] matrix; //인접행렬
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        matrix = new int[N+1][N+1];
        //인접행렬 초기화
        for(int i=1; i<N+1; i++){
            for(int j=1; j<N+1; j++){
                if(i != j){
                    matrix[i][j] = MAX;
                }
            }
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            matrix[s][e] = 1;
            matrix[e][s] = 1;
        }
        br.close();

        //플로이드워셜
        for(int k=1; k<N+1; k++){
            for(int s=1; s<N+1; s++){
                for(int e=1; e<N+1; e++){
                    matrix[s][e] = Math.min(matrix[s][e], matrix[s][k]+matrix[k][e]);
                }
            }
        }

        //정답 출력
        int min = Integer.MAX_VALUE;
        int Answer = -1;
        for(int i=1; i<N+1; i++){
            int temp = 0;
            for(int j=1; j<N+1; j++){
                temp += matrix[i][j];
            }
            if(min > temp){
                min = temp;
                Answer = i;
            }
        }
        System.out.print(Answer);
    }
}
