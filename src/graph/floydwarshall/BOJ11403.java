package graph.floydwarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11403 {
    static int N;
    static int[][] matrix; //인접행렬
    static int[][] answer;
    static int MAX = 999999999;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        matrix = new int[N+1][N+1];
        answer = new int[N+1][N+1];
        for(int i=1; i<N+1; i++){ //인접행렬 초기화
            String[] s = br.readLine().split(" ");
            for(int j=1; j<N+1; j++){
                matrix[i][j] = Integer.parseInt(s[j-1]);
            }
        }
        //정답 행렬 초기화
        for(int i=1; i<N+1; i++){
            for(int j=1; j<N+1; j++){
                if(matrix[i][j] == 1) {
                    answer[i][j] = 1;
                } else {
                    answer[i][j] = MAX;
                }
            }
        }
        //플로이드워셜
        for(int k=1; k<N+1; k++){
            for(int s=1; s<N+1; s++){
                for(int e=1; e<N+1; e++){
                    answer[s][e] = Math.min(answer[s][e], answer[s][k] + answer[k][e]);
                }
            }
        }

        for(int i=1; i<N+1; i++){
            for(int j=1; j<N+1; j++){
                if(answer[i][j] < MAX){
                    System.out.print(1 + " ");
                } else{
                    System.out.print(0 + " ");
                }
            }
            System.out.println();
        }
    }
}
