package dp;
/* 백준 11726(실버 3)
* 2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.
* 첫째 줄에 n이 주어진다. (1 ≤ n ≤ 1,000)
* 첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.
*/


import java.util.Scanner;

//아이디어: D[N] = 2*N 직사각형을 채우는 경우의 수.
// -> D[N] = D[N+1] + 1?
// D[N-1], D[N-2]를 알고 있다는 가정 하에, D[N]을 구해 보면
// D[N] = D[N-1] + D[N-2]라는 사실을 알 수 있다.
public class DP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] results = new int[N+1]; //결과들을 저장할 배열.
        results[0] = 1;
        results[1] = 1;
        if(N == 1){
            System.out.print(1);
        } else{
            for(int i=2; i<N+1; i++){
                results[i] = (results[i-1]+results[i-2]) % 10007;
            }
            System.out.print(results[N]);
        }
        sc.close();
    }
}
