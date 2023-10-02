package graph;
/* 백준 1058 (실버 2)
* 지민이는 세계에서 가장 유명한 사람이 누구인지 궁금해졌다. 가장 유명한 사람을 구하는 방법은 각 사람의 2-친구를 구하면 된다.
* 어떤 사람 A가 또다른 사람 B의 2-친구가 되기 위해선, 두 사람이 친구이거나, A와 친구이고, B와 친구인 C가 존재해야 된다.
* 여기서 가장 유명한 사람은 2-친구의 수가 가장 많은 사람이다. 가장 유명한 사람의 2-친구의 수를 출력하는 프로그램을 작성하시오.
*
* A와 B가 친구면, B와 A도 친구이고, A와 A는 친구가 아니다.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FloydWarshall {
    static int N;  //사람 수
    static int[][] isFriend;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        isFriend = new int[N][N]; // 리스트 선언
        //인접행렬 초기화
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(i!=j){
                    isFriend[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        //그래프 데이터 저장
        for(int i=0; i<N; i++){
            String[] s = br.readLine().split("");
            for(int j=0; j<N; j++){
                if(s[j].equals("Y")){
                    isFriend[i][j] = 1;
                }
            }
        }

        //점화식 사용
        for(int k=0; k<N; k++){             //경유지
            for(int s=0; s<N; s++){         //출발지
                for(int e=0; e<N; e++){     //도착지
                    isFriend[s][e] = Math.min(isFriend[s][e], isFriend[s][k]+isFriend[k][e]);
                }
            }
        }

        int[] count = new int[N];   //2-친구 수 저장
        int answer = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(isFriend[i][j] <= 2){
                    count[i]++;
                }
            }
            answer = Math.max(answer, count[i]);
        }
        System.out.println(answer);




    }

}
