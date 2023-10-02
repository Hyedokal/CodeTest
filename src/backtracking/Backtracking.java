package backtracking;

import java.util.ArrayList;
import java.util.Scanner;

/*
*백준 15649
*자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
*
*1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
*/

/*
* 1. 아이디어
*  - 백트래킹 재귀함수 안에서, for문을 돌면서 숫자를 선택(이 때 방문여부 확인)
*  - 재귀함수에서 N개를 선택할 경우 print
*
* 2. 시간복잡도
*  - 중복이 불가하므로 N! -> N<=10일 때까지 가능
*
* 3. 자료구조
*  - boolean[]: 방문여부 체크, int[]: 값 저장
* */
public class Backtracking {
    static int[] answer;
    static int N;
    static int M;
    static int Depth;
    static boolean[] check;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        answer = new int[M];
        check = new boolean[N+1];
        recur(0);
    }

    private static void recur(int Depth){
        //재귀 깊이가 M과 같아지면 탐색 과정에서 담았던 배열 출력
        if(Depth == M){
            for(int i : answer){
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for(int k=1; k<check.length; k++){
            //해당 노드(값)을 방문하지 않았다면...
            if(!check[k]){
                check[k] = true;
                answer[Depth] = k;
                recur(Depth +1);

                //자식노드 방문이 끝나고 돌아오면 방문노드를 방문하지 않은 상태로 변경
                check[k] = false;
            }
        }
    }
}
